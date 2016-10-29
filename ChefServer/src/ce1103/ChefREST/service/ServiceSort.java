package ce1103.ChefREST.service;

import com.sun.prism.impl.ps.CachingEllipseRep;

import ce1103.ChefREST.data.listwrapper;
import ce1103.ChefREST.sort.BubbleSortDairy;
import ce1103.ChefREST.sort.InsertionSortMeat;
import ce1103.ChefREST.sort.QuickSortFruits;
import ce1103.ChefREST.sort.RadixSortGrains;
import ce1103.ChefREST.sort.ShellSortVegetables;
import ce1103.ChefREST.utility.*;

public class ServiceSort {
	
	ListTransformer changeorder = new ListTransformer();
	
	public void doBubble(){
		int[] arrUnsort = changeorder.listTOArray(listwrapper.listaLacteos);
		BubbleSortDairy bubble = new BubbleSortDairy(arrUnsort);
		arrUnsort = bubble.getSortArray();
		listwrapper.listaLacteos = changeorder.arrayTOList(listwrapper.listaLacteos, arrUnsort);
		
	}
	public void doInsertion(){
		int[] arrUnsort = changeorder.listTOArray(listwrapper.listaCarnes);
		InsertionSortMeat insertion = new InsertionSortMeat(arrUnsort);
		arrUnsort = insertion.getInsertionArray();
		listwrapper.listaCarnes = changeorder.arrayTOList(listwrapper.listaCarnes, arrUnsort);
		
	}
	public void doQuick(){
		int[] arrUnsort = changeorder.listTOArray(listwrapper.listaFruits);
		QuickSortFruits Fruits = new QuickSortFruits(arrUnsort);
		arrUnsort = Fruits.getArray();
		listwrapper.listaFruits = changeorder.arrayTOList(listwrapper.listaFruits, arrUnsort);
	
	}
	public void doRadix(){
		int[] arrUnsort = changeorder.listTOArray(listwrapper.listaGranos);
		RadixSortGrains Fruits = new RadixSortGrains(arrUnsort);
		arrUnsort = Fruits.getRadixSort();
		listwrapper.listaGranos = changeorder.arrayTOList(listwrapper.listaGranos, arrUnsort);
	
	}
	public void doShell(){
		int[] arrUnsort = changeorder.listTOArray(listwrapper.listaVerduras);
		ShellSortVegetables verduras = new ShellSortVegetables(arrUnsort);
		arrUnsort = verduras.getShellSort() ;
		listwrapper.listaVerduras = changeorder.arrayTOList(listwrapper.listaVerduras, arrUnsort);
	}
	
}
