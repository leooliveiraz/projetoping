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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import models.StatusPing;

public class RegraStatus {
	private static List<StatusPing> listaPingsRecebidos= new ArrayList<>(); 
	
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
        List<StatusPing> listaPings= new ArrayList<>();
        
        try { 
           URL url = new URL(urlWebService);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
           connection.setRequestMethod("GET");
           connection.setConnectTimeout(15000);
           connection.connect();
           String responseJson = RegraStatus.inputStreamToString((connection.getInputStream()));
           connection.disconnect();

           objetoRetorno = RegraStatus.converteParaObjeto(responseJson);
           objetoRetorno.setDescricao(objetoRetorno.getDescricao()+": "+path);
           listaPings.add(objetoRetorno);
           
           System.out.println(path+"------ "+objetoRetorno.toString());

        } catch (Exception e) {
        	objetoRetorno = new StatusPing("ERRO: "+path, new Date());
            System.out.println("ERRO: "+path +" "+new Date());
            listaPings.add(objetoRetorno);
    		
        }
        listaPings.addAll(listaPingsRecebidos);
        listaPingsRecebidos = listaPings;        
	}
	
	public static List<StatusPing> getListaPingsRecebidos() {
		return listaPingsRecebidos;
	}
	public static void setListaPingsRecebidos(List<StatusPing> listaPingsRecebidos) {
		RegraStatus.listaPingsRecebidos = listaPingsRecebidos;
	}
	
	
}
