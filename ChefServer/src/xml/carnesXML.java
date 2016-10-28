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

public class carnesXML {
List<String> carnes = new List<String>();


	public void writeC(List<String> prodCarnes){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("carnes");
			file.appendChild(root);
				
			Node<String> temp;
			temp = prodCarnes.getHead();
			for(int cont = 0; cont < prodCarnes.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("carne");
				ingrediente.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(ingrediente);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("carnes.xml"));
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
		File xml = new File("carnes.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaCarnes = xmlP.getElementsByTagName("carne");
            carnes.setHead(null);
            
            
            for (int i = 0; i < listaCarnes.getLength(); i = i +1) {
            	Element element = (Element) listaCarnes.item(i);
                String carne = element.getFirstChild().getTextContent();
                carnes.insertTail(carne);
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void editC(List<String> prodCarnes){
		File xml = new File("carnes.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            //*************************************************//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builderOld = factory.newDocumentBuilder();
			Document file = builderOld.newDocument();
			Element root = file.createElement("carnes");
			file.appendChild(root);
            //*************************************************//
            
            NodeList listaCarnes = xmlP.getElementsByTagName("carne");
            List<String> listaTemp = new List<String>();
            
            for(int i = 0; i < listaCarnes.getLength(); i = i +1){
            	Element element = (Element) listaCarnes.item(i);
            	String carnes = element.getFirstChild().getTextContent();
            	listaTemp.insertTail(carnes);
            }
            
            
            Node<String> temp;
            temp = listaTemp.getHead();
            for (int cont = 0; cont < listaTemp.getLenght(); cont = cont +1){
            	Element carne = file.createElement("carne");
				carne.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(carne);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = prodCarnes.getHead();
			for(int cont = 0; cont < prodCarnes.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("carne");
				ingrediente.appendChild(file.createTextNode((String) temp2.getData()));
				root.appendChild(ingrediente);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("carnes.xml"));
			transformer.transform(source, result);
            
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	


	public void getCarnes() {
		carnes.print();;
	}

	public void setCarnes(List<String> carnes) {
		this.carnes = carnes;
	}

	public static void main(String[] args){
		List<String> listaCarnes = new List<String>();
		List<String> listaCarnes2 = new List<String>();
		carnesXML xmlC = new carnesXML();
		listaCarnes.insertTail("costilla de cerdo");
		listaCarnes.insertTail("lomo de res");
		listaCarnes.insertTail("pechuga de pollo");
		listaCarnes.insertTail("lomo de paleta");
		listaCarnes.insertTail("lomimto de res");
		listaCarnes.insertTail("rabo de vaca");
		
		listaCarnes2.insertTail("chuleta de cerdo");
		listaCarnes2.insertTail("chuleta de res");
		listaCarnes2.insertTail("atun");
		listaCarnes2.insertTail("aleta de tiburon");
		listaCarnes2.insertTail("pulpo");
		listaCarnes2.insertTail("curvina");
		
		//xmlC.writeC(listaCarnes);
		//xmlC.readFXml();
		//xmlC.getCarnes();
		//xmlC.editC(listaCarnes2);
	}
}
