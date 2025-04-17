package gts;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Find the number of character present in the given string
 * */
public class Q119_CharacterCount {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter a string:");
        InputStreamReader reader = new InputStreamReader(System.in);
        int count = 0;
 
        while (true) {
            int ch = reader.read(); // reads one character
            if (ch == '\n' || ch == -1) {
                break;
            }
            count++;
        }
        System.out.println("Total characters = " + (count-1));
    }
}
