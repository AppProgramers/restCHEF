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

public class granosXML {
	
	ParserId pars = new ParserId();

	public void writeG(List<String> prodGranos){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("granos");
			file.appendChild(root);
				
			Node<String> temp;
			temp = prodGranos.getHead();
			for(int cont = 0; cont < prodGranos.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("grano");
				int idString = pars.parseString(temp.getData());
				ingrediente.setAttribute("id", Integer.toString(idString));
				ingrediente.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(ingrediente);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("granos.xml"));
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
		File xml = new File("granos.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaGrano = xmlP.getElementsByTagName("grano");
            listwrapper.listaGranos.setHead(null);
            
            
            for (int i = 0; i < listaGrano.getLength(); i = i +1) {
            	Element element = (Element) listaGrano.item(i);
            	String att = element.getAttribute("id");
                String grano = element.getFirstChild().getTextContent();
                int conte = Integer.parseInt(att);
                listwrapper.listaGranos.insertTailId(grano, conte);
            }
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void editG(List<String> prodGrano){
		File xml = new File("granos.xml");
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            //*************************************************//
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builderOld = factory.newDocumentBuilder();
			Document file = builderOld.newDocument();
			Element root = file.createElement("granos");
			file.appendChild(root);
            //*************************************************//
            
            NodeList listaGrano = xmlP.getElementsByTagName("grano");
            List<String> listaTemp = new List<String>();
            
            for(int i = 0; i < listaGrano.getLength(); i = i +1){
            	Element element = (Element) listaGrano.item(i);
            	String granos = element.getFirstChild().getTextContent();
            	listaTemp.insertTail(granos);
            }
            
            
            Node<String> temp;
            temp = listaTemp.getHead();
            for (int cont = 0; cont < listaTemp.getLenght(); cont = cont +1){
            	Element grano = file.createElement("grano");
            	int idString = pars.parseString(temp.getData());
            	grano.setAttribute("id", Integer.toString(idString));
				grano.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(grano);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = prodGrano.getHead();
			for(int cont = 0; cont < prodGrano.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("grano");
				int idString = pars.parseString(temp2.getData());
				ingrediente.setAttribute("id", Integer.toString(idString));
				ingrediente.appendChild(file.createTextNode((String) temp2.getData()));
				root.appendChild(ingrediente);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("granos.xml"));
			transformer.transform(source, result);
            
            
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	public void printGranos() {
		listwrapper.listaGranos.printWithId();
	}


	public static void main(String[] args){
		List<String> listaGranos = new List<String>();
		List<String> listaGranos2 = new List<String>();
		granosXML xmlG = new granosXML();
		listaGranos.insertTail("arroz");
		listaGranos.insertTail("frijoles");
		listaGranos.insertTail("lentejas");
		listaGranos.insertTail("frijoles blancos");
		listaGranos.insertTail("avena");
		listaGranos.insertTail("trigo");
		
		listaGranos2.insertTail("arroz integral");
		listaGranos2.insertTail("mijo");
		listaGranos2.insertTail("sorgo");
		listaGranos2.insertTail("quinua");
		listaGranos2.insertTail("centeno integral");
		listaGranos2.insertTail("triticale");
		
		//xmlG.writeG(listaGranos);
		xmlG.readFXml();
		xmlG.printGranos();
		//xmlG.editG(listaGranos2);
	}

}
