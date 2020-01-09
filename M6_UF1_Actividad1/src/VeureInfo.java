import java.io.File;
import java.text.ParseException;

public class VeureInfo {
	public static void main(String[] args) throws ParseException {
		//comprueba si se ha especificado la ruta
		if(args.length==0 || args.equals(null)){
			System.out.println("No se ha especificado el fichero");
		}else{
			 File f = new File(args[0]);
			 if(f.exists()){
				 if(f.isDirectory()){
					 System.out.println("INFORMACIÓ SOBRE EL DIRECTORI");
					 String[] arxius = f.list();
					 for (int i = 0; i<arxius.length; i++){
						 System.out.println(arxius[i]);
					 }
				 }else{
					 System.out.println("INFORMACIÓ SOBRE EL FITXER");
					 //muestra el nombre
					 System.out.println("Nom del fitxer : "+f.getName());
					 //la ruta
					 System.out.println("Ruta           : "+f.getPath());
					 //ruta absoluta
					 System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
					 //si el archivo se puede escribir
					 System.out.println("Es pot escriure: "+f.canRead());
					 //si el archivo se puede leer
					 System.out.println("Es pot llegir  : "+f.canWrite());
					 //el tamaño del archivo
					 System.out.println("Grandaria      : "+f.length());
					 //devuelve un boolean si esta oculto o no
					 if(f.isHidden()){
						 System.out.println("El archivo esta oculto");
					 }
					 //mira la que la diferencia en milisegundos de cuando fue modificado y 
					 //la fecha actual sea de 3 dias en milisegundos	
					 if(f.lastModified() - System.currentTimeMillis() >=  -259200000){
					  		System.out.println("El Archivo ha sido modificado hace 3 dias");
					 }
				 }
				
			 }else{
				 System.out.println("No existe el fichero");
			 }
		}
	}
}