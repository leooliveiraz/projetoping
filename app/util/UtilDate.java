package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UtilDate {	
	
	public static Date converteStringParaDate(String data)  { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (Date)formatter.parse(data);
        } catch (ParseException e) {            
        	e.printStackTrace();
            return null;
        }
        return date;
	}

	public static String converteDateParaString(Date data) { 
		try{

			if (data == null)
				return "";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data_convertida = df.format(data);
			return  data_convertida;
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	

	public static String converteDateParaStringHora(Date data) { 
		try{
			if (data == null)
				return "";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String data_convertida = df.format(data);
			return  data_convertida;
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
}
