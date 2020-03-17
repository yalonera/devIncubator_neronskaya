package by.neronskaya.devIncubator.utils;

public class Util {
    public static java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
