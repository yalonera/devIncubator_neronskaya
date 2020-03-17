package by.neronskaya.devincubator.userbanklist.dao;

import by.neronskaya.devIncubator.dao.DAOFactory;
import by.neronskaya.devIncubator.dao.GenericDAO;
import by.neronskaya.devIncubator.dao.PersistException;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.domain.Identifier;
import by.neronskaya.devIncubator.mysql.MySqlDAOFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SimpleTest {
    private Connection connection;

    private GenericDAO dao;

    private static final DAOFactory<Connection> factory = new MySqlDAOFactory();

    protected Class daoClass;

    protected Identifier notPersistedDto;

    protected Integer userId;

    public GenericDAO dao() {
        return dao;
    }

    public Connection context() {
        return connection;
    }

    public SimpleTest(Class clazz, Identifier notPersistedDto, Integer userId) {
        this.daoClass = clazz;
        this.notPersistedDto = notPersistedDto;
        this.userId = userId;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {Account.class, new Account(), 11}
        });
    }

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
        dao = factory.getDAO(connection, daoClass);
    }

    @Test
    public void testGetAll() throws Exception {
//        List list = dao().getAll();
//        list.forEach(System.out::println);
//        Assert.assertNotNull(list);
//        Assert.assertTrue(list.size() > 0);
//        Account acct = (Account) dao.getByPK(userId);
//        System.out.println(acct);
//        Assert.assertNotNull(acct);
        System.out.println(dao.getFieldNumber());
        Assert.assertEquals(dao.getFieldNumber(), 6);
    }

    @After
    public void tearDown() throws SQLException {
        context().rollback();
        context().close();
    }
}
