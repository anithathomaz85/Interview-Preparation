package gts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Q131_Q132_LCSNoRepeatsUsingIndexTest {

    @Test
    public void testFindLCS() {
        // Test case 1: "stone" and "longest"
        String str1 = "stone";
        String str2 = "longest";
        String expectedLCS = "one";  
        String actualLCS = Q131_LCSNoRepeatsUsingIndex.findLCS(str1, str2);
        assertEquals(expectedLCS, actualLCS, "LCS of 'stone' and 'longest' should be 'one'");

        // Test case 2: "abcde" and "ace"
        str1 = "abcde";
        str2 = "ace";
        expectedLCS = "ace"; 
        actualLCS = Q131_LCSNoRepeatsUsingIndex.findLCS(str1, str2);
        assertEquals(expectedLCS, actualLCS, "LCS of 'abcde' and 'ace' should be 'ace'");

        // Test case 3: No common subsequence
        str1 = "abc";
        str2 = "xyz";
        expectedLCS = "";  
        actualLCS = Q131_LCSNoRepeatsUsingIndex.findLCS(str1, str2);
        assertEquals(expectedLCS, actualLCS, "LCS of 'abc' and 'xyz' should be ''");

        // Test case 4: Identical strings
        str1 = "hello";
        str2 = "hello";
        expectedLCS = "hello";  
        actualLCS = Q131_LCSNoRepeatsUsingIndex.findLCS(str1, str2);
        assertEquals(expectedLCS, actualLCS, "LCS of 'hello' and 'hello' should be 'hello'");
    }
}
