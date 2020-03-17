package by.neronskaya.devincubator.userbanklist.dao;

import by.neronskaya.devIncubator.dao.GenericDAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public abstract class GenericDaoTest<Context> {
    protected Class daoClass;

    public abstract GenericDAO dao();

    public abstract Context context();

    @Test
    public void testGetAll() throws Exception {
        List list = dao().getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    public GenericDaoTest(Class clazz) {
        this.daoClass = clazz;
    }
}
