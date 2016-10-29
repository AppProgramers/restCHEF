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

public class verdurasXML {
List<String> verduras = new List<String>();


	public void writeV(List<String> prodVerduras){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("verduras");
			file.appendChild(root);
				
			Node<String> temp;
			temp = prodVerduras.getHead();
			for(int cont = 0; cont < prodVerduras.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("verdura");
				ingrediente.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(ingrediente);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("verduras.xml"));
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
		File xml = new File("verduras.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaVerdura = xmlP.getElementsByTagName("verdura");
            verduras.setHead(null);
            
            
            
            for (int i = 0; i < listaVerdura.getLength(); i = i +1) {
            	Element element = (Element) listaVerdura.item(i);
                String verdura = element.getFirstChild().getTextContent();
                verduras.insertTail(verdura);
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void editV(List<String> prodVreduras){
		File xml = new File("verduras.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            //*************************************************//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builderOld = factory.newDocumentBuilder();
			Document file = builderOld.newDocument();
			Element root = file.createElement("verduras");
			file.appendChild(root);
            //*************************************************//
            
            NodeList listaVerdura = xmlP.getElementsByTagName("verdura");
            List<String> listaTemp = new List<String>();
            
            for(int i = 0; i < listaVerdura.getLength(); i = i +1){
            	Element element = (Element) listaVerdura.item(i);
            	String verduras = element.getFirstChild().getTextContent();
            	listaTemp.insertTail(verduras);
            }
            
            
            Node<String> temp;
            temp = listaTemp.getHead();
            for (int cont = 0; cont < listaTemp.getLenght(); cont = cont +1){
            	Element vedura = file.createElement("verdura");
				vedura.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(vedura);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = prodVreduras.getHead();
			for(int cont = 0; cont < prodVreduras.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("verdura");
				ingrediente.appendChild(file.createTextNode((String) temp2.getData()));
				root.appendChild(ingrediente);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("verduras.xml"));
			transformer.transform(source, result);
            
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void getVerduras() {
		verduras.print();
	}

	public void setVerduras(List<String> verduras) {
		this.verduras = verduras;
	}

	public static void main(String[] args){
		List<String> listaVerduras = new List<String>();
		List<String> listaVerduras2 = new List<String>();
		verdurasXML xmlV = new verdurasXML();
		listaVerduras.insertTail("ayote");
		listaVerduras.insertTail("papa");
		listaVerduras.insertTail("zanahoria");
		listaVerduras.insertTail("tiquisque");
		listaVerduras.insertTail("chayote");
		listaVerduras.insertTail("pipian");
		
		listaVerduras2.insertTail("camote");
		listaVerduras2.insertTail("elote");
		listaVerduras2.insertTail("vanicas");
		listaVerduras2.insertTail("lechuga");
		listaVerduras2.insertTail("reopllo");
		listaVerduras2.insertTail("papinos");
		
		//xmlV.writeV(listaVerduras);
		//xmlV.readFXml();
		//xmlV.getVerduras();
		//xmlV.editV(listaVerduras2);
	}
	
}
