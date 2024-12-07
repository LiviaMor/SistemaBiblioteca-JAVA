package BibliotecaDAO;

import Biblioteca.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        this.connection = ConexaoBD.conectar();
    }

    // Create
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, matricula, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        	pstmt.setString(1, usuario.getNome());
        	pstmt.setString(2, usuario.getMatricula());
        	pstmt.setString(3, usuario.getEmail());
        	pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar usuário: ", e);
        }
    }

    // Read
    public List<Usuario> buscarTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("matricula"),
                        rs.getString("email")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários: ", e);
        }
        return usuarios;
    }

    // Update
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, matricula = ?, email = ? WHERE id_usuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        	pstmt.setString(1, usuario.getNome());
        	pstmt.setString(2, usuario.getMatricula());
        	pstmt.setString(3, usuario.getEmail());
        	pstmt.setInt(4, usuario.getId_usuario());
        	pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: ", e);
        }
    }

    // Delete
    public void deletarUsuario(int id_Usuario) {
        String sql = "DELETE FROM usuario WHERE matricula = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        	pstmt.setInt(1, id_Usuario);
        	pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário: ", e);
        }
    }
}
