import java.io.File;


public class VeureInfo {

	public static void main(String[] args) {
		System.out.println("INFORMACIÓ SOBRE EL FITXER");
		 File f = new File("javi");
		 if(f.exists()){
			 System.out.println("Nom del fitxer : "+f.getName());
			 System.out.println("Ruta           : "+f.getPath());
			 System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
			 System.out.println("Es pot escriure: "+f.canRead());
			 System.out.println("Es pot llegir  : "+f.canWrite());
			 System.out.println("Grandaria      : "+f.length());
			 System.out.println("Es un directori: "+f.isDirectory());
			 System.out.println("Es un fitxer   : "+f.isFile());
		 }
	}

}

