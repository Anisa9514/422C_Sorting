package assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SortToolsTest {
	
	/////////////////////////////////////////////////////////
	// Test SortTools.isSorted()
	/////////////////////////////////////////////////////////
	@Test(timeout = 2000)
	public void testIsSortedNoElem() {
		int[] nums = new int[] {};
		assertEquals(false, SortTools.isSorted(nums, 0));
	}
	
	@Test(timeout = 2000)
	public void testIsSortedOneElem() {
		int[] nums = new int[] {-2, 0, 1, 2};
		assertEquals(true, SortTools.isSorted(nums, 1));
	}
	
	@Test(timeout = 2000)
	public void testIsSortedFullTrue() {
		int[] nums = new int[] {-2, 0, 1, 2};
		assertEquals(true, SortTools.isSorted(nums, 4));
	}
	
	@Test(timeout = 2000)
	public void testIsSortedFullFalse() {
		int[] nums = new int[] {-2, -1, 0, 1, 0};
		assertEquals(false, SortTools.isSorted(nums, 5));
	}
	
	@Test(timeout = 2000)
	public void testIsSortedPartialTrue() {
		int[] nums = new int[] {-2, 0, 1, -1};
		assertEquals(true, SortTools.isSorted(nums, 3));
	}
	
	@Test(timeout = 2000)
	public void testIsSortedPartialFalse() {
		int[] nums = new int[] {-2, 0, -1, 1};
		assertEquals(false, SortTools.isSorted(nums, 3));
	}
	
	/////////////////////////////////////////////////////////
	// Test SortTools.find()
	/////////////////////////////////////////////////////////
	@Test(timeout = 2000)
	public void testFindMissingOneElem() {
		int[] x = new int[] {3, 4};
		assertEquals(-1, SortTools.find(x, 1, 4));
	}
	
	@Test(timeout = 2000)
	public void testFindFoundOneElem() {
		int[] x = new int[] {3};
		assertEquals(0, SortTools.find(x, 1, 3));		
	}
	
	@Test(timeout = 2000)
	public void testFindFoundFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(3, SortTools.find(x, 6, 1));
	}

	@Test(timeout = 2000)
	public void testFindFoundPartial(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(2, SortTools.find(x, 3, 0));
	}
	
	@Test(timeout = 2000)
	public void testFindMissingFull(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 6, 4));
	}

	@Test(timeout = 2000)
	public void testFindMissingPartial(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(-1, SortTools.find(x, 3, 1));
	}
	
	@Test(timeout = 2000)
	public void testFindFoundUpperHalf(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(4, SortTools.find(x, 6, 2));
	}

	@Test(timeout = 2000)
	public void testFindFoundLowerHalf(){
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(0, SortTools.find(x, 3, -2));
	}
	
	/////////////////////////////////////////////////////////
	// Test SortTools.InsertGeneral()
	/////////////////////////////////////////////////////////
	@Test
	public void testInsertGeneralPartialAlreadyPresent(){
		int[] x = new int[] {10, 20, 30, 40, 50, 60, 70};
		int[] expected = new int[]{10, 20, 30, 40};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 4, 20));
		
	}
	
	@Test
	public void testInsertGeneralFullAlreadyPresent() {
		int[] x = new int[] {10, 20, 30, 40, 50, 60, 70};
		int[] expected = new int[]{10, 20, 30, 40, 50, 60, 70};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 7, 20));		
	}
	@Test
	public void testInsertGeneralPartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 35));
	}
	
	@Test
	public void testInsertGeneralFullEnd() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 40, 50, 60};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 60));
	}

	@Test
	public void testInsertGeneralPartialBeginning() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{4, 10, 20, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 4));
	}
	
	@Test
	public void testInsertGeneralFullBeginning() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{-5, 10, 20, 30, 40, 50};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, -5));
	}

	@Test
	public void testInsertGeneralPartialMiddle() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 25, 30};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 3, 25));
	}
	
	@Test
	public void testInsertGeneralFullMiddle() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35, 40, 50};
		assertArrayEquals(expected, SortTools.insertGeneral(x, 5, 35));
	}
	
	/////////////////////////////////////////////////////////
	// Test SortTools.InsertInPlace()
	/////////////////////////////////////////////////////////
	@Test
	public void testInsertInPlacePartialAlreadyPresent(){
		int[] x = new int[] {10, 20, 30, 40, 50, 60, 70};
		int[] expected = new int[]{10, 20, 30, 40, 50, 60, 70};
		assertEquals(4, SortTools.insertInPlace(x, 4, 20));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testInsertInPlaceFullAlreadyPresent() {
		int[] x = new int[] {10, 20, 30, 40, 50, 60, 70};
		int[] expected = new int[]{10, 20, 30, 40, 50, 60, 70};
		assertEquals(7, SortTools.insertInPlace(x, 7, 20));
		assertArrayEquals(expected, x);	
	}
	@Test
	public void testInsertInPlacePartialEnd(){
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 30, 35, 50};
		assertEquals(4, SortTools.insertInPlace(x, 3, 35));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testInsertInPlaceFullEnd() {
		int[] x = new int[]{10, 20, 30, 40, 50, 0};
		int[] expected = new int[]{10, 20, 30, 40, 50, 60};
		assertEquals(6, SortTools.insertInPlace(x, 5, 60));
		assertArrayEquals(expected, x);
	}

	@Test
	public void testInsertInPlacePartialBeginning() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{4, 10, 20, 30, 50};
		assertEquals(4, SortTools.insertInPlace(x, 3, 4));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testInsertInPlaceFullBeginning() {
		int[] x = new int[]{10, 20, 30, 40, 50, 0};
		int[] expected = new int[]{-5, 10, 20, 30, 40, 50};
		assertEquals(6, SortTools.insertInPlace(x, 5, -5));
		assertArrayEquals(expected, x);
	}

	@Test
	public void testInsertInPlacePartialMiddle() {
		int[] x = new int[]{10, 20, 30, 40, 50};
		int[] expected = new int[]{10, 20, 25, 30, 50};
		assertEquals(4, SortTools.insertInPlace(x, 3, 25));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testInsertInPlaceFullMiddle() {
		int[] x = new int[]{10, 20, 30, 40, 50, 0};
		int[] expected = new int[]{10, 20, 30, 35, 40, 50};
		assertEquals(6, SortTools.insertInPlace(x, 5, 35));
		assertArrayEquals(expected, x);
	}
	
	/////////////////////////////////////////////////////////
	// Test SortTools.InsertSort()
	/////////////////////////////////////////////////////////
	@Test
	public void testInsertSortFull() {
		int[] x = new int[] {20, 10, 30, 60, 50};
		int[] expected = new int[] {10, 20, 30, 50, 60};
		SortTools.insertSort(x, 5);
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void testInsertSortPartial() {
		int[] x = new int[] {20, 10, 30, 70, 60};
		int[] expected = new int[] {10, 20, 30, 70, 60};
		SortTools.insertSort(x, 3);
		assertArrayEquals(expected, x);
	}
	
	// Consider testing arrays with repeat numbers
	@Test 
	public void testInsertSortFullRepeatedValues() {
		int[] x = new int[] {-2, 1, 4, 1, 3};
		int[] expected = new int[] {-2, 1, 1, 3, 4};
		SortTools.insertSort(x, 5);
		assertArrayEquals(expected, x);
	}
	@Test
	public void testInsertSortPartialRepeatedValues() {
		int[] x = new int[] {-2, 4, 1, -2, 3};
		int[] expected = new int[] {-2, -2, 1, 4, 3};
		SortTools.insertSort(x, 4);
		assertArrayEquals(expected, x);
	}
	@Test
	public void testInsertSortNearlySorted() {
		int[] x = new int[] {-2, -2, 4, 1, 3};
		int[] expected = new int[] {-2, -2, 1, 3, 4};
		SortTools.insertSort(x, 5);
		assertArrayEquals(expected, x);
	}
	///////////////////////////////////////////////////////
	// More find tests
	///////////////////////////////////////////////////////
	@Test 
	public void testFindRepeated() {
		int[] x = new int[]{4, 5, 5, 6, 6, 7, 8, 8, 9, 10};
		assertEquals(1, SortTools.find(x, 10, 5));
	}
	@Test 
	public void testFindOddSizeArr() {
		int[] x = new int[]{-2, -1, 0, 0, 1, 2, 3};
		assertEquals(6, SortTools.find(x, 7, 3));
	}
	@Test 
	public void testFindEvenSizeArr() {
		int[] x = new int[]{-2, -1, 0, 1, 2, 3};
		assertEquals(0, SortTools.find(x, 3, -2));
	}
}
