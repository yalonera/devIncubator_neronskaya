package by.neronskaya.devIncubator.mysql;

import by.neronskaya.devIncubator.dao.DAOFactory;
import by.neronskaya.devIncubator.dao.GenericDAO;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDAOFactory implements DAOFactory<Connection> {

    @Override
    public Connection getContext() throws PersistException {
        Connection connection;
        try {
            //Логин пользователя
            String user = "root";
            //Пароль пользователя
            String password = "8008";
            //URL адрес
            String url = "jdbc:mysql://localhost:3306";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public GenericDAO getDAO(Connection connection, Class dtoClass) throws PersistException {

        if (dtoClass == User.class) {
            return new MySqlUserDAO(connection);
        } else if (dtoClass == Account.class) {
            return new MySqlAccountDAO(connection);
        } else {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }


    }

}
