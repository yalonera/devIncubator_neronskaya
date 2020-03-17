package by.neronskaya.devIncubator.dao;

// Фабрика объектов для работы с базой данных

public interface DAOFactory<Context> {
    // возвращает подключение
    Context getContext() throws PersistException;

    // возвращает объект для управления персистентным состоянием объекта
    GenericDAO getDAO(Context context, Class dtoClass) throws PersistException;

}
