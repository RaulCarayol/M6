import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Actividad2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Quieres (1)Escribir o (0)leer un coche ?");
		if(teclado.nextInt() == 1){
			escribirCotxe();
		}else{
			
		}
	
	}
	public static void escribirCotxe() throws IOException{
		Cotxe cotxe;
		//Declaració del fitxer
		File fitxer = new File("/home/user/Escriptori/comarquesObject.txt");
		if(!fitxer.exists()){
			System.out.println("El fichero no existe, se va ha crear");
			if(fitxer.createNewFile()){
				System.out.println(fitxer.getName()+" Creado Correctamente");
			}else{
				System.out.println("No se ha Creado el fichero");
			}
		}
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuComarq = new ObjectOutputStream(fileout);
		//datos para el cotxe
		cotxe = new Cotxe("Audi","Q7","123456QWE",2019);
			dataOuComarq.writeObject(cotxe);//L'escriu al fixer

		dataOuComarq.close();//Tanca el stream de sortida
	}

}
