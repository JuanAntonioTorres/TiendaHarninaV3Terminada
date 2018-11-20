package dao;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class PojoFillerDB {

    public Object crearPojo(HashMap<String, Object> datosFila, String clasePojo) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, ParseException {

        Class genericClass = Class.forName(clasePojo);

        Object genericObject = genericClass.newInstance();

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

        Method[] metodosDeclarados = genericObject.getClass().getDeclaredMethods();

        Field[] atributos = genericObject.getClass().getDeclaredFields();

        for (int i = 0; i < metodosDeclarados.length; i++) {

            for (int j = 0; j < atributos.length; j++) {

                if (metodosDeclarados[i].getName().toLowerCase().contains("set" + atributos[j].getName().toLowerCase())) {

                    System.out.println("metodo: " + metodosDeclarados[i].getName() + "\t|atributo: " + atributos[j].getName() + "\t|dato: " + datosFila.get(atributos[j].getName().toString()));//datosFila.get(atributos[j].getName().toString()));  //.toString()));
/*
                    //metodosDeclarados[i].invoke(genericObject, datosFila.get(atributos[j].getName().toString()));
                   if (datosFila.get(atributos[j].getName()) != null && atributos[j].getName() == "FechaNacimiento") {

                       System.out.println("formatoDelTexto.parse((String) datosFila.get(atributos[j].getName().toString()))" + formatoDelTexto.parse((String) datosFila.get(atributos[j].getName().toString())));
                       SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                       Date date = d.parse((String) datosFila.get(atributos[j].getName().toString()));
                       System.out.println(DateFormat.getDateInstance().format(date));
                       LocalDate localDate = LocalDate.parse( "1961-02-13" );
                       DateTimeFormatter f = DateTimeFormatter.ofPattern( "MMdduuuu" );
                       String input = String.format("%08d", 2131961) ;
                       localDate = LocalDate.parse( input , f );
                       System.out.println(localDate);
                       date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                       System.out.println(date);

                       metodosDeclarados[i].invoke(genericObject, date);
                   }
                     else   metodosDeclarados[i].invoke(genericObject, datosFila.get(atributos[j].getName().toString()));

*/
                    metodosDeclarados[i].invoke(genericObject, datosFila.get(atributos[j].getName())); //.toString()));
                }

            }

        }
        return genericObject;
    }

}
