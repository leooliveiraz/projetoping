package util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;

public class UtilString {
	public static String sha2(String senha){
		try{
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));		 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			String senhaCriptgrafada = hexString.toString();
			return senhaCriptgrafada;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		
	}
	public static String removerPontoTraco(String mensagem){
		mensagem = mensagem.replace(".", "");
		mensagem = mensagem.replace("/", "");
		mensagem = mensagem.replace("-", "");
		return mensagem;
	}

	public static String retornaHost(String host,boolean protocolo){
		if(protocolo){
			host="https://"+host;
		}else{
			host="http://"+host;			
		}
		return host;
	}
	
	public static String logThrowable(Throwable thrown) {
	   StringWriter sw = new StringWriter();
	   thrown.printStackTrace(new PrintWriter(sw));
	   return sw.toString();
	}
	
}
