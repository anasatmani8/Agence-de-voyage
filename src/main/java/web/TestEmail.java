package web;

import java.io.IOException;

import metier.SendEmail2;

public class TestEmail {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		SendEmail2 send = new SendEmail2();
		send.envoyerEmail("axxyy954@gmail.com", "***********");
	}

}
