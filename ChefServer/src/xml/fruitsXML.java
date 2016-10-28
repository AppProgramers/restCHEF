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
	List<String> frutas = new List<String>();
	
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
		File xml = new File("frutas.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaRecetas = xmlP.getElementsByTagName("fruta");
            
            
            for (int i = 0; i < listaRecetas.getLength(); i = i +1) {
            	Element element = (Element) listaRecetas.item(i);
                String fruta = element.getFirstChild().getTextContent();
                frutas.insertTail(fruta);
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void editF(List<String> nuFruits){
		File xml = new File("frutas.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            //*************************************************//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builderOld = factory.newDocumentBuilder();
			Document file = builderOld.newDocument();
			Element root = file.createElement("frutas");
			file.appendChild(root);
            //*************************************************//
            
            NodeList listaRecetas = xmlP.getElementsByTagName("fruta");
            List<String> listaTemp = new List<String>();
            
            for(int i = 0; i < listaRecetas.getLength(); i = i +1){
            	Element element = (Element) listaRecetas.item(i);
            	String fruta = element.getFirstChild().getTextContent();
            	listaTemp.insertTail(fruta);
            }
            
            
            Node<String> temp;
            temp = listaTemp.getHead();
            for (int cont = 0; cont < listaTemp.getLenght(); cont = cont +1){
            	Element fruta = file.createElement("fruta");
				fruta.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(fruta);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = nuFruits.getHead();
			for(int cont = 0; cont < nuFruits.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("fruta");
				ingrediente.appendChild(file.createTextNode((String) temp2.getData()));
				root.appendChild(ingrediente);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("frutas.xml"));
			transformer.transform(source, result);
            
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getFrutas() {
		frutas.print();
	}

	public void setFrutas(List<String> frutas) {
		this.frutas = frutas;
	}

	public static void main(String[] args){
		List<String> listaFruits = new List<String>();
		List<String> listaFruits2 = new List<String>();
		fruitsXML xmlF = new fruitsXML();
		listaFruits.insertTail("pene");
		listaFruits.insertTail("Banano");
		listaFruits.insertTail("Naranja");
		listaFruits.insertTail("Manzana");
		listaFruits.insertTail("Pera");
		listaFruits.insertTail("Uvas");
		
		listaFruits2.insertTail("vagina");
		listaFruits2.insertTail("culo");
		listaFruits2.insertTail("pedo");
		listaFruits2.insertTail("caca");
		listaFruits2.insertTail("pezon");
		listaFruits2.insertTail("sffe");
		
		//xmlF.writeF(listaFruits);
		//xmlF.readFXml();
		//xmlF.getFrutas();
		//xmlF.editF(listaFruits2);
	}

}
