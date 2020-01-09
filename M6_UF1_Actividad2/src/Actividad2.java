import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;


public class Actividad2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Quieres (1)Escribir o (0)leer un coche ?");
		if(teclado.nextInt() == 1){
			System.out.println("Quieres escribir (1)Un cotxe o (0)Varios cotxes");
			if(teclado.nextInt()==1){
				escribirUnCotxe(teclado);
			}else{
				escribirBloqueCotxe(teclado);
			}
			
		}else{
			llegirCotxe(teclado);
		}
		teclado.close();
	
	}
	public static void escribirUnCotxe(Scanner teclado) throws IOException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		//"/home/user/Escriptori/comarquesObject.txt"
		File fitxer = new File(teclado.next());
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
	public static void escribirBloqueCotxe(Scanner teclado) throws IOException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		//"/home/user/Escriptori/comarquesObject.txt"
		File fitxer = new File(teclado.next());
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
		String marca = null, model = null,matricula = null;
		 int any = 0;
		do{
			pedirDatosCotxe(marca, model, matricula, any, teclado);
			cotxe = new Cotxe(model,marca,matricula,any);
			dataOuComarq.writeObject(cotxe);//L'escriu al fixer
			System.out.println("Quieres continuar?(no/si)");
		}while(teclado.next().equalsIgnoreCase("si"));
		dataOuComarq.close();//Tanca el stream de sortida
	}
	public static void pedirDatosCotxe(String marca,String model,String matricula,
	 int any,Scanner teclado){
		System.out.println("Diga la marca");
		marca = teclado.next();
		System.out.println("Diga el modelo");
		model = teclado.next();
		System.out.println("Diga la matricula");
		matricula = teclado.next();
		System.out.println("Diga el año");
		any = teclado.nextInt();
	}
	public static void llegirCotxe(Scanner teclado) throws IOException, ClassNotFoundException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		//"/home/user/Escriptori/comarquesObject.txt"
		File fitxer = new File(teclado.next());
		if(fitxer.exists()){
			//Crea el flux d'entrada
			FileInputStream filein = new FileInputStream(fitxer);
			//Connectar el flux de bytes al flux de dades
			ObjectInputStream dataInComarq = new ObjectInputStream(filein);
			try {
				while (true){//Llegeix el fitxer
					//Llegeix la comarca
					cotxe = (Cotxe) dataInComarq.readObject();
					System.out.println("Modelo: " +cotxe.getModel()+ " Marca: "
					+ cotxe.getMarca()+" Matricula:"+cotxe.getMatricula() +" Año:"+cotxe.getAny());
				}
			} catch (EOFException eo) {}
			dataInComarq.close();//Tanca el stream d'entrada
		
		}else{
			System.out.println("El fichero no existe");
		}
	}

}
