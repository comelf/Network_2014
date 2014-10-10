package EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static int serverPort = 8000;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			System.err.println("Could not listen on port:" + serverPort);
			System.exit(1);
		}

		System.out.println("Waiting for connection.....");

		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
			System.out.println("Accept failed.");
			System.exit(1);
		}

		System.out.println("Connection successful");

		InputStreamReader inputStreamReader = new InputStreamReader(
				socket.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String inputLine;

		while ((inputLine = bufferedReader.readLine()) != null) {
			System.out.println("Server: " + inputLine);
		}

		bufferedReader.close();
		socket.close();
		serverSocket.close();
	}
}
