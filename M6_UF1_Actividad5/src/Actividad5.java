import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Actividad5 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		// per a carregar en memòria un arxiu xml
		File file = new File("alumni.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		do {
			opcion = mostararMenu(teclado);
			if(opcion != 4){
				if(opcion == 0){
					System.out.println( doc.getDocumentElement().getNodeName());
					//se llama a atributosNodo el nodo raiz
					atriubutosNodo(doc.getDocumentElement()," ");
				}else if(opcion == 1){
					añadirNodo(doc,teclado,file);
				}else if(opcion == 2){
					modificarNodo(doc,teclado,file);
				}else{
					eliminarNodo(doc,teclado,file);
				}
			}
		} while (opcion != 4);
	}
	private static void modificarNodo(Document doc, Scanner teclado, File file) throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Element elem = buscarElementoId(teclado, doc);
		System.out.println("que quieres cambiar ?");
		System.out.println("0: id");
		System.out.println("1: nom");
		System.out.println("2: cognom");
		System.out.println("3: cognom2");
		System.out.println("4: notaFinal");
		int opcion = teclado.nextInt();
		if(opcion == 0){
			System.out.println("diga el id del alumno");
			int id = teclado.nextInt();
			elem.getAttributes().getNamedItem("id").setTextContent(Integer.toString(id));;
		}else if(opcion == 1){
			System.out.println("diga el nombre");
			String nombre = teclado.next();
			elem.getChildNodes().item(0).getChildNodes().item(0).setTextContent(nombre);
		}else if(opcion == 2){
			System.out.println("Diga el primer apellido");
			String cognom1 = teclado.next();
			elem.getChildNodes().item(1).getChildNodes().item(0).setTextContent(cognom1);
		}else if(opcion == 3){
			System.out.println("Diga el segundo apellido");
			String cognom2 = teclado.next();
			elem.getChildNodes().item(2).getChildNodes().item(0).setTextContent(cognom2);
		}else{
			System.out.println("Diga la nota final");
			double notaFinal = teclado.nextDouble();
			elem.getChildNodes().item(3).getChildNodes().item(0).setTextContent(Double.toString(notaFinal));
		}
		guardarFichero(doc, teclado, file);
	}
	private static int mostararMenu(Scanner teclado) {
		int opcion;
		System.out.println();
		System.out.println("---MENU---");
		System.out.println("0: leer ficehro");
		System.out.println("1: añadir elemento");
		System.out.println("2: modificar elemento");
		System.out.println("3: eliminar elemento");
		System.out.println("4: Salir");
		opcion = teclado.nextInt();
		return opcion;
	}
	private static void eliminarNodo(Document doc, Scanner teclado,File file) throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Element elemento = buscarElementoId(teclado,doc);
		if(elemento != null){
			atriubutosNodo(elemento, "");
			elemento.getParentNode().removeChild(elemento);
			//guardarFichero(doc, teclado, file);
		}
		
	}
	private static Element buscarElementoId(Scanner teclado,Document doc){
		Element elem = null;
		System.out.println("diga la id del nodo a eliminar");
		int id = teclado.nextInt();
		// Get the main element by tag name
		Node alumnes = doc.getFirstChild();
		//get a NodeList
		NodeList list = alumnes.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
		    Node node = list.item(i);
		    System.out.println("\nCurrent Element :" + node.getNodeName());
		    if (node.getNodeType() == Node.ELEMENT_NODE) {
		        Element eElement = (Element) node;
		        if(eElement.getAttribute("id").equalsIgnoreCase(Integer.toString(id))){
		        	elem = eElement;
		        }
		    }
		}
		return elem;
	}
	private static void añadirNodo(Document doc,Scanner teclado,File file) throws TransformerException {
		System.out.println("diga el id del alumno");
		int id = teclado.nextInt();
		System.out.println("diga el nombre");
		String nombre = teclado.next();
		System.out.println("Diga el primer apellido");
		String cognom1 = teclado.next();
		System.out.println("Diga el segundo apellido");
		String cognom2 = teclado.next();
		System.out.println("Diga la nota final");
		double notaFinal = teclado.nextDouble();
		crearAlumno(doc, id, nombre, cognom1, cognom2, notaFinal);
		guardarFichero(doc, teclado, file);
	}
	private static void crearAlumno(Document doc, int id, String nombre,
			String cognom1, String cognom2, double notaFinal) {
		//nodo raiz
		Node alumnes = doc.getFirstChild();
		//elemento nuevo
		Element alumno = doc.createElement("alumne");
		alumno.setAttribute("id", Integer.toString(id));
		alumnes.appendChild(alumno);
		//nombre
		Element nom = doc.createElement("nom");
		alumno.appendChild(nom);
		nom.appendChild(doc.createTextNode(nombre));
		//apellido 1
		Element cognom = doc.createElement("cognom1");
		alumno.appendChild(cognom);
		cognom.appendChild(doc.createTextNode(cognom1));
		//apellido 2
		Element cognomdos = doc.createElement("cognom2");
		alumno.appendChild( cognomdos);
		cognomdos.appendChild(doc.createTextNode(cognom2));
		//notafinal
		Element nota = doc.createElement("notaFinal");
		alumno.appendChild(nota);
		nota.appendChild(doc.createTextNode(Double.toString(notaFinal)));
	}
	
	private static void guardarFichero(Document doc, Scanner teclado, File file)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		System.out.println("Desea guardar los cambios ??(si/no)");
		if(teclado.next().equals("si")){
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(doc);
			  StreamResult result = new StreamResult(file);
			  transformer.transform(source, result);
		}
	}
	
	public static void atriubutosNodo(Element e,String espacio){
		//se obtiene los nodos hijos
		NodeList nodeList = e.getChildNodes();
		//se recorre los nodos hijos
		for (int i = 0; i < nodeList.getLength(); i++) {
			//si es un elemento
			if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
				System.out.println();
				//muestra el elemento
				System.out.print(espacio + nodeList.item(i).getNodeName()+": ");
				//mira si tiene atributos
				if(nodeList.item(i).hasAttributes()){
					NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
					for (int j = 0; j < nodeMap.getLength(); j++) {
						//muestra los atriubutos
						System.out.print(nodeMap.item(j).getNodeName()+":"+nodeMap.item(j).getNodeValue());
						System.out.println();
					}
				}
				//vuelve a llamarse a si mismo para mostrar el contenido
				atriubutosNodo((Element)nodeList.item(i),espacio+"    ");
			}else{
				if(!(nodeList.item(i).getTextContent().equals("\n") ||
						nodeList.item(i).getTextContent().equals("\t") ||
						nodeList.item(i).getTextContent().equals(""))){
					//se muestra el valor
					System.out.println(nodeList.item(i).getTextContent());
				}
			}
		}
	}
}
