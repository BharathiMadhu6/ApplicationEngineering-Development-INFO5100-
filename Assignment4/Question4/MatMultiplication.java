package Question4;

import java.util.Scanner;

public class MatMultiplication {

    public int[][] multiplication(int[][] matrix1, int[][] matrix2) {

        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for(int h = 0; h < matrix1[0].length; h++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + (matrix1[i][h] * matrix2[h][j]);
                }
            }
        }
        return resultMatrix;
    }

    public static void main(String[] args) {

        MatMultiplication mat = new MatMultiplication();

        System.out.println("Matrix Multiplication \n");
        System.out.println("Enter the row size of matrix 1 \n");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        if(m <= 0) {
            throw new IllegalArgumentException("The row size cannot be 0");
        }

        System.out.println("Enter the column size of matrix 1 \n");
        int n = sc.nextInt();

        if(n <= 0) {
            throw new IllegalArgumentException("The column size cannot be 0");
        }

        int[][] matrix1 = new int[m][n];

        System.out.println("Enter the matrix 1 elements \n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the row size of matrix 2 \n");
        int m1 = sc.nextInt();

        if(m1 <= 0) {
            throw new IllegalArgumentException("The row size cannot be 0");
        }

        System.out.println("Enter the column size of matrix 2 \n");
        int n1 = sc.nextInt();

        if(n1 <= 0) {
            throw new IllegalArgumentException("The column size cannot be 0");
        }

        int[][] matrix2 = new int[m1][n1];
        System.out.println("Enter the matrix 2 elements \n");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }


        System.out.println(" The matrix after multiplication is : \n");

        int[][] resultMatrix = mat.multiplication(matrix1, matrix2);
            for (int h = 0; h < resultMatrix.length; h++) {
                for (int j = 0; j < resultMatrix[0].length; j++) {
                    System.out.print(resultMatrix[h][j] + " ");
                }
                System.out.println();
            }
        }
    }
