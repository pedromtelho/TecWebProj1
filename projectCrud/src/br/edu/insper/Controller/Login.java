package br.edu.insper.Controller;

import br.edu.insper.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("User");
		String senha = request.getParameter("Senha");
		String invalidLogin = "Verifique se digitou corretamente o nome de usuário ou senha.";
		
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Cadastros id = dao.verifica(user, senha);
		if(id.getId() != 0 && id != null) {
			HttpSession session = request.getSession(true);
		    session.setAttribute("user",id);
		    request.setAttribute("dados", dao.getTarefas(id.getLogin()));

			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			dao.close();
		}
		
		else {
			request.setAttribute("name", invalidLogin);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			out.println("<h3>Seu usuário ou senha estão incorretos.</h3>");
		}

	}

}
