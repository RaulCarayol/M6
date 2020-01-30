import java.io.File;
import java.io.FileNotFoundException;
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
		
		JAXBContext context = JAXBContext.newInstance(Planta.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Plantas plantas = leerPlantas();
		
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
	
	private static Plantas leerPlantas() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Diga el numero de plantas que desea introducir");
		int numPlantas = teclado.nextInt();
		Planta[] arrayPlanta = new Planta[numPlantas];
		for (int i = 0; i < arrayPlanta.length; i++) {
			arrayPlanta[i] = pedirPlanta(teclado,i);
		}
	
		Plantas plantas = new Plantas(arrayPlanta);
		return plantas;
	}

	private static Planta pedirPlanta(Scanner teclado, int i) {
		System.out.println("--Planta "+i+"--");
		System.out.println();
		String common;
		
		int availability;
		String price;
		
		String light;
		int zone;
		String botanical;
		return new Planta(common, botanical, zone, light, price, availability);
	}

}
