package ce1103.ChefREST.utility;

import ce1103.ChefREST.dataStructure.List;
import ce1103.ChefREST.dataStructure.Node;

public class ListTransformer {
	
	public List<String> arrayTOList(List<String> lUnsort, int[] sort){
		List<String> LSort = new List<String>();
		for(int i = 0; i< lUnsort.getLenght();i++){
			LSort.insertTail(lUnsort.search(sort[i]).getData());
		}
		return LSort;
	}
	public int[] listTOArray(List<String> lUnsort){
		int[] arrID = new int[lUnsort.getLenght()];
		Node<String> temp = lUnsort.getHead();
		for(int i = 0; i<lUnsort.getLenght(); i++){
			arrID[i] = temp.getId();
			temp= temp.getNextNode();
		}
		return arrID;
	}

}
