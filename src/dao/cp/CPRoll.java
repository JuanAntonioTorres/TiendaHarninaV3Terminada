package dao.cp;

import dao.AccesoDB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CPRoll {

    private AccesoDB acceso = null;

    private String usuario;

    private String pass;

    public CPRoll(String usu, String pas) {

        this.usuario = usu;

        this.pass = pas;
    }

    private void conectar() {

        System.out.println("usu2:" + this.usuario + " pas2:" + this.pass);
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

    public ArrayList<String> get_lista_cps() {
        this.conectar();
        ResultSet results = null;
        ArrayList<String> listaCP = new  ArrayList<String>();
        String cpe = new String();
        try{
            CallableStatement cstmt = (CallableStatement) acceso.getConexion().prepareCall("{call get_cp()}");
            try{
                results = cstmt.executeQuery();

                while (results.next()) {

                    cpe = results.getString("CodigoPostal");

                    listaCP.add(cpe);
                }

                return  listaCP;
            }
            finally {
                if (cstmt != null) {
                    cstmt.close();
                }
            }
        }
        catch (Exception ignore) {
        }

        return listaCP;
    }
}
