import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Actividad2 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		int opcion;
		connection = realizarConexion();
	}
	
	private static Connection realizarConexion() {
		String url = "jdbc:mysql://localhost:3306/m6?serverTimezone=UTC";
		String user = "root";
		String password = "";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("No se ha encontrado controlador");
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println("eRROR" + ex.getMessage());
		}
		return connection;
	}

}
