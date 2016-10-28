package xml;

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
import java.io.*;
import linkedList.*;

public class recetasXML {
	
	@SuppressWarnings("rawtypes")
	List<List> recetas = new List<List>();
	
	public void write(String nombreReceta, List<String> nuIngrediente){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document file = builder.newDocument();
			Element root = file.createElement("recetas");
			file.appendChild(root);
			
			Element receta = file.createElement("receta");
			root.appendChild(receta);
			
			Element nombre = file.createElement("nombre");
			nombre.appendChild(file.createTextNode(nombreReceta));
			receta.appendChild(nombre);
			
			Node<String> temp;
			temp = nuIngrediente.getHead();
			for(int cont = 0; cont < nuIngrediente.getLenght(); cont = cont +1){
				Element ingrediente = file.createElement("ingrediente");
				ingrediente.appendChild(file.createTextNode((String) temp.getData()));
				receta.appendChild(ingrediente);
				temp = temp.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("recetas.xml"));
			transformer.transform(source, result);
			
		} 
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} 
		catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	
	public void read(){
		File xml = new File("recetas.xml");
		
		try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaRecetas = xmlP.getElementsByTagName("receta");
            
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
			e.printStackTrace();
		}
	}
	public void edit(String nombreRecet, List<String> nuIngrediente){
		File xml = new File("recetas.xml");
		String stringNombre;
		
		try{
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlP = builder.parse(xml);
            
            NodeList listaRecetas = xmlP.getElementsByTagName("receta");
            
            //********************************************//
            Document file = builder.newDocument();
        	Element root = file.createElement("recetas");
			file.appendChild(root);
			//********************************************//
            
            for (int i = 0; i < listaRecetas.getLength(); i++) {
            	List<String> datosRecetas = new List<String>();
            	Element element = (Element) listaRecetas.item(i);
            	
            	NodeList nombre = element.getElementsByTagName("nombre");
            	Element dataNombre = (Element) nombre.item(0);
            	stringNombre = dataNombre.getFirstChild().getTextContent();
            	//**************************************//
        		Element oldReceta = file.createElement("receta");
        		root.appendChild(oldReceta);
        			
        		Element oldNombre = file.createElement("nombre");
        		oldNombre.appendChild(file.createTextNode(stringNombre));
        		oldReceta.appendChild(oldNombre);
            	
            	//**************************************//

            	NodeList ingrediente = element.getElementsByTagName("ingrediente");
            	for (int cont = 0; cont < ingrediente.getLength(); cont++){
                	Element dataIngrediente = (Element) ingrediente.item(cont);
                	String stringIngrediente = dataIngrediente.getFirstChild().getTextContent();
                	datosRecetas.insertTail(stringIngrediente);
            	}
    			Node<String> temp;
    			temp = datosRecetas.getHead();
    			for(int cont = 0; cont < datosRecetas.getLenght(); cont = cont +1){
    				Element oldIngredients = file.createElement("ingrediente");
    				oldIngredients.appendChild(file.createTextNode((String) temp.getData()));
    				oldReceta.appendChild(oldIngredients);
    				temp = temp.getNextNode();
    			}
            	
            }
            Element receta = file.createElement("receta");
			root.appendChild(receta);
			
			Element newNombre = file.createElement("nombre");
			newNombre.appendChild(file.createTextNode(nombreRecet));
			receta.appendChild(newNombre);
			
			Node<String> temp2;
			temp2 = nuIngrediente.getHead();
			for(int cont = 0; cont < nuIngrediente.getLenght(); cont = cont +1){
				Element newIngrediente = file.createElement("ingrediente");
				newIngrediente.appendChild(file.createTextNode((String) temp2.getData()));
				receta.appendChild(newIngrediente);
				temp2 = temp2.getNextNode();
			}
			
			TransformerFactory transformerF = TransformerFactory.newInstance();
			Transformer transformer = transformerF.newTransformer();
			DOMSource source = new DOMSource(file);
			StreamResult result = new StreamResult(new File("recetas.xml"));
			transformer.transform(source, result);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getRecetas() {
		return recetas;
	}


	public void setRecetas(List<List> recetas) {
		this.recetas = recetas;
	}
	
	
	public static void main(String[] args){
		List<String> listaEmpanada = new List<String>();
		List<String> listaPinto = new List<String>();
		List<String> listaPollo = new List<String>();
		
		recetasXML xml = new recetasXML();
		listaEmpanada.insertTail("masa");
		listaEmpanada.insertTail("carne");
		listaEmpanada.insertTail("cebolla");
		listaEmpanada.insertTail("aceite");
		listaEmpanada.insertTail("sal");
		listaEmpanada.insertTail("chileDulce");
		
		listaPinto.insertTail("arroz");
		listaPinto.insertTail("frijoles");
		listaPinto.insertTail("Salsa Lisano");
		listaPinto.insertTail("cebolla");
		listaPinto.insertTail("aceite");
		listaPinto.insertTail("sal");
		
		listaPollo.insertTail("Aceite");
		listaPollo.insertTail("Cebolla");
		listaPollo.insertTail("Ajo");
		listaPollo.insertTail("Salsa Barbacoa");
		listaPollo.insertTail("sal");
		listaPollo.insertTail("Salsa Tomate");
		
		//xml.write("Gallo Pinto", listaPinto);
		//xml.edit("empanada", listaEmpanada);
		//xml.edit("Pollo", listaPollo);
		
		xml.read();
	}

}
