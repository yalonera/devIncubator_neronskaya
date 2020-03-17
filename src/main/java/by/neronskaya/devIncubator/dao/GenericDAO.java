package by.neronskaya.devIncubator.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {
    // возвращает объект соответствующий записи с первичным ключом
    T getByPK(PK key) throws PersistException;

    // возвращает список оъектов соответствий всем записям в БД
    List<T> getAll() throws PersistException;

    // возвращает количество записей в таблице
    int getFieldNumber() throws PersistException;
}
