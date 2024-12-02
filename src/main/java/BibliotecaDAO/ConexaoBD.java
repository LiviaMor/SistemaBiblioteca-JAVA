package BibliotecaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	private static final String URL = "jdbc:mysql://localhost:3306/db_biblioteca";
	private static final String USER = "root";
	private static final String PASSWORD = "1904";

	public static Connection conectar() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexão estabelecida com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
