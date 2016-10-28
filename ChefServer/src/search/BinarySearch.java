package search;

public class BinarySearch {
	int[] arrayData;
	int size;

	public boolean binarySearch(int key, int[] arraydata) {
		this.arrayData = arraydata;
		this.size = arrayData.length;
		int low = 0;
		int high = size - 1;
		

		while (high >= low) {
			int middle = (low + high) / 2;
			if (arrayData[middle] == key) {
				return true;
			}
			if (arrayData[middle] < key) {
				low = middle + 1;
			}
			if (arrayData[middle] > key) {
				high = middle - 1;
			}
		}
		return false;
	}
}
