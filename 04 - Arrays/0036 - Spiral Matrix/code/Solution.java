import java.util.*;

class SpiralMatrix {
    public List<Integer> spiralMatrix1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow=0, endRow=n-1, startCol=0, endCol=m-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++) result.add(matrix[startRow][j]);
            startRow+=1;
            for(int i=startRow;i<=endRow;i++) result.add(matrix[i][endCol]);
            endCol-=1;
            if(startRow<=endRow){
                for(int j=endCol;j>=startCol;j--) result.add(matrix[endRow][j]);
                endRow-=1;
            }
            if(startCol<=endCol){
                for(int i=endRow;i>=startRow;i--) result.add(matrix[i][startCol]);
                startCol+=1;
            }
        }
        return result;
    }

    public int[][] spiralMatrix2(int n) {
        int matrix[][] = new int[n][n];
        int startRow=0, endRow=n-1, startCol=0, endCol=n-1, val=1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++) matrix[startRow][j] = val++;
            startRow+=1;
            for(int i=startRow;i<=endRow;i++) matrix[i][endCol] = val++;
            endCol-=1;
            if(startRow<=endRow){
                for(int j=endCol;j>=startCol;j--) matrix[endRow][j] = val++;
                endRow-=1;
            }
            if(startCol<=endCol){
                for(int i=endRow;i>=startRow;i--) matrix[i][startCol] = val++;
                startCol+=1;
            }
        }
        return matrix;
    }
}
