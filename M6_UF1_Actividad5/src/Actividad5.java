import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
		// per a carregar en mem�ria un arxiu xml
		File file = new File("alumni.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		do {
			System.out.println("---MENU---");
			System.out.println("0: leer ficehro");
			System.out.println("1: a�adir elemento");
			System.out.println("2: modificar elemento");
			System.out.println("3: eliminar elemento");
			System.out.println("4: Salir");
			opcion = teclado.nextInt();
			if(opcion != 4){
				if(opcion == 0){
					System.out.println( doc.getDocumentElement().getNodeName());
					//se llama a atributosNodo el nodo raiz
					atriubutosNodo(doc.getDocumentElement()," ");
				}else if(opcion == 1){
					a�adirNodo(doc,teclado,file);
				}else if(opcion == 2){
					
				}else{
					eliminarNodo(doc,teclado);
				}
			}
		} while (opcion != 4);
	}
	private static void eliminarNodo(Document doc, Scanner teclado) {
		System.out.println("diga la id del nodo a eliminar");
		int id = teclado.nextInt();
		Element elemento = doc.getElementById(Integer.toString(id));
		if(elemento != null){		
			System.out.println(elemento.getNodeName());
		}
		//doc.removeChild(elemento);
	}
	private static void a�adirNodo(Document doc,Scanner teclado,File file) throws TransformerException {
		System.out.println("diga el id del alumno");
		int id = teclado.nextInt();
		System.out.println("diga el nombre");
		String nombre = teclado.next();
		System.out.println("Diga el primer apellido");
		String cognom1 = teclado.next();
		System.out.println("Diga el segundo apellido");
		String cognom2 = teclado.next();
		System.out.println("Diga la nota final");
		int notaFinal = teclado.nextInt();
		System.out.println("Desea guardar los cambios ??(si/no)");
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
		nota.appendChild(doc.createTextNode(Integer.toString(notaFinal)));
		
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
