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

/**
 * Servlet implementation class TelaInicial
 */
@WebServlet("/TelaInicial")
public class TelaInicial extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String senha1 = request.getParameter("Senha");
		String senha2 = request.getParameter("ConfSenha");
		String senhaIncor = "As senhas estão diferentes. Digite novamente.";
		String senhaNull = "Você deve digitar os campos em branco.";
		String newUser = "Esse nome de usuário já existe. Digite outro nome.";

		if (!senha1.equals(senha2)) {
			request.setAttribute("senhaIncor", senhaIncor);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		} else if (senha1.equals("")) {
			request.setAttribute("senhaIncor", senhaNull);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			DAO dao = null;
			try {
				dao = new DAO();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Cadastros pessoa = new Cadastros();
			pessoa.setLogin(request.getParameter("User"));
			pessoa.setSenha(request.getParameter("Senha"));
			int user = dao.adiciona(pessoa);
			if (user == 1) {
				request.setAttribute("newUser", newUser);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else if (user == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
//				response.sendRedirect(request.getContextPath() + "/Login");
				dao.close();
			}
		}
	}
}