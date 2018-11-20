package controller;

import dao.clienteDAO.ClienteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteCli")
public class DeleteClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            if(clienteDAO.deleteClient((String) session.getAttribute("nifClient"))) request.setAttribute("mensaje", "Cliente eliminado");
                else request.setAttribute("mensaje", "Cliente NO eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
