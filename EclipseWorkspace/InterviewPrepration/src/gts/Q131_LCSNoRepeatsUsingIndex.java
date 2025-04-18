package gts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***
 * Read a file from localsystem and find longest common subsequence with no
 * repeating character.
 */
public class Q131_LCSNoRepeatsUsingIndex {
	public static String findLCS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		// Create DP table
		int[][] dp = new int[m + 1][n + 1];

		// Fill DP table
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				
				if (c1 == c2) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// Backtrack to build dp string
		int i = m, j = n;
		StringBuilder lcsString = new StringBuilder();

		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				lcsString.append(s1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		// Since we added characters from the end, reverse the string
		lcsString.reverse();

		// Print DP table

		System.out.println("DP Table:");
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				System.out.print(dp[x][y] + " ");
			}
			System.out.println();
		}

		// Print LCS length and sequence
		System.out.println("Length of LCS: " + dp[m][n]);

		return lcsString.toString();
	}

	public static void main(String[] args) throws IOException {

		// 1️ Read two lines from file
		BufferedReader reader = new BufferedReader(new FileReader("D://data.txt"));
		String str1 = reader.readLine();
		String str2 = reader.readLine();
		reader.close();

		String lcs = findLCS(str1, str2);
		System.out.println("Longest Common Subsequence: " + lcs);
	}
}
