import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class VeureInfo {
	public static void main(String[] args) throws ParseException {

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
				 if(f.isHidden()){
					 System.out.println("El archivo esta oculto");
				 }
//				 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//				  	Date date1 = sdf.parse(sdf.format(f.lastModified()));
//				  	Date date2
				  	if(f.lastModified() - System.currentTimeMillis() <=  259200000){
				  		System.out.println("El Archivo ha sido modificado hace 3 dias");
				  	}
				 //System.out.println("Ultima modificacion "+sdf.format(f.lastModified()));
			 }
			
		 }else{
			 System.out.println("No existe el fichero");
		 }
	}

}

