import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Actividad3 {
	private static Actividad3_Graphics graficos;
	private static Connection connection = null;
	
	public static void main(String[] args) {
		
		graficos = new Actividad3_Graphics();
		
		graficos.btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//hacer conexion
				connection = realizarConexion();
				if(graficos.rdbtnStament.isSelected()){
					verificarStament(graficos.tfUsuario.getText(),graficos.tfConstrasenya.getText());
				}else{
					verificarPrepared(graficos.tfUsuario.getText(),graficos.tfConstrasenya.getText());
				}
			}});
	}
	private static void verificarStament(String usuario, String contrasenya) {
		Statement selectStmt = null;
		boolean verificado=false;
		try {
			if (connection.isClosed()) {
				connection = realizarConexion();
			}
			selectStmt = connection.createStatement();
			ResultSet rs = selectStmt.executeQuery("f");
			while (rs.next()) {
				if(rs.getString(1).equals(usuario) && rs.getString(2).equals(contrasenya)){
					verificado=true;
				}
			}
			if(verificado){
				graficos.labelVer.setText("Verficado");
			}else{
				graficos.labelVer.setText("No Verficado");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			graficos.labelVer.setText("Error "+ e.getMessage());
		}
	}
	
	private static void verificarPrepared(String usuario, String contrasenya) {
		PreparedStatement preparedStatement = null;
		boolean verificado=false;
		try {
			if (connection.isClosed()) {
				connection = realizarConexion();
			}
			preparedStatement = connection.prepareStatement("SELECT usuario,contrasenya FROM usuarios");
			
			ResultSet rs = preparedStatement.executeQuery("SELECT usuario,contrasenya FROM usuarios");
			while (rs.next()) {
				if(rs.getString(1).equals(usuario) && rs.getString(2).equals(contrasenya)){
					verificado=true;
				}
			}
			if(verificado){
				graficos.labelVer.setText("Verficado");
			}else{
				graficos.labelVer.setText("No Verficado");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			graficos.labelVer.setText("Error "+ e.getMessage());
		}
		
	}
	//realizar conexion
	private static Connection realizarConexion() {
		String url = "jdbc:mysql://localhost:3306/bd6?serverTimezone=UTC";
		String user = "usuari";
		String password = "usuari";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("No se ha encontrado controlador");
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println("Error " + ex.getMessage());
		}
		return connection;
	}
	private static void selectusuarios(Connection connection, String usuario,String contrasenya) {

	}

}
