package controller;

import cliente.DataPersonCliente;
import dao.clienteDAO.ClienteDAO;
import dao.clienteDAO.ClienteRoll;
import dao.cp.CPDAO;
import validate.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/valiCliIn")
@MultipartConfig
public class ValidarClientInsertController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    HttpSession session;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("cliente/clientInsert.jsp");

        DataPersonCliente dataInsertCliente = null;

        try {

           dataInsertCliente = new DataPersonCliente(request);

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ValidacionDNINIECIF validacionDNINIECIF = new ValidacionDNINIECIF(dataInsertCliente.getNifCliente());
        if(validacionDNINIECIF.validar()) {
            ValidacionLetrasConEspacio validacionLetrasConEspacio = new ValidacionLetrasConEspacio(dataInsertCliente.getNombreCliente());
            if(validacionLetrasConEspacio.validar()){
                ValidacionLongitud validacionLongitud = new ValidacionLongitud(dataInsertCliente.getNombreCliente(), 3, 50);
                if(validacionLongitud.validar()){
                    validacionLetrasConEspacio = new ValidacionLetrasConEspacio(dataInsertCliente.getApellidosCliente());
                    if(validacionLetrasConEspacio.validar()){
                        validacionLongitud = new ValidacionLongitud(dataInsertCliente.getApellidosCliente(), 3, 100);
                        if(validacionLongitud.validar()){
                            ValidacionCodigoPostal validacionCodigoPostal = new ValidacionCodigoPostal(dataInsertCliente.getCodigoPostalCliente());
                            if(validacionCodigoPostal.validar()){
                                ValidarDomicilio validarDomicilio = new ValidarDomicilio(dataInsertCliente.getDomicilioCliente());
                                if(validarDomicilio.validar()){
                                    validacionLongitud = new ValidacionLongitud(dataInsertCliente.getDomicilioCliente(), 2, 100);
                                    if(validacionLongitud.validar()){
                                        ValidacionTelefonoSpain validacionTelefonoSpain = new ValidacionTelefonoSpain(dataInsertCliente.getTelefonoCliente());
                                        if(validacionTelefonoSpain.validar()){
                                            validacionTelefonoSpain = new ValidacionTelefonoSpain(dataInsertCliente.getMovilCliente());
                                            if(validacionTelefonoSpain.validar()){
                                               ValidacionFecha validacionFecha = new ValidacionFecha(dataInsertCliente.getFechaNacimiento());
                                                if(validacionFecha.validar()){
                                                    ValidacionSexo validacionSexo = new ValidacionSexo(dataInsertCliente.getSexoCliente());
                                                    if(validacionSexo.validar()){
                                                        ValidacionEmail validacionEmail = new ValidacionEmail(dataInsertCliente.getEmailCliente());
                                                        if(validacionEmail.validar()){
                                                            ValidacionUsuario validacionUsuario = new ValidacionUsuario(dataInsertCliente.getUsuarioCliente());
                                                            if(validacionUsuario.validar()){
                                                                ValidacionPassword validacionPassword = new ValidacionPassword(dataInsertCliente.getPasswordCliente());
                                                                if(validacionPassword.validar()){

                                                                    ClienteRoll clienteRoll = new ClienteRoll();

                                                                    CPDAO cpdao = new CPDAO(clienteRoll.getUsuario(), clienteRoll.getPass());


                                                                    try {
                                                                        if (!cpdao.check_cp(dataInsertCliente.getCodigoPostalCliente())) {

                                                                            request.setAttribute("error", "Codigo Postal Inexistente");

                                                                        }
                                                                    } catch (SQLException e) {
                                                                        e.printStackTrace();
                                                                    }

                                                                    clientFotoLoad(request, response);

                                                                    dataInsertCliente.setImagenCliente(dataInsertCliente.getNifCliente() + ".png");


                                                                    ClienteDAO clienteDAO = new ClienteDAO();

                                                                    if (clienteDAO.add_cliente_procedure(dataInsertCliente.getClienteEntity())) {
                                                                            request.setAttribute("mensaje", "Cliente add");
                                                                            rd = request.getRequestDispatcher("cliente/clienteIndex.jsp");
                                                                    } else request.setAttribute("error", "Cliente NO add");


                                                                }else request.setAttribute("error",validacionUsuario.getError());

                                                            }else request.setAttribute("error",validacionUsuario.getError());

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "fotoSin.jpg";
    }

    private void clientFotoLoad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Part filePart = request.getPart("imagenCliente");
        String fileName = getFileName(filePart);
        String dniCliente = request.getParameter("nifCliente");

        if (fileName.length() > 2) {

            fileName = dniCliente + ".png";

            String path = getServletContext().getRealPath("img/fotoClient/");

            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            FileOutputStream fs = new FileOutputStream(new File(path + fileName));
            BufferedOutputStream buf = new BufferedOutputStream(fs);

            InputStream fileContent = filePart.getInputStream();
            BufferedInputStream bufIN = new BufferedInputStream(fileContent);

            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = bufIN.read(buffer)) != -1) {
                buf.write(buffer, 0, bytesRead);
            }

            buf.close();
            bufIN.close();
        }
    }
}

