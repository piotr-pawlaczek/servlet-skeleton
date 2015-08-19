package pl.piopaw.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("Beer selection advice <br>");
		String c = request.getParameter("color");

		BeerExpert be = new BeerExpert();
		List<String> result = be.getBrands(c);

		request.setAttribute("styles", result);

		System.out.println("LocalPort: " + request.getLocalPort());
		System.out.println("ServerPort: " + request.getServerPort());
		System.out.println("RemotePort: " + request.getRemotePort());

		response.setHeader("header", "x2");
		response.addHeader("header", "x1");

		System.out.println(response.getHeader("header")); // x2

		RequestDispatcher view = request.getRequestDispatcher("result.jsp");

		view.forward(request, response);

		getServletContext().setAttribute("ddd", "Dodany atrybut");
		getServletContext().setAttribute("ddd", "Zmieniony atrybut");
		getServletContext().removeAttribute("ddd");

		// OutputStream os = response.getOutputStream();
		// out.println("<br>Got beer color "+c);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");

		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("/znaczek.pdf");

		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}

}
