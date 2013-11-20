/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution? */

public class Solution {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int row0 = 1, col0 = 1;
        int i, j;
        for(i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0) col0 = 0;
        }
        for(i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0) row0 = 0;
        }
        
        /* Mark zero rows/cols in row[0] and col[0] */
        for(i = 1; i < matrix.length; i++){
            for(j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(i = 1; i < matrix.length; i++){
            for(j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        if(col0 == 0){
            for(i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(row0 == 0){
            for(j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}