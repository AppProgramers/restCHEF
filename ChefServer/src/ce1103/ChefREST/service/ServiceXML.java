package ce1103.ChefREST.service;

import ce1103.ChefREST.xml.*;

public class ServiceXML {
	
	public void readAll(){
		readCarnes();
		readFrutas();
		readGranos();
		readLacteos();
		readRecipes();
		readVerduras();
	}	
	public void readCarnes(){
		carnesXML carne = new carnesXML();
		carne.readFXml();
	}
	public void readFrutas(){
		fruitsXML fruta = new fruitsXML();
		fruta.readFXml();
	}
	public void readGranos(){
		granosXML grano = new granosXML();
		grano.readFXml();
	}
	public void readLacteos(){
		lacteosXML lacteo = new lacteosXML();
		lacteo.readFXml();
	}
	public void readRecipes(){
		recetasXML receta = new recetasXML();
		receta.read();
	}
	public void readVerduras(){
		verdurasXML verdura = new verdurasXML();
		verdura.readFXml();
	}
}
