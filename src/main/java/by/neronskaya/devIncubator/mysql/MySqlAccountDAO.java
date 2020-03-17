package by.neronskaya.devIncubator.mysql;

import by.neronskaya.devIncubator.dao.AbstractJDBCDao;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.utils.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlAccountDAO extends AbstractJDBCDao<Account, Integer> {
    public MySqlAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM userbanklist.account";
    }

    @Override
    public String getSelectCountQuery() {
        return "SELECT COUNT(*) AS fields FROM userbanklist.account";
    }

    @Override
    protected List<Account> parseResult(ResultSet rs) throws PersistException {
        LinkedList<Account> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt("accountID"));
                account.setUserID(rs.getInt("userID"));
                account.setAccountCurrency(rs.getString("accountCurrency"));
                account.setType(rs.getString("type"));
                account.setStatus(rs.getString("status"));
                account.setCashback(rs.getInt("cashback"));
                account.setRefundable(rs.getBoolean("isRefundable"));
                account.setCredit(rs.getInt("credit"));
                account.setDateOfCreation(Util.convert(rs.getDate("dateOfCreation")));
                account.setDateOfExpiration(rs.getInt("dateOfExpiration"));
                account.setBalance(rs.getInt("balance"));
                result.add(account);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }
}
