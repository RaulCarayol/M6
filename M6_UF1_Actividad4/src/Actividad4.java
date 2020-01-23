import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Actividad4 {
		public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
			// per a carregar en memòria un arxiu xml
			File file = new File("horari.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			System.out.println( doc.getDocumentElement().getNodeName());
			//se llama a atributosNodo el nodo raiz
			atriubutosNodo(doc.getDocumentElement()," ");

		}
		public static void atriubutosNodo(Element e,String espacio){
				//se obtiene los nodos hijos
				NodeList nodeList = e.getChildNodes();
				//se recorre los nodos hijos
				for (int i = 0; i < nodeList.getLength(); i++) {
					//si es un elemento
					if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
						System.out.println();
						//mira si tiene atributos
						if(nodeList.item(i).hasAttributes()){
							NamedNodeMap nodeMap = nodeList.item(i).getAttributes();
							for (int j = 0; j < nodeMap.getLength(); j++) {
								//muestra los atriubutos
								System.out.print(nodeMap.item(j).getNodeName()+":"+nodeMap.item(j).getNodeValue());
								System.out.println();
							}
					
						}
						//muestra el elemento
						System.out.print(espacio + nodeList.item(i).getNodeName()+": ");
						//vuelve a llamarse a si mismo para mostrar el contenido
						atriubutosNodo((Element)nodeList.item(i),espacio+"  ");
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
