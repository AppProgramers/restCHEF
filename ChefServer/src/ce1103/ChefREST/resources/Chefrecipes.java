package ce1103.ChefREST.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ce1103.ChefREST.data.listwrapper;
import ce1103.ChefREST.dataStructure.List;

@Path("/chef")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Chefrecipes {
	
	@GET
	@Path("/lista")
	public List<String> sendRecipes(){
		listwrapper.listaCarnes.insertHead("Manuel");
		listwrapper.listaCarnes.insertHead("Alfonso");
		listwrapper.listaCarnes.insertHead("Manuel");
		return listwrapper.listaCarnes;
	}
}
