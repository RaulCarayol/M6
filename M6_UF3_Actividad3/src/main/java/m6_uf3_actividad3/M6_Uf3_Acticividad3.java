/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf3_actividad3;

/**
 *
 * @author Raúl Carayol Rodríguez
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;


public class M6_Uf3_Acticividad3 {
    public static void main(String[] args) throws XMLDBException {
        Scanner teclado = new Scanner(System.in);
        //Driver per a eXist
        String driver = "org.exist.xmldb.DatabaseImpl";
	//Col·lecció
	Collection col = null;
	//URI col·lecció
	String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/Proves";
	//Usuari
	String usuari = "admin";
	//Contrasenya
	String usuarioContrasenya = "admin";
        try {
		//Carrega el driver
		Class cl = Class.forName(driver);
		//Instància de la BD
		Database database = (Database) cl.newInstance();
		//Registre del driver
		DatabaseManager.registerDatabase(database);
		} catch (Exception e) {
			System.out.println("Error en inicialitzar la base de dades eXist");
			e.printStackTrace();
		}
		
		col = DatabaseManager.getCollection(URI, usuari, usuarioContrasenya);
	if (col==null){
            System.out.println("*** LA COL·LECCIÓ NO EXISTEIX ***");
        }
	XPathQueryService servei =(XPathQueryService) col.getService("XPathQueryService", "1.0");
        int opcion=0;
        while(opcion != 4){
            System.out.println("Diga una opcion:");
            System.out.println("1: Mostrar los empleados de un departamento");
            System.out.println("2: insertar un departamento");
            System.out.println("3: eliminar un departamento");
            System.out.println("4: Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if(opcion ==1){
               buscarEmpleadoDeUnDepartamento(teclado,servei);

            }else if(opcion==2){
                insereixdep(teclado,servei);
            }else if(opcion==3){
                esborradep(teclado,servei);
            }
        }
        //S'esborra
	col.close();
    }
    public static void buscarEmpleadoDeUnDepartamento(Scanner teclado,XPathQueryService servei) throws XMLDBException{
        System.out.println("Diga el nombre del departamento");
        String departamento = teclado.next();
        String sentencia = "for $num in /departamentos/DEP_ROW[DNOMBRE='"+departamento+"']/DEPT_NO"
                + " let $emp := /EMPLEADOS/EMP_ROW[DEPT_NO=$num] return $emp" ;
                ResourceSet result =
		servei.query(sentencia);
		//Recórrer les dades del recurs
		ResourceIterator i;
		i = result.getIterator();
		if (!i.hasMoreResources())
			System.out.println("LA CONSULTA NO TORNA RES");
		while (i.hasMoreResources()) {
			Resource r = i.nextResource();
			System.out.println((String)r.getContent());
		
		}
    }

    private static void insereixdep(Scanner teclado,XPathQueryService servei) throws XMLDBException {
         System.out.println("Diga el nombre del departamento");
        String departamento = teclado.next();
         System.out.println("Diga el numero del departamento");
        int num = teclado.nextInt();
         System.out.println("Diga la localizacion del departamento");
        String loc = teclado.next();
        
             ResourceSet result =
		servei.query("update insert\n" +"<DEP_ROW><DEPT_NO>"+num+"</DEPT_NO>"
                        + "<DNOMBRE>"+departamento+"</DNOMBRE>"
                        + "<LOC>"+loc+"</LOC></DEP_ROW> into /departamentos");


                System.out.println("Se ha insertado con exito");
                mostrarDepartamentos(servei);
    }

    private static void esborradep(Scanner teclado,XPathQueryService servei) throws XMLDBException {
        //mostrar todos los departamentos
        mostrarDepartamentos(servei);

         System.out.println("Diga el numero del departamento");
        int num = teclado.nextInt();

        
             ResourceSet result =
		servei.query("update delete /departamentos/DEP_ROW[DEPT_NO="+num+"]");

             
                System.out.println("Se ha Borrado con exito");
                mostrarDepartamentos(servei);
    }
    
    private static void mostrarDepartamentos(XPathQueryService servei) throws XMLDBException{
                ResourceSet result0 = servei.query("for $dep in /departamentos/DEP_ROW\n" 
                +"return $dep");
        //Recórrer les dades del recurs
		ResourceIterator i;
		i = result0.getIterator();
		if (!i.hasMoreResources())
			System.out.println("LA CONSULTA NO TORNA RES");
		while (i.hasMoreResources()) {
			Resource r = i.nextResource();
			System.out.println((String)r.getContent());
		
		}
    }
}
