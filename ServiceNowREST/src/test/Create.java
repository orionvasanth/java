package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Create {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Create().insert();
	}

	public Boolean insert() {
		HttpURLConnection connection = null;
		BufferedReader serverResponse = null;
		PrintWriter out = null;
		Authenticator.setDefault(new Authentication());
		try {
			URL sn = new URL(
					"https://integration01demo.service-now.com/incident.do?JSON&sysparm_action=insert");
			connection = (HttpURLConnection) sn.openConnection();
			// SET REQUEST INFO
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			/*System.out.println("Connection response: "
					+ connection.getResponseCode());*/

			String incident = "{\"short_description\":\"this is from SRM\",\"priority\":\"1\"}";
			
			out = new PrintWriter(connection.getOutputStream());
			out.println(incident);
			out.flush();
			serverResponse = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			
			// READ THE RESPOSNE
			String line;
			while ((line = serverResponse.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();

			if (serverResponse != null) {
				try {
					serverResponse.close();
				} catch (Exception ex) {
				}
			}
			if (out != null)
				out.close();
		}
		return false;
	}

}
