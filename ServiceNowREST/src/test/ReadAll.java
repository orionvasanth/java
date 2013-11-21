package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadAll {

	/**
	 * @param args
	 */

	public void getRecords() {
		// TODO Auto-generated method stub
		HttpURLConnection connection = null;
		BufferedReader serverResponse = null;
		BufferedWriter out = null;
		Authenticator.setDefault(new Authentication());
		try {
			URL sn = new URL(
					"https://integration01demo.service-now.com/incident.do?JSON&sysparm_action=getRecords");
			connection = (HttpURLConnection) sn.openConnection();
			// SET REQUEST INFO
			connection.setRequestMethod("POST");
			System.out.println("Connection response: "
					+ connection.getResponseCode());

			serverResponse = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			// READ THE RESPOSNE
			String line;
			File records = new File("records.txt");
			if (records.exists())
				records.delete();
			records.createNewFile();
			out = new BufferedWriter(new FileWriter("records.txt", true));
			while ((line = serverResponse.readLine()) != null) {
				// System.out.println(line);
				out.write(line);
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
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		new ReadAll().getRecords();
	}

}
