package BibliotecaDAO;

import Biblioteca.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, matricula, email) VALUES (?, ?, ?)";
		try (Connection conn = ConexaoBD.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getMatricula());
			pstmt.setString(3, usuario.getEmail());
			pstmt.executeUpdate();
			System.out.println("Usuário adicionado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodosUsuarios() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<>();
		try (Connection conn = ConexaoBD.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nome"), rs.getString("matricula"),
						rs.getString("email"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	// Métodos para buscar por matrícula, atualizar e remover usuários
}
