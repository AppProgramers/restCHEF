package ce1103.ChefREST.service;

import ce1103.ChefREST.data.listwrapper;
import ce1103.ChefREST.search.*;
import ce1103.ChefREST.utility.*;

public class ServiceSearch {
	
	ListTransformer changeOrder = new ListTransformer();
	BinarySearch search = new BinarySearch();
	
	public boolean searchBubble(int id){
		int[] arrsearch = changeOrder.listTOArray(listwrapper.listaLacteos);
		boolean exist = search.binarySearch(id, arrsearch);
		return exist;
	}
	public boolean searchInsertion(int id){
		int[] arrsearch = changeOrder.listTOArray(listwrapper.listaCarnes);
		boolean exist = search.binarySearch(id, arrsearch);
		return exist;
	}
	public boolean searchQuick(int id){
		int[] arrsearch = changeOrder.listTOArray(listwrapper.listaFruits);
		boolean exist = search.binarySearch(id, arrsearch);
		return exist;
	}
	public boolean searchRadix(int id){
		int[] arrsearch = changeOrder.listTOArray(listwrapper.listaGranos);
		boolean exist = search.binarySearch(id, arrsearch);
		return exist;
	}
	public boolean searchShell(int id){
		int[] arrsearch = changeOrder.listTOArray(listwrapper.listaVerduras);
		boolean exist = search.binarySearch(id, arrsearch);
		return exist;
	}
}
