import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {

	public static void testServer() {
		// TODO Auto-generated method stub
		System.out.println("Server is running > > >");
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			Socket socket = null;
			while (true) {
				socket = ss.accept();
				new ServerSocketThread(socket).start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		testServer();
	}

}
