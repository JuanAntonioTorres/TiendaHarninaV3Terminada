package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReflexionRs {

    public ArrayList<?> getListGenericObject(CallableStatement procedure, String clase) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, ParseException {

        ResultSet rs = procedure.executeQuery();

        ArrayList<Object> filas = new ArrayList<>();

        while (rs.next()) {

            HashMap<String, Object> datosFila = new HashMap<>();

            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {

                //System.out.println("rs.getMetaData().getColumnName(i).toString()" + rs.getMetaData().getColumnName(i).toString() + " rs.getString(i):" +rs.getString(i));

                datosFila.put(rs.getMetaData().getColumnName(i).toString(),rs.getString(i)); // rs.getString(i)); // rs.getObject(i));
            }

            filas.add(new PojoFillerDB().crearPojo(datosFila, clase));
        }
        return filas;
    }

    public Object getGenericObject(CallableStatement procedure, String clase) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, ParseException {
        ResultSet rs = procedure.executeQuery();
        HashMap<String, Object> datosFila = new HashMap<>();
        for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
            datosFila.put(rs.getMetaData().getColumnName(i).toString(), rs.getObject(i));
        }
        return new PojoFillerDB().crearPojo(datosFila, clase);
    }
}
