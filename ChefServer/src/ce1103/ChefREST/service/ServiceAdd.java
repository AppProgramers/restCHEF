package ce1103.ChefREST.service;

import ce1103.ChefREST.data.listwrapper;
import ce1103.ChefREST.dataStructure.List;
import ce1103.ChefREST.xml.*;

public class ServiceAdd {
	
	public void addRecipe(String nombre, List<String> ingredientes){
		recetasXML recetas = new recetasXML();
		recetas.edit(nombre, ingredientes);
	}
	public void addCarne(List<String> nombre){
		carnesXML carne = new carnesXML();
		carne.editC(nombre);
	}
	public void addFrutas(List<String> nombre){
		fruitsXML frutas = new fruitsXML();
		frutas.editF(nombre);
	}
	public void addGranos(List<String> nombre){
		granosXML grano = new granosXML();
		grano.editG(nombre);
	}
	public void addLacteos(List<String> nombre){
		lacteosXML lacteos = new lacteosXML();
		lacteos.editL(nombre);
	}
	public void addVerduras(List<String> nombre){
		verdurasXML verduras = new verdurasXML();
		verduras.editV(nombre);
	}
	public void addOrden(String nombre){
		 listwrapper.listordenes.enqueue(nombre);
	}
}
