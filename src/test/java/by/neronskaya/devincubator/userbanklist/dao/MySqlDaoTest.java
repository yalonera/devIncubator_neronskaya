package by.neronskaya.devincubator.userbanklist.dao;

import by.neronskaya.devIncubator.dao.DAOFactory;
import by.neronskaya.devIncubator.dao.GenericDAO;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.mysql.MySqlDAOFactory;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

public class MySqlDaoTest extends GenericDaoTest<Connection> {
    private Connection connection;

    private GenericDAO dao;

    private static final DAOFactory<Connection> factory = new MySqlDAOFactory();

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {Account.class, new Account()},
                {User.class, new User()}
        });
    }

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
        dao = factory.getDAO(connection, daoClass);
    }

    @After
    public void tearDown() throws SQLException {
        context().rollback();
        context().close();
    }

    @Override
    public GenericDAO dao() {
        return dao;
    }

    @Override
    public Connection context() {
        return connection;
    }

    public MySqlDaoTest(Class clazz) {
        super(clazz);
    }

}
