package controller;

import cliente.DataLoginCliente;
import dao.clienteDAO.ClienteDAO;
import validate.ValidacionPassword;
import validate.ValidacionUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/valiCliUpdateLogin")
public class UpdateClientLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        DataLoginCliente dataSessionCliente = null;

        try {
            dataSessionCliente = new DataLoginCliente(request);

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ValidacionUsuario validacionUsuario = new ValidacionUsuario(dataSessionCliente.getUsuarioCliente());
        if(validacionUsuario.validar()) {

            ValidacionPassword validacionPassword = new ValidacionPassword(dataSessionCliente.getPasswordCliente());

            if(validacionPassword.validar()){

                ClienteDAO clienteDAO = new ClienteDAO();

                dataSessionCliente.setUsuarioCliente((String) session.getAttribute("nifClient"));

                try {
                    if( clienteDAO.update_client_login(dataSessionCliente.getLoginClienteEntity())) request.setAttribute("mensaje", "Login Modificado ");
                        else request.setAttribute("mensaje", "Login NO se ha podido modificar");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else request.setAttribute("mensaje", validacionPassword.getError());

        } else request.setAttribute("mensaje", validacionUsuario.getError());

        RequestDispatcher rd = request.getRequestDispatcher("cliente/clienteIndex.jsp");
        rd.forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
