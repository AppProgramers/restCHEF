package ce1103.ChefREST.xml;

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

import ce1103.ChefREST.dataStructure.List;
import ce1103.ChefREST.dataStructure.Node;
import ce1103.ChefREST.utility.ParserId;
import ce1103.ChefREST.data.listwrapper;

public class lacteosXML {
	
	ParserId pars = new ParserId();
	
	public void writeL(List<String> prodLacteos){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("lacteos");
			file.appendChild(root);
				
			Node<String> temp;
			temp = prodLacteos.getHead();
			for(int cont = 0; cont < prodLacteos.getLenght(); cont = cont +1){
				Element lacteo = file.createElement("lacteo");
				int idString = pars.parseString(temp.getData());
				lacteo.setAttribute("id", Integer.toString(idString));
				lacteo.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(lacteo);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("lacteos.xml"));
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
		File xml = new File("lacteos.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaLacteos = xmlP.getElementsByTagName("lacteo");
            
            
            for (int i = 0; i < listaLacteos.getLength(); i = i +1) {
            	Element eleLact = (Element) listaLacteos.item(i);
            	String att = eleLact.getAttribute("id");
                String lacteo = eleLact.getFirstChild().getTextContent();
                int conte = Integer.parseInt(att);
                listwrapper.listaLacteos.insertTailId(lacteo, conte);
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void editL(List<String> prodLacteos){
		File xml = new File("lacteos.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            //*************************************************//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builderOld = factory.newDocumentBuilder();
			Document file = builderOld.newDocument();
			Element root = file.createElement("lacteos");
			file.appendChild(root);
            //*************************************************//
            
            NodeList listaLacteos = xmlP.getElementsByTagName("lacteo");
            List<String> listaTemp = new List<String>();
            
            for(int i = 0; i < listaLacteos.getLength(); i = i +1){
            	Element element = (Element) listaLacteos.item(i);
            	String lacteo = element.getFirstChild().getTextContent();
            	listaTemp.insertTail(lacteo);
            }
            
            
            Node<String> temp;
            temp = listaTemp.getHead();
            for (int cont = 0; cont < listaTemp.getLenght(); cont = cont +1){
            	Element eleLact = file.createElement("lacteo");
            	int idString = pars.parseString(temp.getData());
            	eleLact.setAttribute("id", Integer.toString(idString));
				eleLact.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(eleLact);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = prodLacteos.getHead();
			for(int cont = 0; cont < prodLacteos.getLenght(); cont = cont +1){
				Element elemL = file.createElement("lacteo");
				int idString = pars.parseString(temp2.getData());
				elemL.setAttribute("id", Integer.toString(idString));
				elemL.appendChild(file.createTextNode((String) temp2.getData()));
				root.appendChild(elemL);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("lacteos.xml"));
			transformer.transform(source, result);
            
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void printLacteos() {
		 listwrapper.listaLacteos.printWithId();
	}


	public static void main(String[] args){
		List<String> listaLacteos = new List<String>();
		List<String> listaLacteos2 = new List<String>();
		lacteosXML xmlL = new lacteosXML();
		listaLacteos.insertTail("queso");
		listaLacteos.insertTail("lecheVaca");
		listaLacteos.insertTail("natilla");
		listaLacteos.insertTail("quesoAmarillo");
		listaLacteos.insertTail("lecheCondensada");
		listaLacteos.insertTail("yogurt");
		
		listaLacteos2.insertTail("mantequilla");
		listaLacteos2.insertTail("quesoCrema");
		listaLacteos2.insertTail("helasdos");
		listaLacteos2.insertTail("cuajada");
		listaLacteos2.insertTail("lechePolvo");
		listaLacteos2.insertTail("requeson");
		
		//xmlL.writeL(listaLacteos);
		//xmlL.editL(listaLacteos2);
		xmlL.readFXml();
		//xmlL.printLacteos();
	}

}
