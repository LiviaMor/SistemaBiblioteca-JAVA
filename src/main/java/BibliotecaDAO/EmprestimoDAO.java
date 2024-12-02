package BibliotecaDAO;

import Biblioteca.Emprestimo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
	public void registrarEmprestimo(Emprestimo emprestimo) {
		String sql = "INSERT INTO RegistroEmpretimo (codigoLivro, matriculaUsuario, dataEmprestimo, dataDevolucao, dataDevolucaoEfetiva) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, emprestimo.getCodigo());
			pstmt.setString(2, emprestimo.getMatricula());
			pstmt.setString(3, emprestimo.getDataEmprestimo());
			pstmt.setString(4, emprestimo.getDataDevolucao());
			pstmt.setString(5, emprestimo.getDataDevolucaoEfetiva());
			pstmt.executeUpdate();
			System.out.println("Empréstimo registrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Emprestimo> buscarTodosEmprestimos() {
		String sql = "SELECT * FROM RegistroEmpretimo";
		List<Emprestimo> emprestimos = new ArrayList<>();
		try (Connection conn = ConexaoBD.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo(rs.getInt("id_registroemprestimo"), rs.getString("codigo"),
						rs.getString("matricula"), rs.getString("dataEmprestimo"), rs.getString("dataDevolucao"),
						rs.getString("dataDevolucaoEfetiva"));
				emprestimos.add(emprestimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emprestimos;
	}

}
