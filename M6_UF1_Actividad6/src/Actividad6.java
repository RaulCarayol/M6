
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Actividad6 {
	private static final String XML_FILE = "plant_catalog2.xml";
	public static void main(String[] args) throws JAXBException, IOException {
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		do{
			System.out.println();
			System.out.println("MENU");
			System.out.println("1-Crear XML ");
			System.out.println("2-Leer XML ");
			System.out.println("3-Salir ");
			opcion = teclado.nextInt();
			if(opcion == 1){
				crearXml(teclado);
			}else if(opcion == 2){
				xmlAObjeto(teclado);
			}
		}while(opcion!=3);
		teclado.close();
	}
	private static void xmlAObjeto(Scanner teclado) throws JAXBException {
		File file = new File(XML_FILE);  
        JAXBContext jaxbContext = JAXBContext.newInstance(Plantas.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Plantas plantas= (Plantas) jaxbUnmarshaller.unmarshal(file);  
          
        System.out.println("Plantas:");  
        //array de plantas del fichero xml
        Planta[] arrayPlanta=plantas.getPlantas();
        //mostrando por pantalla las plantas y alguno de sus atributos
        for (int i = 0; i < arrayPlanta.length; i++) {
        	 System.out.println(arrayPlanta[i].getCommon()+" "+arrayPlanta[i].getBotanical()+"  "+arrayPlanta[i].getLight()+"  "+arrayPlanta[i].getPrice());  
		}
		
	}
	public static void crearXml(Scanner teclado) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(Plantas.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Plantas plantas = leerPlantas(teclado);
		
		//Mostrem el document XML generat por la sortida estandard
		marshaller.marshal(plantas, System.out);
		
		FileOutputStream fos = new FileOutputStream(XML_FILE);
		//guardem l'objecte serializat en un document XML
		marshaller.marshal(plantas, fos);
		fos.close();
		
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserialitzem a partir de un document XML
		Plantas plantas2 = (Plantas) unmarshaller.unmarshal(new File(XML_FILE));
		System.out.println("********* Alumnes carregat desde fitxer XML***************");
		//Mostrem l'objeto Java obtingut
		marshaller.marshal(plantas2, System.out);
	}
	private static Plantas leerPlantas(Scanner teclado) {
		
		System.out.println("Diga el numero de plantas que desea introducir");
		int numPlantas = teclado.nextInt();
		teclado.nextLine();
		Planta[] arrayPlanta = new Planta[numPlantas];
		//se piden plantas por teclado
		for (int i = 0; i < arrayPlanta.length; i++) {
			pedirPlanta(teclado,i,arrayPlanta);
		}
	
		Plantas plantas = new Plantas();
		plantas.setPlantas(arrayPlanta);
		return plantas;
	}

	private static void pedirPlanta(Scanner teclado, int i, Planta[] arrayPlanta) {
		System.out.println("--Planta "+(i+1)+"--");
		arrayPlanta[i] = new Planta();
		System.out.println("Diga el nombre comun");
		arrayPlanta[i].setCommon(teclado.nextLine());
		System.out.println("Diga el nombre botanico");
		arrayPlanta[i].setBotanical(teclado.nextLine());
		System.out.println("Diga el numero de la zona");
		arrayPlanta[i].setZone(teclado.nextInt());
		teclado.nextLine();
		System.out.println("Diga light");
		arrayPlanta[i].setLight(teclado.nextLine());
		System.out.println("Diga el precio");
		arrayPlanta[i].setPrice(teclado.nextLine());
		System.out.println("Diga la cantidad en stock");
		arrayPlanta[i].setAvailability(teclado.nextInt());
		teclado.nextLine();
	}

}
