import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Actividad2 {
	private static Connection connection = null;
	private static M6_Actividad2_Graphics graficos;
	public static void main(String[] args) {
		Statement stmt = null;
		int opcion;
		 graficos = new M6_Actividad2_Graphics();
		graficos.btnInsertar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		realizarTransaccion(connection);
		 	}

			private void realizarTransaccion(Connection connection) {
				// TODO Auto-generated method stub
				
			}
		 });
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
