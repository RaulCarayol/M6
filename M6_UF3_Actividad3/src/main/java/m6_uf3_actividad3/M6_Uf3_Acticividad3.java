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
        
        ResourceSet result =
		servei.query(buscarEmpleadoDeUnDepartamento(teclado));
		
		//Recórrer les dades del recurs
		ResourceIterator i;
		i = result.getIterator();
		if (!i.hasMoreResources())
			System.out.println("LA CONSULTA NO TORNA RES");
		while (i.hasMoreResources()) {
			Resource r = i.nextResource();
			System.out.println((String)r.getContent());
		
		}
		

     
        //S'esborra
	col.close();
    }
    public static String buscarEmpleadoDeUnDepartamento(Scanner teclado){
        System.out.println("Diga el nombre del departamento");
        String departamento = teclado.next();
        return "for $num in /departamentos/DEP_ROW[DNOMBRE='"+departamento+"']/DEPT_NO"
                + " let $emp := /EMPLEADOS/EMP_ROW[DEPT_NO=$num] return $emp" ;
    }
    
}
