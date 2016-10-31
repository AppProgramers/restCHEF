package ce1103.ChefREST.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ce1103.ChefREST.data.listwrapper;
import ce1103.ChefREST.dataStructure.List;

@Path("/chef")
public class Chefrecipes {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sendRecipes(){
		String manu = "Manuel";
		//List<String> manu = new List<String>();
		//manu.insertHead("Manu");
		return manu;
		
	}
}