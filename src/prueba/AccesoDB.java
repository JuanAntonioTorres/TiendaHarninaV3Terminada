package prueba;

import dao.clienteDAO.ClienteDAO;
import entity.ClienteEntity;

import java.sql.SQLException;

public class AccesoDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {

        ClienteDAO clienteDAO  =  new ClienteDAO();
        ClienteEntity ClientEntity = new ClienteEntity();
        System.out.println(ClientEntity.toString());
        System.out.println("INSERT:"+clienteDAO.add_cliente_procedure(ClientEntity));

/*
        ArrayList<String> provincias = new ArrayList<String>();

        for (String s : provincias = clienteDAO.getProvincias()) {
            System.out.println(s + "\n");
        }

*/



    }
}
