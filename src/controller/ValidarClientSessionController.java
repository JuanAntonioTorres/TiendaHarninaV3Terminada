package controller;

import cliente.DataLoginCliente;
import dao.clienteDAO.ClienteDAO;
import utils.GuardadorDeObjetoEnSession;
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

@WebServlet("/valiCliSesion")
public class ValidarClientSessionController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("cliente/clientSesion.jsp");

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

                //verificamos si está en BD
                ClienteDAO clienteDAO = new ClienteDAO();

                String dni = clienteDAO.get_nif_login(dataSessionCliente.getLoginClienteEntity());
                session.setAttribute("nifClient",dni);

                if (!dni.equals("null")){

                    request.setAttribute("mensaje", ("Hola ").concat(dni));

                    String opcion = request.getParameter("opcion");

                    if(opcion.equals("clientUpdateDaper")){
                        try {
                            new GuardadorDeObjetoEnSession().guardar(session , new ClienteDAO().getCliente(dni));
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }

                    String url;

                    if (opcion.equals("null")) url = "cliente/clienteIndex.jsp";
                    else url = "cliente/" + opcion + ".jsp";

                    rd = request.getRequestDispatcher(url);

                }else request.setAttribute("mensaje", "Cliente NO coincide login");

            }else request.setAttribute("mensaje", validacionPassword.getError());

        } else request.setAttribute("mensaje", validacionUsuario.getError());

        rd.forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
