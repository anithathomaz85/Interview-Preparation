package gts;

/***
 *  Rotate a matrix ( m* n) to the right by k steps
	Eg: Input :  N = 3, M = 3, K = 2
         12 23 34
         45 56 67
         78 89 91 

		Output : 23 34 12
				 56 67 45
				 89 91 78 

 * 
 * */

public class Q046_RotateMatrix {
	static int[] rotateRow(int[] row, int k) {
        int n = row.length;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = row[i];
        }
        return rotated;
    }
 
    public static void main(String[] args) {
        int[][] matrix = {
            {12, 23, 34},
            {45, 56, 67},
            {78, 89, 91}
        };
        int k = 2;
 
        // Save rotated rows back to matrix
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = rotateRow(matrix[i], k);
        }
 
        //  Print rotated matrix
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
