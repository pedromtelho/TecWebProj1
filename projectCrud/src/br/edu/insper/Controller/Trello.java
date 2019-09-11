package br.edu.insper.Controller;
import br.edu.insper.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Trello")
public class Trello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = dtf.format(now);
		String date = datetime.substring(0, 10);
		String time = datetime.substring(11, 19);

		String nome = request.getParameter("nomeTarefa");
		String desc = request.getParameter("descTarefa");

		Tarefas tarefa = new Tarefas();

		HttpSession session = request.getSession();
		Cadastros user = (Cadastros) session.getAttribute("user");
		tarefa.setUser(user.getLogin());
		tarefa.setNomeTarefa(nome);
		tarefa.setDescTarefa(desc);
		tarefa.setDate(date);
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		dao.adicionaTarefa(tarefa);
		request.setAttribute("dados", dao.getTarefas(user.getLogin()));
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
		rd.forward(request, response);
		dao.close();
	}
}
