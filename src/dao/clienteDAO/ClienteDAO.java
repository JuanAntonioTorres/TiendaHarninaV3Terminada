package dao.clienteDAO;

import entity.ClienteEntity;
import entity.LoginClienteEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    ClienteRoll clienteRoll = new ClienteRoll();

   public ArrayList<String> getProvincias() throws SQLException, ClassNotFoundException{

        ArrayList<String> provincias = new ArrayList<String>();

        String sql = "SELECT * FROM provincia";

        ResultSet rs =  clienteRoll.getCursor(sql);

        while(rs.next())
        {
            String provincia = rs.getString("NombreProvincia");
            provincias.add(provincia);
        }

        return provincias;
    }

   public int add_cliente(ClienteEntity cliente) {
       String sql = "INSERT INTO `cliente`(`NifCliente`, `ApellidosCliente`, `NombreCliente`, `CodigoPostalCliente`, `DomicilioCliente`, `FechaNacimiento`, `TelefonoCliente`, `MovilCliente`, `SexoCliente`, `EmailCliente`, `ImagenCliente`, `UsuarioCliente`, `PasswordCliente`) " + " VALUES ('" + cliente.getNifCliente() + "','" +
               cliente.getApellidosCliente()+ "','" +
               cliente.getNombreCliente()+ "','" +
               cliente.getCodigoPostalClient()+ "','" +
               cliente.getDomicilioCliente()+ "','" +
               cliente.getFechaNacimiento()+ "','" +
               cliente.getTelefonoCliente()+ "','" +
               cliente.getMovilCliente()+ "','" +
               cliente.getSexoCliente()+ "','" +
               cliente.getEmailCliente()+ "','" +
               cliente.getImagenCliente()+ "','" +
               cliente.getUsuarioCliente()+ "','" +
               cliente.getPasswordCliente()+ "')";

       System.out.println(sql);
        try {

            return clienteRoll.insertUpdateDelete(sql);

        } catch (SQLException e) {

            return 0;
        }
    }

   public boolean add_cliente_procedure (ClienteEntity clientEntity) {
        try {
            return clienteRoll.add_cliente(clientEntity);
        } catch (SQLException e) {
            System.out.println("DAO false");
            return false;
        }
    }
    public String  get_nif_login(LoginClienteEntity clientloginEntity) {

       try
       {
           return clienteRoll.get_nif_login(clientloginEntity.getUsuario(),clientloginEntity.getPassword());
       }
       catch (Exception ignore)
       {
           // do something appropriate with the exception, *at least*:
           //e.printStackTrace();
       }
       return "null";
    }


}
