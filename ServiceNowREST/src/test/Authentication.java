package test;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Authentication extends Authenticator {

	/**
	 * @param args
	 */
	
	@Override
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication ("admin", "admin".toCharArray());
		
	}

}
