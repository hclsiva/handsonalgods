package leetcode.forvgcs;

import java.util.Random;
import java.util.random.RandomGenerator;

public class MatrixRotation {

    public static void rotate(int[][] matrix){
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
          return;
      }
      int n = matrix.length;
      for(int layer =0; layer< n/2; layer++){
          int first = layer;
          int last = n -1-layer;
          for(int i = first ; i < last; i ++){
              int offset = i -first;
              int top = matrix[first][i];
              matrix[first][i] = matrix[last -offset][first];
              matrix[last-offset][first] = matrix[last][last-offset];
              matrix[last][last-offset] = matrix[i][last];
              matrix[i][last] = top;
          }
      }
    }
    public static void main(String[] args) {
        int[][] matrix = randomMatrix(4,1,10);
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }
    public static int[][] randomMatrix(int N, int min, int max) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = j;
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}


