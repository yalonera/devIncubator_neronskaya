package by.neronskaya.devIncubator.servlets;

import by.neronskaya.devIncubator.dao.DAOFactory;
import by.neronskaya.devIncubator.dao.GenericDAO;
import by.neronskaya.devIncubator.domain.Account;
import by.neronskaya.devIncubator.mysql.MySqlAccountDAO;
import by.neronskaya.devIncubator.mysql.MySqlDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private GenericDAO dao;
    private Connection connection;
    private static final DAOFactory<Connection> factory = new MySqlDAOFactory();
    protected Class daoClass;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(dao = new MySqlAccountDAO(connection));
        } finally {
            writer.close();
        }


    }

}
