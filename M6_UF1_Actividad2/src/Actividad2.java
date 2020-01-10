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
		int opcion;
		do{
			System.out.println("Quieres (0)Escribir, (1)leer un coche, (2)Salir ?");
			 opcion=teclado.nextInt() ;
			if(opcion == 0){
				System.out.println("Quieres escribir (1)Un coche o (0)Varios cotxes");
				if(teclado.nextInt()==1){
					teclado.nextLine();
					escribirUnCotxe(teclado);
				}else{
					teclado.nextLine();
					escribirBloqueCotxe(teclado);
				}
				
			}else if(opcion == 1){
				System.out.println("Quieres leer (1)todos los coches o (0)buscar coches por parametro");
				if(teclado.nextInt()==1){
					teclado.nextLine();
					llegirCotxe(teclado);
				}else{
					teclado.nextLine();
					buscarCotxe(teclado);
				}
			}
		}while(opcion != 2);
		teclado.close();
	
	}
	public static void escribirUnCotxe(Scanner teclado) throws IOException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		//"/home/user/Escriptori/comarquesObject.txt"
		File fitxer = new File(teclado.nextLine());
		if(!fitxer.exists()){
			System.out.println("El fichero no existe, se va ha crear");
			if(fitxer.createNewFile()){
				System.out.println(fitxer.getName()+" Creado Correctamente");
			}else{
				System.out.println("No se ha Creado el fichero");
			}
		}
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer,true);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuComarq = new ObjectOutputStream(fileout);
		//datos para el cotxe
		cotxe = cotxe = pedirDatosCotxe( teclado);
		dataOuComarq.writeObject(cotxe);//L'escriu al fixer
		dataOuComarq.close();//Tanca el stream de sortida
	}

	public static void escribirBloqueCotxe(Scanner teclado) throws IOException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		//"/home/user/Escriptori/comarquesObject.txt"
		File fitxer = new File(teclado.nextLine());
		if(!fitxer.exists()){
			System.out.println("El fichero no existe, se va ha crear");
			if(fitxer.createNewFile()){
				System.out.println(fitxer.getName()+" Creado Correctamente");
			}else{
				System.out.println("No se ha Creado el fichero");
			}
		}
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer,true);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuComarq = new ObjectOutputStream(fileout);
		do{
			//datos para el cotxe
			cotxe = pedirDatosCotxe( teclado);
			System.out.println("Modelo: " +cotxe.getModel()+ " Marca: "
					+ cotxe.getMarca()+" Matricula:"+cotxe.getMatricula() +" Año:"+cotxe.getAny());
			dataOuComarq.writeObject(cotxe);//L'escriu al fixer
			System.out.println("Quieres continuar?(no/si)");
		}while(teclado.nextLine().equalsIgnoreCase("si"));
		dataOuComarq.close();//Tanca el stream de sortida
	}
	public static Cotxe pedirDatosCotxe(Scanner teclado){
		String marca,model, matricula;
		 int any;
		System.out.println("Diga la marca");
		marca = teclado.nextLine();
		System.out.println("Diga el modelo");
		model = teclado.nextLine();
		System.out.println("Diga la matricula");
		matricula = teclado.nextLine();
		System.out.println("Diga el año");
		any = teclado.nextInt();
		teclado.nextLine();
		return new Cotxe(model,marca,matricula,any);
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
				while (true){
					//Llegeix el fitxer
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
	
	public static void buscarCotxe(Scanner teclado) throws IOException, ClassNotFoundException{
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		File fitxer = new File(teclado.nextLine());
		
		if(fitxer.exists()){
			System.out.println("dime un parametro del coche");
			String parametro = teclado.nextLine();
			System.out.println("Parametro:"+parametro);
			//Crea el flux d'entrada
			FileInputStream filein = new FileInputStream(fitxer);
			//Connectar el flux de bytes al flux de dades
			ObjectInputStream dataInComarq = new ObjectInputStream(filein);
			try {
				while (true){
					//Llegeix el fitxer
					cotxe = (Cotxe) dataInComarq.readObject();
					//mira coincidencia de 
					if(cotxe.getModel().contains(parametro) || cotxe.getMarca().contains(parametro) || 
							cotxe.getMatricula().equalsIgnoreCase(parametro) || Integer.toString(cotxe.getAny()).equalsIgnoreCase(parametro)){
						System.out.println("Modelo: " +cotxe.getModel()+ " Marca: "
						+ cotxe.getMarca()+" Matricula:"+cotxe.getMatricula() +" Año:"+cotxe.getAny());
					}
				}
			} catch (EOFException eo) {}
			dataInComarq.close();//Tanca el stream d'entrada
		
		}else{
			System.out.println("El fichero no existe");
		}
	}

}
