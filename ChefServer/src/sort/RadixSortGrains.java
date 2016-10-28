package sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSortGrains {
	
	
	int[] radixSort;
	
	public RadixSortGrains(int[] arra){
		radixSort = arra;
		radixsort(radixSort);
	}

	  public int[] getRadixSort() {
		return radixSort;
	}

	public void setRadixSort(int[] radixSort) {
		this.radixSort = radixSort;
	}

	/** Radix Sort function **/
	 public void radixsort(int[] input) {
		  final int RADIX = 10;
		  // declare and initialize bucket[]
		  List<Integer>[] bucket = new ArrayList[RADIX];
		  for (int i = 0; i < bucket.length; i++) {
		    bucket[i] = new ArrayList<Integer>();
		  }
		 
		  // sort
		  boolean maxLength = false;
		  int tmp = -1, placement = 1;
		  while (!maxLength) {
		    maxLength = true;
		    // split input between lists
		    for (Integer i : input) {
		      tmp = i / placement;
		      bucket[tmp % RADIX].add(i);
		      if (maxLength && tmp > 0) {
		        maxLength = false;
		      }
		    }
		    // empty lists into input array
		    int a = 0;
		    for (int b = 0; b < RADIX; b++) {
		      for (Integer i : bucket[b]) {
		        input[a++] = i;
		      }
		      bucket[b].clear();
		    }
		    // move to next digit
		    placement *= RADIX;
		  }
		} 
}
