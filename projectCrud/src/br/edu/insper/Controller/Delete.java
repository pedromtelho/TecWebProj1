package br.edu.insper.Controller;
import br.edu.insper.Model.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Cadastros user = (Cadastros) session.getAttribute("user");
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ShowTarefas i : dao.getTarefas(user.getLogin())) {
			if (Integer.valueOf(id) == i.getId()) {
				dao.delTarefa(Integer.valueOf(id));
			}
		}
		request.setAttribute("user", user);
		request.setAttribute("dados", dao.getTarefas(user.getLogin()));
		RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
		rd.forward(request, response);
		dao.close();
		
	}

}
