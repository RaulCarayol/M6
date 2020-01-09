import java.io.File;


public class VeureInfo {
	public static void main(String[] args) {

		System.out.println("INFORMACIÓ SOBRE EL FITXER");
		 File f = new File(args[0]);
		 if(f.exists()){
			 if(f.isDirectory()){
				 String[] arxius = f.list();
				 for (int i = 0; i<arxius.length; i++){
					 System.out.println(arxius[i]);
				 }
			 }else{
				 System.out.println("Nom del fitxer : "+f.getName());
				 System.out.println("Ruta           : "+f.getPath());
				 System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
				 System.out.println("Es pot escriure: "+f.canRead());
				 System.out.println("Es pot llegir  : "+f.canWrite());
				 System.out.println("Grandaria      : "+f.length());
			 }
			
		 }else{
			 System.out.println("No existe el fichero");
		 }
	}

}

