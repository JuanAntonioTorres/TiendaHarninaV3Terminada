package dao.clienteDAO;

import dao.AccesoDB;
import dao.ReflexionRs;
import entity.ClienteEntity;
import entity.LoginClienteHarnina;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;

public class ClienteRoll {

    private AccesoDB acceso = null;

    private String usuario = "root";

    private String pass = "";

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }



    private void conectar() {
        acceso = AccesoDB.getMiConexion();
        try {
            acceso.conectar("com.mysql.jdbc.Driver", //com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/tienda_harnina20189vistas?useInformationSchema=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    this.usuario,
                    this.pass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Un objeto ResultSet mantiene un cursor que apunta a su fila actual de datos. Inicialmente el cursor se coloca antes de la primera fila.
        public ResultSet getCursor(String sql) throws SQLException {
        this.conectar();
        ResultSet cursor = acceso.executeQuery(sql);
        return cursor;
    }

        public int insertUpdateDelete(String sql) throws SQLException {
        this.conectar();
        return acceso.executeUpdate(sql);
    }

    // Uso de procedures

        public boolean  add_cliente(ClienteEntity cliente) throws SQLException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call add_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1,cliente.getNifCliente());
        cstmt.setString(2,cliente.getApellidosCliente());
        cstmt.setString(3,cliente.getNombreCliente());
        cstmt.setString(4,cliente.getCodigoPostalCliente());
        cstmt.setString(5,cliente.getDomicilioCliente());
        cstmt.setString(6,cliente.getFechaNacimiento());
        cstmt.setString(7,cliente.getTelefonoCliente());
        cstmt.setString(8,cliente.getMovilCliente());
        cstmt.setString(9,cliente.getSexoCliente());
        cstmt.setString(10,cliente.getEmailCliente());
        cstmt.setString(11,cliente.getImagenCliente());
        cstmt.setString(12,cliente.getUsuarioCliente());
        cstmt.setString(13,cliente.getPasswordCliente());
        cstmt.registerOutParameter(14, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(14);
    }

    public boolean updateCliente(ClienteEntity cliente) throws SQLException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call update_client_dataper(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        cstmt.setString(1,cliente.getNifCliente());
        cstmt.setString(2,cliente.getApellidosCliente());
        cstmt.setString(3,cliente.getNombreCliente());
        cstmt.setString(4,cliente.getCodigoPostalCliente());
        cstmt.setString(5,cliente.getDomicilioCliente());
        cstmt.setString(6,cliente.getFechaNacimiento());
        cstmt.setString(7,cliente.getTelefonoCliente());
        cstmt.setString(8,cliente.getMovilCliente());
        cstmt.setString(9,cliente.getSexoCliente());
        cstmt.setString(10,cliente.getEmailCliente());
        cstmt.setString(11,cliente.getUsuarioCliente());
        cstmt.registerOutParameter(12, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(12);
    }

        public String get_nif_login(String user, String password){
        this.conectar();
        try{
            CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call get_nif_login(?, ?, ?)}");
           try{
                cstmt.setString(1,user);
                cstmt.setString(2,password);
                cstmt.registerOutParameter(3, Types.VARCHAR);
                cstmt.execute();
                return  cstmt.getString(3);
           }
           finally {
               if (cstmt != null) {
                   cstmt.close();
               }
           }
        }
        catch (Exception ignore) {
        }

        return "null";
    }

        public ArrayList<?> getListaClientes() {

        this.conectar();

        String clase = ClienteEntity.class.getName();

        try {

            return new ReflexionRs().getListGenericObject((CallableStatement) acceso.getConexion().prepareCall("{call getListaClientes()}"), clase);

        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

        public Object getCliente(String dni) {
        this.conectar();
        String clase = ClienteEntity.class.getName();
        try {
            CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call get_cliente(?)}");
            cstmt.setString(1, dni);
            return new ReflexionRs().getGenericObject(cstmt, clase);
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

        public Boolean deleteClient (String nif) throws SQLException {

            this.conectar();
            CallableStatement cstmt = null;
            try {
                cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call delete_client(?, ?)}");
                try {
                    cstmt.setString(1, nif);
                    cstmt.registerOutParameter(2, Types.BOOLEAN);
                    cstmt.execute();

                } finally {
                    if (cstmt != null) {
                        cstmt.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return cstmt.getBoolean(2);
        }

        public boolean  update_client_login(LoginClienteHarnina cliente) throws SQLException {
        this.conectar();
        CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call update_client_login( ?, ?, ?, ?)}");
        cstmt.setString(3,cliente.getNifCliente());
        cstmt.setString(1,cliente.getUsuarioCliente());
        cstmt.setString(2,cliente.getPasswordCliente());
        cstmt.registerOutParameter(4, Types.BOOLEAN);
        cstmt.execute();
        return  cstmt.getBoolean(4);
    }
    }
