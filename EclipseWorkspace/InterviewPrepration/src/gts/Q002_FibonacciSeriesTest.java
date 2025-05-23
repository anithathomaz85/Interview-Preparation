package gts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class Q002_FibonacciSeriesTest {
	
	@Test
	public void testFibonacciSeries1() {
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		 System.setOut(new PrintStream(outputStream));
		 
		 Q002_FibonacciSeries.main(new String[]{});
		 
		 System.setOut(System.out);
		 String expectedOutput = "0 1 1 2 3 5";
		 assertEquals(expectedOutput, outputStream.toString().trim());
	}

}

/**
 * ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
 * ByteArrayOutputStream: 
 * Stores the output as a byte stream instead of printing it directly to the console.

   System.setOut(new PrintStream(outputStream)): 
   Redirects System.out so that anything printed using 
   System.out.print() or System.out.println() is captured in outputStream 
   instead of appearing in the console.
   
   B_FibonacciSeries.main(new String[]{});
   Calls the main method.
   Since we redirected System.out, 
   the printed output is stored in outputStream 
   instead of being displayed in the console.
   
   System.setOut(System.out);
   Resets System.out back to the console 
   so that any further System.out.print() calls will display normally.
   
   assertEquals(expectedOutput, outputStream.toString());
   outputStream.toString() converts the captured output to a string.
 * 
 * */
