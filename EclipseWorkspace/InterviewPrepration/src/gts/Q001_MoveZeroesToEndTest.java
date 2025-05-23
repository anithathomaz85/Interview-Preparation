package gts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q001_MoveZeroesToEndTest {
	

	@Test
	void testA_MoveZeroesToEnd1() {
		int[] arr = {0, 1, 0, 3, 12};
	    int[] expectedResult = {1, 3, 12, 0, 0};
	    
	    Q001_MoveZerosToEnd.moveZerosToEnd(arr);
	    assertArrayEquals(expectedResult, arr);
	}
	
	  @Test
	  void testMoveZeroes2() {
	    int[] arr = {0, 0, 0};
	    int[] expected = {0, 0, 0};

	    Q001_MoveZerosToEnd.moveZerosToEnd(arr);
	    assertArrayEquals(expected, arr);
	  }
	  
	  @Test
	  void testMoveZeroes3() {
	    int[] arr = {1, 2, 3};
	    int[] expected = {1, 2, 3};

	    Q001_MoveZerosToEnd.moveZerosToEnd(arr);
	    assertArrayEquals(expected, arr);
	  }
	

}
