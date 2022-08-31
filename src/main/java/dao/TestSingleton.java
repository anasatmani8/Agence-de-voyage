package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Connection conn= SingletonConnection.getConnection();
		System.out.println();
		String password = "test";
		
		System.out.println("le mot de passe entre avant hachage est: "+password);
		//////////////////////////////////////////////////
	
		try {
		//md contient la méthode de chiffrement comme 1er argument
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
		sb.append(String.format("%02x", b));
		}
		
		System.out.println("le mot de passe apres hachage est "+sb.toString());
		
	
		
		}catch (NoSuchAlgorithmException e){
			System.err.println("Erreur:"+e.toString());

			}
}
}