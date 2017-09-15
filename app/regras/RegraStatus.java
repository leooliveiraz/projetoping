package regras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import models.StatusPing;

public class RegraStatus {
	public static String converteParaJson(StatusPing status){
		Gson gson = new Gson();
		String json = gson.toJson(status);
		return json;
	}
	public static StatusPing converteParaObjeto(String json) {
		Gson gson = new Gson();
		StatusPing status = gson.fromJson(json, StatusPing.class);
		return status;
	}

	public static String inputStreamToString(InputStream is) throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));           										
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
	public static void recebePing(String path){
		String urlWebService = path;
    	StatusPing objetoRetorno = null;
    	
        try {
           
  		
           URL url = new URL(urlWebService);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("GET");
           connection.setConnectTimeout(15000);
           connection.setRequestProperty("login", "teste");
           connection.setRequestProperty("senha", "teste");
           connection.connect();

           String responseJson = RegraStatus.inputStreamToString((connection.getInputStream()));
           connection.disconnect();
  		
           objetoRetorno = RegraStatus.converteParaObjeto(responseJson);
           System.out.println(path+"------ "+objetoRetorno.toString());

        } catch (Exception e) {
    		System.out.println("OCORREU UM ERRO NO PING: "+path+"------ "+e.getMessage());
        }
	}
}
