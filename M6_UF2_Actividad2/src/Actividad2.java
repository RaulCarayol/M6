import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		 		connection = realizarConexion();
					realizarTransaccion(connection);
					//cerrar conexion
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				
		 	}

			private void realizarTransaccion(Connection connection) {
				PreparedStatement preparedStatement = null;
				try {
					//realizar conexion si esta cerrada
					if(connection.isClosed()){connection = realizarConexion();}
					//quitar el autoCommit
					connection.setAutoCommit(false);
					//realizar el insert
					preparedStatement = connection.prepareStatement("INSERT INTO Poblaciones (nombre, CP) VALUES (?,?)");
					//poner los datos para evitar injecciones
					preparedStatement.setInt(1, 43203);
					preparedStatement.setString(2, "Tarragona");
					preparedStatement.executeUpdate();
					//realizar el segundo insert
					preparedStatement = connection.prepareStatement("INSERT INTO Poblaciones (nombre, CP) VALUES (?,?)");
					//poner los datos para evitar injecciones
					preparedStatement.setInt(1, 43217);
					preparedStatement.setString(2, "Barcelona");
					preparedStatement.executeUpdate();

					Thread.sleep(4000);
					//realizar delete
					preparedStatement = connection.prepareStatement("DELETE FROM Poblaciones WHERE CP = ?");
					preparedStatement.setInt(1, 43203);
					preparedStatement.executeUpdate();
					//hacer un commit
					connection.commit();
					connection.setAutoCommit(true);
					graficos.lblMensaje.setText("Insertado y borrado.");
					
				//recojer las excepciones
				} catch (SQLException e) {
					try {
						//hacer un rollback en caso de una excepcion sql
						connection.rollback();
					} catch (SQLException e1) {
						//mostrar mensje si salta una excepcion durante el rollback
						graficos.lblMensaje.setText("El rollback ha fallado");
					}
					//mostrar cuando ha acabado 
					graficos.lblMensaje.setText("Realizado Rollback");

				} catch (InterruptedException e) {
					//Mostrar mensaje de error
					graficos.lblMensaje.setText(e.getMessage());

				} finally {
					try {
						if (preparedStatement != null && !preparedStatement.isClosed()) {
							preparedStatement.close();
						}
					} catch (SQLException e) {
						graficos.lblMensaje.setText("Error cerrando Prepared Statement");
					}
				}
			}
		 });
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
