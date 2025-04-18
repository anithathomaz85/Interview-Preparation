package gts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/***
 * Read a file from localsystem and find longest common subsequence with no
 * repeating character.
 */
public class Q131_LCSNoRepeats {
	public static void main(String[] args) throws IOException {
		// 1️ Read two lines from file
		BufferedReader reader = new BufferedReader(new FileReader("D://data.txt"));
		String str1 = reader.readLine();
		String str2 = reader.readLine();
		reader.close();

		// 2 Find and print LCS without repeating characters
		String lcs = findLCSNoRepeats(str1, str2);
		System.out.println("Longest Common Subsequence without Repeating Characters: " + lcs);
	}

	public static String findLCSNoRepeats(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		// DP table to store LCS strings
		String[][] dp = new String[m + 1][n + 1];

		// Initialize with empty strings
		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], "");
		}

		// Fill DP table
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);

				if (c1 == c2) {
					// Only add if character is not already in subsequence
					if (!dp[i - 1][j - 1].contains(String.valueOf(c1))) {
						dp[i][j] = dp[i - 1][j - 1] + c1;
					} else {
						dp[i][j] = longest(dp[i - 1][j], dp[i][j - 1]);
					}
				} else {
					dp[i][j] = longest(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	// Utility to get longer of two strings
	public static String longest(String a, String b) {
		return a.length() >= b.length() ? a : b;
	}
}
