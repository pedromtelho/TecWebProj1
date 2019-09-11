package br.edu.insper.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DAO {
	private Connection connection = null;

	public DAO() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projectCrud", "root",
					"Pedropaulo_1429051900");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int adiciona(Cadastros pessoa) {
		String sql = "INSERT INTO Cadastro" + "(login,senha) values(?,?)";
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;

		try {
			stmt2 = connection.prepareStatement("SELECT * FROM Cadastro WHERE login=?");
			stmt2.setString(1, pessoa.getLogin());
			rs = stmt2.executeQuery();

			if (rs.next()) {
				return 1;
			} else {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, pessoa.getLogin());
				stmt.setString(2, pessoa.getSenha());
				stmt.execute();
				stmt.close();
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
	}

	public Cadastros verifica(String loginUser, String loginSenha) {
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Cadastros user = new Cadastros();
		try {
			stmt = connection.prepareStatement("SELECT senha FROM Cadastro WHERE login=?");
			stmt.setString(1, loginUser);
			rs = stmt.executeQuery();
			stmt2 = connection.prepareStatement("SELECT * FROM Cadastro WHERE login=?");
			stmt2.setString(1, loginUser);
			rs2 = stmt2.executeQuery();
			if (rs.next()) {
				if (rs2.next()) {
					if (rs2.getString("senha").equals(loginSenha)) {
						user.setId(rs2.getInt("id"));
						user.setLogin(rs2.getString("login"));
						user.setSenha(rs2.getString("senha"));
						return user;
					}
				}
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return user;

	}

	public void adicionaTarefa(Tarefas tarefa) {

		String sql = "INSERT INTO Tasks" + "(user,nome,tarefa,data) values(?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getUser());
			stmt.setString(2, tarefa.getNomeTarefa());
			stmt.setString(3, tarefa.getDescTarefa());
			stmt.setString(4, tarefa.getDate());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ShowTarefas> getTarefas(String loginUser){
		List<ShowTarefas> tarefas = new ArrayList<ShowTarefas>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE user=?");
			stmt.setString(1, loginUser);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ShowTarefas tarefas1 = new ShowTarefas();
				tarefas1.setId(rs.getInt("id"));
				tarefas1.setNome(rs.getString("nome"));
				tarefas1.setTarefa(rs.getString("tarefa"));
				tarefas1.setData(rs.getString("data"));
				tarefas.add(tarefas1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefas;
	}
	
	public List<ShowTarefas> showTarefa(Integer id){
		List<ShowTarefas> tarefas = new ArrayList<ShowTarefas>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tasks WHERE id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ShowTarefas tarefas1 = new ShowTarefas();
				tarefas1.setId(rs.getInt("id"));
				tarefas1.setNome(rs.getString("nome"));
				tarefas1.setTarefa(rs.getString("tarefa"));
				tarefas.add(tarefas1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tarefas;
	}
	
	public void updateTarefa(ShowTarefas tarefa, Integer id) {

		String sql = "UPDATE Tasks SET " + "nome=?, tarefa=? WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getNome());
			stmt.setString(2, tarefa.getTarefa());
			stmt.setInt(3, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delTarefa(Integer id) {
		String sql = "DELETE FROM Tasks WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}