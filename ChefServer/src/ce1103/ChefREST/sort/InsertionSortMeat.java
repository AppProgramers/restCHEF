package ce1103.ChefREST.sort;

public class InsertionSortMeat {
	
	int[] InsertionArray;
	
	public InsertionSortMeat(int[] Arra){
		InsertionArray = Arra;
		InsertionArray = doInsertionSort(InsertionArray);
	}
	
	public int[] getInsertionArray() {
		return InsertionArray;
	}

	public void setInsertionArray(int[] insertionArray) {
		InsertionArray = insertionArray;
	}

	public int[] doInsertionSort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}
