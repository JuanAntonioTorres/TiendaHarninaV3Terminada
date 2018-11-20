package controller;

import dao.clienteDAO.ClienteDAO;
import dao.clienteDAO.ClienteRoll;
import dao.cp.CPDAO;
import entity.ClienteEntity;
import validate.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/valiCliUpdateDaper")
public class UpdateClientDaperController extends HttpServlet {

        HttpSession session;


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            session = request.getSession();

            request.setCharacterEncoding("UTF-8");

            response.setContentType("text/html");

            RequestDispatcher rd = request.getRequestDispatcher("cliente/clientInsert.jsp");

            ClienteEntity clienteEntity = null;

            clienteEntity = new ClienteEntity();

            ValidacionDNINIECIF validacionDNINIECIF = new ValidacionDNINIECIF(clienteEntity.getNifCliente());
            if(validacionDNINIECIF.validar()) {
                ValidacionLetrasConEspacio validacionLetrasConEspacio = new ValidacionLetrasConEspacio(clienteEntity.getNombreCliente());
                if(validacionLetrasConEspacio.validar()){
                    ValidacionLongitud validacionLongitud = new ValidacionLongitud(clienteEntity.getNombreCliente(), 3, 50);
                    if(validacionLongitud.validar()){
                        validacionLetrasConEspacio = new ValidacionLetrasConEspacio(clienteEntity.getApellidosCliente());
                        if(validacionLetrasConEspacio.validar()){
                            validacionLongitud = new ValidacionLongitud(clienteEntity.getApellidosCliente(), 3, 100);
                            if(validacionLongitud.validar()){
                                ValidacionCodigoPostal validacionCodigoPostal = new ValidacionCodigoPostal(clienteEntity.getCodigoPostalCliente());
                                if(validacionCodigoPostal.validar()){
                                    ValidarDomicilio validarDomicilio = new ValidarDomicilio(clienteEntity.getDomicilioCliente());
                                    if(validarDomicilio.validar()){
                                        validacionLongitud = new ValidacionLongitud(clienteEntity.getDomicilioCliente(), 2, 100);
                                        if(validacionLongitud.validar()){
                                            ValidacionTelefonoSpain validacionTelefonoSpain = new ValidacionTelefonoSpain(clienteEntity.getTelefonoCliente());
                                            if(validacionTelefonoSpain.validar()){
                                                validacionTelefonoSpain = new ValidacionTelefonoSpain(clienteEntity.getMovilCliente());
                                                if(validacionTelefonoSpain.validar()){
                                                    ValidacionFecha validacionFecha = new ValidacionFecha(clienteEntity.getFechaNacimiento());
                                                    if(validacionFecha.validar()){
                                                        ValidacionSexo validacionSexo = new ValidacionSexo(clienteEntity.getSexoCliente());
                                                        if(validacionSexo.validar()){
                                                            ValidacionEmail validacionEmail = new ValidacionEmail(clienteEntity.getEmailCliente());
                                                            if(validacionEmail.validar()){

                                                            ClienteRoll clienteRoll = new ClienteRoll();

                                                            CPDAO cpdao = new CPDAO(clienteRoll.getUsuario(), clienteRoll.getPass());


                                                            try {
                                                                if (!cpdao.check_cp(clienteEntity.getCodigoPostalCliente())) {

                                                                    request.setAttribute("error", "Codigo Postal Inexistente");

                                                                }
                                                            } catch (SQLException e) {
                                                                e.printStackTrace();
                                                            }

                                                            ClienteDAO clienteDAO = new ClienteDAO();

                                                                try {
                                                                    if (clienteDAO.updateCliente(clienteEntity)){
                                                                        request.setAttribute("mensaje", "Cliente modificado");
                                                                        rd = request.getRequestDispatcher("cliente/clienteIndex.jsp");
                                                                    } else request.setAttribute("error", "Cliente NO modificado");
                                                                } catch (SQLException e) {
                                                                    e.printStackTrace();
                                                                }

                                                            }else request.setAttribute("error",validacionEmail.getError());

                                                    }else request.setAttribute("error",validacionSexo.getError());

                                                }else request.setAttribute("error", validacionFecha.getError());

                                            }else request.setAttribute("error", validacionTelefonoSpain.getError());

                                        }else request.setAttribute("error", validacionTelefonoSpain.getError());

                                    }else request.setAttribute("error", validacionLongitud.getError());

                                }else request.setAttribute("error", validarDomicilio.getError());

                            }else request.setAttribute("error", validacionCodigoPostal.getError());

                        }else request.setAttribute("error", validacionLongitud.getError());

                    }else request.setAttribute("error", validacionLetrasConEspacio.getError());

                }else request.setAttribute("error", validacionLongitud.getError());

            }else request.setAttribute("error", validacionLetrasConEspacio.getError());

        }else request.setAttribute("error", validacionDNINIECIF.getError());


            rd.forward(request, response);
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
