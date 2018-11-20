package prueba;

import dao.clienteDAO.ClienteDAO;
import entity.ClienteEntity;
import entity.DaperClienteHarnina;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ClienteDAO  clienteDAO = new ClienteDAO();

        ArrayList<ClienteEntity> lista = null;
        lista = clienteDAO.getListaClientes();

        Iterator<ClienteEntity> it = lista.iterator();

        while(it.hasNext()){
            ClienteEntity item=it.next();
            //System.out.println("item.toString()" + item.toString());
            System.out.println("Apellido: " + item.getApellidosCliente());
        }

    }
}
