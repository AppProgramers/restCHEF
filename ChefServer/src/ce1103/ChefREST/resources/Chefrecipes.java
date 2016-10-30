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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lib")
	public List<String> sendRecipes(){
		List<String> manu = new List<>();
		manu.insertTail("hey");
		manu.insertTail("it's me");
		manu.insertTail("mario");
		return manu;
		
	}
}
