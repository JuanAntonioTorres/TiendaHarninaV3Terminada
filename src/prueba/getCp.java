package prueba;

import dao.clienteDAO.ClienteDAO;
import dao.cp.CPDAO;
import entity.CodigoPostalEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class getCp {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

      CPDAO cpdao = new CPDAO("root", "");

        ArrayList<String> a = null;
        a = cpdao.get_lista_cp();
        System.out.println("Existe cp:" );

    }

}
