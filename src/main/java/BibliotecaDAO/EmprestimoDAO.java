package BibliotecaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Emprestimo;

public class EmprestimoDAO {
	public void registrarEmprestimo(Emprestimo emprestimo) {
		String sql = "INSERT INTO RegistroEmprestimo (codigo, matricula, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, emprestimo.getcodigo());
			pstmt.setString(2, emprestimo.getmatricula());
			pstmt.setString(3, emprestimo.getDataEmprestimo());
			pstmt.setString(4, emprestimo.getDataDevolucao());

			pstmt.executeUpdate();
			System.out.println("Empréstimo registrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Emprestimo> buscarTodosEmprestimos() {
		String sql = "SELECT * FROM db_biblioteca.registroemprestimo";
		List<Emprestimo> emprestimos = new ArrayList<>();
		try (Connection conn = ConexaoBD.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo(rs.getInt("id_registroemprestimo"), rs.getString("codigo"),
						rs.getString("matricula"), rs.getString("data_emprestimo"),
						rs.getString("data_devolucao"));
				emprestimos.add(emprestimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emprestimos;
	}
}
