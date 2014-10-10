package EchoServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static String serverHost = "127.0.0.1";
	private static int serverPort = 8000;

	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter printWriter = null;

		try {
			socket = new Socket(serverHost, serverPort);
			printWriter = new PrintWriter(socket.getOutputStream());

		} catch (UnknownHostException e) {
			System.out.println("Don't know about host: " + serverHost);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Couldn't get I/O for the connection to: "
					+ serverHost);
			System.exit(1);
		}

		String userInput = "Hello";
		printWriter.write(userInput);

		printWriter.close();
		socket.close();
	}
}
