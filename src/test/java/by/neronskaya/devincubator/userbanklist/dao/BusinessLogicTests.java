package by.neronskaya.devincubator.userbanklist.dao;

import by.neronskaya.devIncubator.dao.DAOFactory;
import by.neronskaya.devIncubator.dao.GenericDAO;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.domain.User;
import by.neronskaya.devIncubator.mysql.MySqlDAOFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Connection;
import java.sql.SQLException;

public class BusinessLogicTests {

    private GenericDAO dao;

    private Connection connection;

    private static final DAOFactory<Connection> factory = new MySqlDAOFactory();

    @BeforeEach
    void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
    }

    @ParameterizedTest
    @ValueSource(ints = 5)
    void isUserGotByPK(int userId) throws PersistException {
        dao = factory.getDAO(connection, User.class);
        User user = (User) dao.getByPK(userId);
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void areAllAccountGot() throws PersistException {
        dao = factory.getDAO(connection, Account.class);
        int expectedAccountNumber = dao.getFieldNumber();
        int actualAccountNumber = dao.getAll().size();
        System.out.println(String.format("Expected Account number from DB = %s\nActual Account number = %s",
                expectedAccountNumber, actualAccountNumber));
        Assertions.assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.rollback();
        connection.close();
    }
}