package xml;

import java.io.File;

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
import org.w3c.dom.NodeList;

import linkedList.List;
import linkedList.Node;

public class fruitsXML {
	@SuppressWarnings("rawtypes")
	List<List> recetas = new List<List>();
	
	public void writeF(List<String> nuFruits){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("frutas");
			file.appendChild(root);
				
			Node<String> temp;
			temp = nuFruits.getHead();
			for(int cont = 0; cont < nuFruits.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("fruta");
				ingrediente.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(ingrediente);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("frutas.xml"));
			transformer.transform(source, result);
			
		} 
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} 
		catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	public void readFXml(){
		File xml = new File("frutas");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaRecetas = xmlP.getElementsByTagName("frutas");
            
            for (int i = 0; i < listaRecetas.getLength(); i++) {
            	List<String> datosRecetas = new List<String>();
            	Element element = (Element) listaRecetas.item(i);
            	
            	NodeList nombre = element.getElementsByTagName("nombre");
            	Element dataNombre = (Element) nombre.item(0);
            	String stringNombre = dataNombre.getFirstChild().getTextContent();
            	datosRecetas.insertTail(stringNombre);
            	
            	//----------------------------------------------//
            	datosRecetas.insertTail("ingredientes");
            	//----------------------------------------------//

            	NodeList ingrediente = element.getElementsByTagName("ingrediente");
            	for (int cont = 0; cont < ingrediente.getLength(); cont++){
                	Element dataIngrediente = (Element) ingrediente.item(cont);
                	String stringIngrediente = dataIngrediente.getFirstChild().getTextContent();
                	datosRecetas.insertTail(stringIngrediente);
            	}
            	recetas.insertTail(datosRecetas);

            }
		}
		catch(Exception e){
			
		}
	}
	
	public static void main(String[] args){
		List<String> listaFruits = new List<String>();
		fruitsXML xmlF = new fruitsXML();
		listaFruits.insertTail("Banano");
		listaFruits.insertTail("Naranja");
		listaFruits.insertTail("Manzana");
		listaFruits.insertTail("Pera");
		listaFruits.insertTail("Uvas");
		
		xmlF.writeF(listaFruits);
	}

}
