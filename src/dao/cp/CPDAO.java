package dao.cp;

import java.sql.SQLException;
import java.util.ArrayList;

public class CPDAO {

    private String usuario;

    private String pass;

    private  CPRoll  cproll;

    public CPDAO(String usu, String pas) {



        this.usuario = usu;
        this.pass = pas;
        cproll = new CPRoll(this.usuario,this.pass);

    }

    public ArrayList<String> get_lista_cp() throws SQLException {
        return   cproll.get_lista_cps();
    }

    public boolean check_cp(String cp) throws SQLException {

        ArrayList<String> listaCP = get_lista_cp();

        if(listaCP.contains(cp)) return true;

        return false;
    }
}
