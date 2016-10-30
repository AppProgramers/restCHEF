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

public class carnesXML {

	ParserId pars = new ParserId();

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
				int idString = pars.parseString(temp.getData());
				ingrediente.setAttribute("id", Integer.toString(idString));
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
            listwrapper.listaCarnes.setHead(null);
            System.out.println("moco");
            
            
            for (int i = 0; i < listaCarnes.getLength(); i = i +1) {
            	Element element = (Element) listaCarnes.item(i);
            	String att = element.getAttribute("id");
                String carne = element.getFirstChild().getTextContent();
                int conte = Integer.parseInt(att);
                listwrapper.listaCarnes.insertTailId(carne, conte);
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
            	int idString = pars.parseString(temp.getData());
				carne.setAttribute("id", Integer.toString(idString));
				carne.appendChild(file.createTextNode((String) temp.getData()));
				root.appendChild(carne);
				temp = temp.getNextNode();
            }
            
            Node<String> temp2;
			temp2 = prodCarnes.getHead();
			for(int cont = 0; cont < prodCarnes.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("carne");
				int idString = pars.parseString(temp2.getData());
				ingrediente.setAttribute("id", Integer.toString(idString));
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
	


	public void printCarnes() {
		listwrapper.listaCarnes.printWithId();
	}


	public static void main(String[] args){
		List<String> listaCarnes = new List<String>();
		List<String> listaCarnes2 = new List<String>();
		carnesXML xmlC = new carnesXML();
		listaCarnes.insertTail("costillaCerdo");
		listaCarnes.insertTail("lomoRes");
		listaCarnes.insertTail("pechugaPollo");
		listaCarnes.insertTail("lomoPaleta");
		listaCarnes.insertTail("lomitoRes");
		listaCarnes.insertTail("raboVaca");
		
		listaCarnes2.insertTail("chuletaCerdo");
		listaCarnes2.insertTail("chuletaRes");
		listaCarnes2.insertTail("atun");
		listaCarnes2.insertTail("aletaTiburon");
		listaCarnes2.insertTail("pulpo");
		listaCarnes2.insertTail("corvina");
		
		//xmlC.writeC(listaCarnes);
		//xmlC.readFXml();
		//xmlC.printCarnes();
		//xmlC.editC(listaCarnes2);
	}

}
