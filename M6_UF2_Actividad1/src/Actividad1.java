import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actividad1 {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement stmt = null;
		int opcion;
		connection = realizarConexion();
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Que quieres hacer?");
			System.out.println("0 Salir");
			System.out.println("1 Insertar");
			System.out.println("2 Leer");
			System.out.println("3 Modificar");
			System.out.println("4 Eliminar");
			opcion = teclado.nextInt();
			teclado.nextLine();
			if (opcion == 1) {
				System.out
				.println("Quiere insertar (1)alumno o (2)Pobalacion??");
				opcion = teclado.nextInt();
				if (opcion == 1) {
					insertarAlumno(connection, teclado);
				} else {
					insertarPoblacion(connection, teclado);
				}
			} else if (opcion == 2) {
				System.out
				.println("Quieres leer (1)alumnos o (2)Pobalaciones??");
				opcion = teclado.nextInt();
				if (opcion == 1) {
					selectAlumnos(connection, null);
				} else {
					selectPoblacio(connection, null);
				}
			} else if (opcion == 3) {
				updateAlumnos(connection, teclado);
			} else if (opcion == 4) {
				System.out
				.println("Quieres eliminar (1)alumnos o (2)Pobalaciones??");
				opcion = teclado.nextInt();
				teclado.nextLine();
				if (opcion == 1) {
					deleteAlumnos(connection, teclado);
				} else {
					deletePoblacion(connection, teclado);
				}
			}
		} while (opcion != 0);
		connection.close();
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

	private static void insertarAlumno(Connection connection, Scanner teclado) {
		Statement stmt = null;
		System.out.println("Diga los alumnos que quiere insertar");
		int alumnos = teclado.nextInt();
		teclado.nextLine();
		for (int i = 0; i < alumnos; i++) {
			System.out.println("Diga el nombre");
			String nom = teclado.nextLine();
			System.out.println("Diga el la fecha de nacimiento");
			String fecha = teclado.nextLine();
			System.out.println("Diga el direccion postal");
			String direccion = teclado.nextLine();
			System.out.println("Diga el dni");
			String dni = teclado.nextLine();
			System.out.println("Diga el codigo postal");
			String codigoPostal = teclado.nextLine();

			try {
				if (connection.isClosed()) {
					connection = realizarConexion();
				}
				stmt = connection.createStatement();
				stmt.execute("INSERT INTO alumnes (nombre,fechaDeNacimiento,direccioPostal,dni,codiPostal) "
						+ "VALUES ('"+ nom+ "','"+ fecha+ "','"+ direccion+ "','" + dni + "'," + codigoPostal + ")");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void insertarPoblacion(Connection connection, Scanner teclado) {
		Statement stmt = null;
		System.out.println("Diga las poblaciones que quiere insertar");
		int alumnos = teclado.nextInt();
		teclado.nextLine();
		for (int i = 0; i < alumnos; i++) {
			System.out.println("Diga el nombre");
			String nom = teclado.nextLine();
			System.out.println("Diga el codigo postal");
			String codigoPostal = teclado.nextLine();

			try {
				if (connection.isClosed()) {
					connection = realizarConexion();
				}
				stmt = connection.createStatement();
				stmt.execute("INSERT INTO poblaciones (nombre,CP) "
						+ "VALUES ('" + nom + "'," + codigoPostal + ")");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void selectAlumnos(Connection connection, String dni) {
		Statement selectStmt = null;
		try {
			if (connection.isClosed()) {
				connection = realizarConexion();
			}
			selectStmt = connection.createStatement();
			String stmWhere = "";
			if (dni != null && dni.length() == 9) {
				stmWhere = " WHERE dni='" + dni + "'";
			}
			ResultSet rs = selectStmt
					.executeQuery("SELECT nombre,fechaDeNacimiento,direccioPostal,dni,codiPostal FROM alumnes"
							+ stmWhere);
			System.out.println("Alumnos");
			while (rs.next()) {
				System.out.print(rs.getString(1) + "      ");
				System.out.print(rs.getString(2) + "      ");
				System.out.print(rs.getString(3) + "      ");
				System.out.print(rs.getString(4) + "      ");
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void selectPoblacio(Connection connection, String cP) {
		Statement selectStmt = null;
		try {
			if (connection.isClosed()) {
				connection = realizarConexion();
			}
			selectStmt = connection.createStatement();
			String stmWhere = "";
			if (cP != null && cP.length() == 5) {
				stmWhere = " WHERE CP=" + cP;
			}
			ResultSet rs = selectStmt
					.executeQuery("SELECT nombre,CP FROM poblaciones"
							+ stmWhere);
			System.out.println("Pobalciones");
			while (rs.next()) {
				System.out.print(rs.getString(1) + "      ");
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updateAlumnos(Connection connection, Scanner teclado) {
		Statement stmt = null;
		String dni;
		do {
			System.out.println("diga el dni del alumno que quiera modificar");
			dni = teclado.nextLine();
		} while (dni.length() > 9 || dni.length() < 9);
		selectAlumnos(connection, dni);
		try {
			System.out.println("Diga el nuevo nombre");
			String nom = teclado.nextLine();
			System.out.println("Diga la nueva fecha de nacimiento");
			String fecha = teclado.nextLine();
			System.out.println("Diga la nueva direccion postal");
			String direccion = teclado.nextLine();
			System.out.println("Diga el nuevo dni");
			String dni2 = teclado.nextLine();
			System.out.println("Diga el nuevo codigo postal");
			String codigoPostal = teclado.nextLine();
			if (connection.isClosed()) {
				connection = realizarConexion();
			}
			stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE alumnes SET nombre='" + nom
					+ "',fechaDeNacimiento='" + fecha + "',direccioPostal='"
					+ direccion + "',dni='" + dni + "',codiPostal="
					+ codigoPostal + " " + "WHERE dni= '" + dni + "'");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deleteAlumnos(Connection connection, Scanner teclado) {
		Statement stmt = null;
		String dni;
		do {
			System.out.println("diga el dni del alumno que quiera eliminar");
			dni = teclado.nextLine();
		} while (dni.length() > 9 || dni.length() < 9);
		selectAlumnos(connection, dni);
		System.out.println("Seguro que desea elimar??(Si/No)");
		if (teclado.next().equalsIgnoreCase("si")) {
			try {
				if (connection.isClosed()) {
					connection = realizarConexion();
				}
				stmt = connection.createStatement();
				stmt.execute("DELETE FROM alumnes WHERE dni='" + dni + "'");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void deletePoblacion(Connection connection, Scanner teclado) {
		Statement stmt = null;
		String cp;
		do {
			System.out
			.println("diga el CP de la pobalcion que quieres eliminar");
			cp = teclado.nextLine();
			if (cp.length() != 5) {
				System.err.println("El codigo postal es de 5 digitos");
			}
		} while (cp.length() > 5 || cp.length() < 5);
		selectPoblacio(connection, cp);
		System.out.println("Seguro que desea elimar??(Si/No)");
		if (teclado.next().equalsIgnoreCase("si")) {
			try {
				if (connection.isClosed()) {
					connection = realizarConexion();
				}
				stmt = connection.createStatement();
				stmt.execute("DELETE FROM poblaciones WHERE CP=" + cp);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}


}