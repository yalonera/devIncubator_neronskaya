<! DOCTYPE HTML PUBLIC "- // W3C // DTD HTML 4.01 Transitional // EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h1></h1>
<%

    try {
        String connectionURL = "jdbc:mysql://localhost:3306/userbanklist";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(connectionURL, "root", "8008");
        if (!connection.isClosed()) {
            out.println("Successfully connected to DB. MySQL server using TCP/IP...");
            connection.close();
        }
    } catch (Exception ex) {
        out.println("Невозможно подключиться к базе данных.");
    }
%>
</
body>
</html>