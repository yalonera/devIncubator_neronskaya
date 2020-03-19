<! DOCTYPE HTML PUBLIC "- // W3C // DTD HTML 4.01 Transitional // EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%--<%--%>
<%--    String id = request.getParameter("userid");--%>
<%--    String driver = "com.mysql.jdbc.Driver";--%>
<%--    String connectionUrl = "jdbc:mysql://localhost:3306/";--%>
<%--    String database = "userbanklist";--%>
<%--    String userid = "root";--%>
<%--    String password = "8008";--%>
<%--    try {--%>
<%--        Class.forName(driver);--%>
<%--    } catch (ClassNotFoundException e) {--%>
<%--        e.printStackTrace();--%>
<%--    }--%>
<%--    Connection connection = null;--%>
<%--    Statement statement = null;--%>
<%--    ResultSet resultSet = null;--%>
<%--    ResultSet resultSet1 = null;--%>
<%--%>--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Bank List</title>
</head>
<body>
<center>
    <h3> JSP to view </h3>

    <form action="">
        <%--        <%--%>
        <%--            try {--%>
        <%--                connection = DriverManager.getConnection(connectionUrl + database, userid, password);--%>
        <%--                statement = connection.createStatement();--%>
        <%--                String queryRichestUser = "SELECT userBalance.sureName, MAX(balanceSum) FROM (\n" +--%>
        <%--                        "    SELECT name, sureName, SUM(balance) AS balanceSum FROM user\n" +--%>
        <%--                        "            JOIN account USING(userID)\n" +--%>
        <%--                        "            GROUP BY user.userID\n" +--%>
        <%--                        "            ORDER BY user.userID) as userBalance;";--%>
        <%--                String querySumBalance = "SELECT SUM(balance) FROM userbanklist.account;";--%>
        <%--                resultSet = statement.executeQuery(queryRichestUser);--%>
        <%--                resultSet1 = statement.executeQuery(querySumBalance);--%>
        <%--                while (resultSet.next()) {--%>
        <%--        %>--%>

        <p><input type="text" name="richest user " size="40">
            <input type="button" value=".get">
        </p>
        <%--        <%--%>
        <%--            }--%>
        <%--            while (resultSet1.next()) {--%>
        <%--        %>--%>

        <p><input type="text" name="account sum " size="40">
            <input type="button" value=".get">
        </p>
        <%--        <%--%>
        <%--                }--%>
        <%--                connection.close();--%>
        <%--            } catch (Exception e) {--%>
        <%--                e.printStackTrace();--%>
        <%--            }--%>
        <%--        %>--%>
    </form>
</center>

</body>
</html>