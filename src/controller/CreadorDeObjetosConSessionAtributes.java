package controller;

import entity.ClienteEntity;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CreadorDeObjetosConSessionAtributes {

    public CreadorDeObjetosConSessionAtributes(HttpSession session, Object objeto) throws InvocationTargetException, IllegalAccessException {

        Method[] metodosDeclarados = objeto.getClass().getDeclaredMethods();

        Field[] atributos = objeto.getClass().getDeclaredFields();

        for (int i = 0; i < metodosDeclarados.length ; i++) {

            for (int j = 0; j < atributos.length; j++) {

                if(metodosDeclarados[i].getName().toLowerCase().contains("set"+ atributos[j].getName().toLowerCase())){

                    System.out.println(atributos [j]);

                    System.out.println(metodosDeclarados [i]);

                    if(session.getAttribute(atributos[j].getName())!= null){

                        metodosDeclarados[i].invoke(objeto,session.getAttribute(atributos[j].getName()));

                        System.out.println(session.getAttribute(atributos[j].getName()));

                    }

                }

            }

        }
        System.out.println("TODOS ESTOS MENSAJES SALEN DEL CREADOR DE OBJETOS CON SESSION PARA " +
                "AYUDAR A ENTENDER COMO FUNCIONA");

        System.out.println(objeto.toString());

    }
}
