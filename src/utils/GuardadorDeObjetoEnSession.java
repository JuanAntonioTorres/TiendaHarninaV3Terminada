package utils;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GuardadorDeObjetoEnSession {

    public void guardar(HttpSession session, Object object) throws InvocationTargetException, IllegalAccessException {
        Field [] atributosObjeto = object.getClass().getDeclaredFields();
        Method [] metodosObjeto = object.getClass().getDeclaredMethods();
        for (int i = 0; i < atributosObjeto.length; i++) {
            String nombreAtributo = atributosObjeto[i].getName();
            for (int j = 0; j < metodosObjeto.length; j++) {
                if(metodosObjeto[i].getName().equals("get"+ atributosObjeto[i].getName())){
                    session.setAttribute(atributosObjeto[i].getName(), metodosObjeto[i].invoke(object));
                }
            }
        }
    }
}
