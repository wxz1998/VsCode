import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerSocketThread extends Thread {
	private Socket socket;

	public ServerSocketThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			HttpRequestHandler request = new HttpRequestHandler(socket);
			request.handle();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
