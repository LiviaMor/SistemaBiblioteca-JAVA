package BibliotecaDAO;

import Biblioteca.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

	// Create
	public void adicionarLivro(Livro livro) {
		String sql = "INSERT INTO livro (codigo, titulo, autor, ano) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, livro.getCodigo());
			pstmt.setString(2, livro.getTitulo());
			pstmt.setString(3, livro.getAutor());
			pstmt.setString(4, livro.getAno());
			pstmt.executeUpdate();
			System.out.println("Livro adicionado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Read
	public List<Livro> buscarTodosLivros() {
		String sql = "SELECT * FROM livro";
		List<Livro> livros = new ArrayList<>();
		try (Connection conn = ConexaoBD.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Livro livro = new Livro(rs.getInt("id_livro"), rs.getString("codigo"), rs.getString("titulo"),
						rs.getString("autor"), rs.getString("ano"));
				livros.add(livro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	// Update
	public void atualizarLivro(Livro livro) {
		String sql = "UPDATE livro SET codigo = ?, titulo = ?, autor = ?, ano = ? WHERE id_livro = ?";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, livro.getCodigo());
			pstmt.setString(2, livro.getTitulo());
			pstmt.setString(3, livro.getAutor());
			pstmt.setString(4, livro.getAno());
			pstmt.setInt(5, livro.getId_livro());
			pstmt.executeUpdate();
			System.out.println("Livro atualizado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete
	public void deletarLivro(int id_livro) {
		String sql = "DELETE FROM livro WHERE codigo = ?";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id_livro);
			pstmt.executeUpdate();
			System.out.println("Livro deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
