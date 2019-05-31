import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSystemDate extends HttpServlet {
	/**
	 * @author wxz18
	 */
	private static final long serialVersionUID = 1L;
	public String getDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(new Date());
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String htmlCodeString = "<html><head><title>SystemDate</title></head><body>";
		htmlCodeString += getDate();
		htmlCodeString += "</body></html>";
		PrintWriter pw = resp.getWriter();
		pw.println(htmlCodeString);
		pw.flush();
	}
}
