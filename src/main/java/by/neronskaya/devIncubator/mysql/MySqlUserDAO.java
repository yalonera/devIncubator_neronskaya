package by.neronskaya.devIncubator.mysql;

import by.neronskaya.devIncubator.dao.AbstractJDBCDao;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlUserDAO extends AbstractJDBCDao<User, Integer> {
    public MySqlUserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM userbanklist.user";
    }

    @Override
    public String getSelectCountQuery() {
        return "SELECT COUNT (*) FROM userbanklist.user";
    }

    @Override
    protected List<User> parseResult(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setSureName(rs.getString("sureName"));
                user.setBirthday(rs.getDate("birthday"));
                user.setTelephone(rs.getInt("telephone"));
                user.setCountryCode(rs.getString("countryCode"));
                user.setEmail(rs.getString("email"));
                user.setAddressRegistration(rs.getString("addressRegistration"));
                user.setAddressResidence(rs.getString("addressResidence"));
                user.setPassportNo(rs.getString("passportNo"));
                user.setNationality(rs.getString("nationality"));
                result.add(user);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

}
