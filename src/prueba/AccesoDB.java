package prueba;

import dao.clienteDAO.ClienteDAO;
import entity.ClienteEntity;

import java.sql.SQLException;

public class AccesoDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {

        ClienteDAO clienteDAO  =  new ClienteDAO();

        System.out.println(clienteDAO.getListaClientes());
        ClienteEntity clientEntity = new ClienteEntity();
        System.out.println(clientEntity.toString());
        //System.out.println("INSERT:"+clienteDAO.add_cliente_procedure(clientEntity));

/*
        ArrayList<String> provincias = new ArrayList<String>();

        for (String s : provincias = clienteDAO.getProvincias()) {
            System.out.println(s + "\n");
        }

*/



    }
}
