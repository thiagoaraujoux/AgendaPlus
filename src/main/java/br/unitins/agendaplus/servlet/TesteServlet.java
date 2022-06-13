package br.unitins.agendaplus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {

	private static final long serialVersionUID = 3650881247790534596L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("  <head>");
		writer.println("  </head>");
		writer.println("  <body>");
		writer.println("    <h1>Teste Servlet</h1>");
		writer.println("  </body>");
		writer.println("</html>");
	}
	
}
