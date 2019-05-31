import java.io.IOException;
import java.net.Socket;

class HttpRequestHandler {
	private Socket socket;

	public HttpRequestHandler(Socket socket) {
		this.socket = socket;
	}

	public void handle() throws IOException {
		socket.getOutputStream().write(("HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html; charset=utf-8\r\n" + "\r\n"
				+ "<html>\r\n" + "<head>" + "<meta http-equiv=" + "Content-Type"
				+ " content=" + "text/html; charset=utf-8 />" + "</head>"
				+ "<h1>Successfully!!!</h1>\r\n" + "<body>" + "<p>Hello!!!</p>"
				+ "</body>" + "</html>").getBytes());
	}
}
