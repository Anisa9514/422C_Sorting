// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Angelique Bautista
 * ab54429
 * 15465
 * Spring 2018
 * Slip days used: 
 */

package assignment1;
import java.util.Arrays;


public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param nums is the array
	  * @param n is the size of the input to be checked
	  * @return true if array is sorted
	  */
	public static boolean isSorted(int[] nums, int n) {
		if(n == 0) {return false;}
		if(n == 1) {return true;}
		
		int previous, current;
		for(int i = 1; i < n; i++) {
			previous = nums[i-1];
			current = nums[i];	
			if(previous > current) {return false;}
		}
		return true;
	}
	
	/**
	 * This method finds the index of an element given a sorted array
	 * @param nums is the array
	 * @param n is the number of elements to be checked within the array
	 * @param v is the element to be found
	 * @return index of v; -1 if v is not within the first n elements of nums 
	 */
	public static int find(int[] nums, int n, int v) {
		int upperBound = n - 1;
		int lowerBound = 0;
		int ArrSize = n;
		int pivotIndex = lowerBound + (upperBound - lowerBound)/2;
		int pivotVal;
		
		while(ArrSize > 1) {
			pivotVal = nums[pivotIndex];
			
			if(pivotVal == v) {return pivotIndex;}
			else if(pivotVal < v) {lowerBound = pivotIndex + 1;}
			else {upperBound = pivotIndex - 1;}
			
			pivotIndex = lowerBound + (upperBound - lowerBound)/2;
			ArrSize = upperBound - lowerBound + 1;
		}
		
		pivotVal = nums[pivotIndex];
		return (pivotVal == v) ? pivotIndex : -1;  
	}

	/**
	 * This method inserts a new element into a sorted array and returns a new array
	 * @param nums is the array
	 * @param n is the number of elements to be checked 
	 * @param v is the element to be inserted
	 * @return a new array with v inserted. If v was already present in the array, v is not inserted 
	 */
	public static int[] insertGeneral(int[] nums, int n, int v) {
		if(find(nums, n, v) != -1) {return Arrays.copyOfRange(nums, 0, n);}
		int[] arrCopy = Arrays.copyOfRange(nums, 0, n+1);
		
		boolean valInserted = false;
		int prevVal = 0, temp = 0;
		
		for(int i = 0; i < arrCopy.length; i++) {
			if(!valInserted) {
				// Find where to insert element
				if(v < arrCopy[i]) {
					prevVal = arrCopy[i];
					arrCopy[i] = v;
					valInserted = true;
				} 
				// In case element needs to be inserted at end
				// arrCopy[n+1] may not be > arrCopy[n] since it's not part of nums[0-n] 
				else if (i == arrCopy.length - 1) {
					arrCopy[i] = v;
				}
			} else {
				temp = arrCopy[i];
				arrCopy[i] = prevVal;
				prevVal = temp;
			}
		}
		
		return arrCopy;
	}
	
	/**
	 * This method inserts a new element into a sorted array and modifies the given array
	 * @param nums is the array
	 * @param n is the number of elements to be checked within the array
	 * @param v is the element to be inserted
	 * @return n if nums contained at least one v; n+1 if array is modified
	 */
	public static int insertInPlace(int[] nums, int n, int v) {
		if(find(nums, n, v) != -1) {return n;}

		boolean valInserted = false;
		int prevVal = 0, temp = 0;
		
		for(int i = 0; i < n + 1; i++) {
			if(!valInserted) {
				// Find where to insert element
				if(v < nums[i]) {
					prevVal = nums[i];
					nums[i] = v;
					valInserted = true;
				} 
				// In case element needs to be inserted at end
				// arrCopy[n+1] may not be > arrCopy[n] since it's not part of nums[0-n] 
				else if (i == n) {
					nums[i] = v;
				}
			} else {
				temp = nums[i];
				nums[i] = prevVal;
				prevVal = temp;
			}
		}
		
		return n + 1;
	}
	
	/**
	 * This method sorts the first n elements of nums in increasing order
	 * @param nums is the array
	 * @param n is the number of elements to be sorted within the array
	 */
	
	public static void insertSort(int[] nums, int n) { // must be able to handle repeats (not handled by insertInPlace)
		if(n == 1) {return;}		
		// Insertion Sort
		for(int subArrSize = 1; subArrSize < n; subArrSize++) { // number of elements in subarray
			int curElemIndex, temp;	// sort first elem outside subArr 
			
			for(int k = subArrSize - 1; k >= 0; k--) { // iterate through and sort subArr
				curElemIndex = k + 1;
				if(nums[curElemIndex] < nums[k]) {
					temp = nums[curElemIndex];
					nums[curElemIndex] = nums[k];
					nums[k] = temp;
				}
				else { break; }
			}
			
			if(isSorted(nums, n)) {return;}
			
		}
	}
}
