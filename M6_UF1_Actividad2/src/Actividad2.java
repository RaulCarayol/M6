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
					teclado.nextLine();
					escribirBloqueCotxe(teclado);

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

	public static void escribirBloqueCotxe(Scanner teclado) throws IOException{
		boolean continuar = true;
		Cotxe cotxe;
		//Declaració del fitxer
		System.out.println("Escriba el fichero");
		File fitxer = new File(teclado.nextLine());
		if(!fitxer.exists()){
			System.out.println("El fichero no existe");
			System.out.println("Quieres crear el fichero ??(si/no)");
			if(teclado.nextLine().equalsIgnoreCase("si")){
				if(fitxer.createNewFile()){
					System.out.println(fitxer.getName()+" Creado Correctamente");
				}else{
					System.out.println("No se ha Creado el fichero");
				}
			}else{
				continuar = false;
			}
		}
		if(continuar){
			FileOutputStream fileout= new FileOutputStream(fitxer,true);

			//Crea el flux de sortida
			
			//Connectar el flux de bytes al flux de dades
			ObjectOutputStream dataOuComarq;
			if(!fitxer.exists() || fitxer.length() <= 1){
				dataOuComarq = new ObjectOutputStream(fileout);
			}else{
				dataOuComarq = new ObjectOutputStream(fileout) { protected void writeStreamHeader() throws IOException {
						reset();
	                }
	            };
			    
			}
			do{
				//datos para el cotxe
				cotxe = pedirDatosCotxe( teclado);
				System.out.println("Modelo: " +cotxe.getModel()+ " Marca: "
						+ cotxe.getMarca()+" Matricula:"+cotxe.getMatricula() +" Año:"+cotxe.getAny());
				dataOuComarq.writeObject(cotxe);//L'escriu al fixer
				System.out.println("Quieres continuar escribiendo coches?(no/si)");
			}while(teclado.nextLine().equalsIgnoreCase("si"));
			dataOuComarq.reset();
			//dataOuComarq.close();//Tanca el stream de sortida
			System.gc();
			
		}
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