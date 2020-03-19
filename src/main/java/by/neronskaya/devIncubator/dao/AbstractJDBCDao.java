package by.neronskaya.devIncubator.dao;

import by.neronskaya.devIncubator.domain.Identifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractJDBCDao<T extends Identifier, PK extends Integer> implements GenericDAO<T, PK> {
    private Connection connection;

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract String getSelectCountQuery();

    protected abstract List<T> parseResult(ResultSet rs) throws PersistException;

    @Override
    public T getByPK(Integer key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql = sql + " WHERE userID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResult(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            throw new PersistException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResult(rs);

        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    public int getFieldNumber() throws PersistException {
        int result = 0;
        String sql = getSelectCountQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = rs.getInt("fields");
            }

        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

}
