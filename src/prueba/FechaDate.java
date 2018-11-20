package prueba;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FechaDate {
    public static void main(String[] args) throws ParseException {
        LocalDate localDate = LocalDate.parse( "1961-02-13" );
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "MMdduuuu" );
        String input = String.format("%08d", 2131961) ;
         localDate = LocalDate.parse( input , f );
         System.out.println(localDate.toString());
    }
}
