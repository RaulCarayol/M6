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
        realizarConexion(connection);
        do{
	        Scanner teclado = new Scanner(System.in);
	        System.out.println("Que quieres hacer?");
	        System.out.println("1 Insertar");
	        System.out.println("2 Leer");
	        opcion = teclado.nextInt();
	        if(opcion==1){
	        	
	        	insertarAlumno(connection,teclado);
	        }else if(opcion==2){
	        	selectAlumnos(connection);
	        }
        }while(opcion!=2);
        connection.close();
	}
	private static void realizarConexion(Connection connection){
        String url= "jdbc:mysql://localhost:3306/m6?serverTimezone=UTC";
        String user = "root";
        String password = "";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
        	System.out.println("No se ha encontrado controlador");
        }
        try
        {
            connection = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
        	System.out.println("eRROR"+ex.getMessage());
        }
	}
	
	private static void insertarAlumno(Connection connection,Scanner teclado){
        Statement stmt = null;
		System.out.println("Diga los alumnos que quiere insertar");
		int alumnos= teclado.nextInt();
		teclado.nextLine();
		for (int i = 0; i < alumnos; i++) {
			System.out.println("Diga el nombre");
			String nom =teclado.nextLine();
			System.out.println("Diga el la fecha de nacimiento");
			String fecha =teclado.nextLine();
			System.out.println("Diga el direccion postal");
			String direccion =teclado.nextLine();
			System.out.println("Diga el dni");
			String dni =teclado.nextLine();
			System.out.println("Diga el codigo postal");
			String codigoPostal =teclado.nextLine();
			
	        try {
	            stmt = connection.createStatement();
	            stmt.execute("INSERT INTO alumnes (nombre,fechaDeNacimiento,direccioPostal,dni,codiPostal) "
	                                + "VALUES ('"+nom+"','"+fecha+"','"+direccion+"','"+dni+"',"+codigoPostal+")");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void selectAlumnos(Connection connection){
		Statement selectStmt = null;
		try{
			selectStmt = connection.createStatement();
	        ResultSet rs = selectStmt.executeQuery("SELECT nombre,fechaDeNacimiento,direccioPostal,dni,codiPostal FROM alumnes");
	        while(rs.next())
	        {
	            System.out.print(rs.getString(1)+"      ");    //First Column
	            System.out.print(rs.getString(2)+"      ");    //Second Column
	            System.out.print(rs.getString(3)+"      ");    //Third Column
	            System.out.println(rs.getString(4));    //Fourth Column
	        }
       }catch(SQLException e){
    	   System.out.println(e.getMessage());
       }
	}

}
