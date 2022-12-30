package edu.up.config.otros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import edu.up.config.excepciones.FechaException;

public class FechaUtil {
	    
    public static String getHoy() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	String hoy = LocalDate.now().format(dtf);
    	return hoy;
    }
    
    public static LocalDate StringToLocalDate(String fechaString) throws FechaException {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	try {
    		LocalDate fechaLocalDate = LocalDate.parse(fechaString, dtf);
    		return fechaLocalDate;			
    	} catch (DateTimeParseException  e) {throw new FechaException(e);}
    }
    
    public static int mesActual() {
    	return LocalDate.now().getMonthValue();
    }
    
    public static int anioActual() {
    	return LocalDate.now().getYear();
    }
    
    public static String mes_Texto(int mes) {
    	switch (mes) {
	    	case 1: {return "Enero";}
			case 2: {return "Febrero";}
			case 3: {return "Marzo";}
			case 4: {return "Abril";}
			case 5: {return "Mayo";}
			case 6: {return "Junio";}
			case 7: {return "Julio";}
			case 8: {return "Agosto";}
			case 9: {return "Septiembre";}
			case 10: {return "Octubre";}
			case 11: {return "Noviembre";}
			case 12: {return "Diciembre";}
		default:
			throw new IllegalArgumentException("Unexpected value: " + mes);
		}
    }
    
}
