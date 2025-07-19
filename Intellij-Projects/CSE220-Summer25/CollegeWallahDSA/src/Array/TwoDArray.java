package Array;

import java.util.Scanner;

public class TwoDArray {
    // Method to print a 2D array
    public static void printTwoDArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // Method to add two matrices
    static void add(int[][] arr, int r1, int c1, int[][] arr2, int r2, int c2) {
        if(r1 != r2 || c1 != c2) {
            System.out.println("Wrong input - addition not possible");
            return;
        }
        int[][] sum = new int[r1][c1];

        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                sum[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        printTwoDArray(sum); // Added to display the result
    }

    // Method to multiply two matrices
    static void mul(int[][] arr, int r1, int c1, int[][] arr2, int r2, int c2) {
        if(c1 != r2) {
            System.out.println("Wrong input - multiplication not possible");
            return;
        }
        int[][] mul = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                for(int k = 0; k < c1; k++) {
                    mul[i][j] += arr[i][k] * arr2[k][j]; // Fixed the indices here
                }
            }
        }
        printTwoDArray(mul);
    }

    // Method to transpose a matrix
    static int[][] transpose(int[][] arr, int r, int c) {
        int[][] ans = new int[c][r];

        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }

    // Method to transpose the matrix in place
    static void transposeInPlace(int[][] arr, int r, int c) {
        for(int i = 0; i < c; i++) {
            for(int j = i; j < r; j++) {
                //swap matrix[i][j], matrix[j][i]
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // Method to reverse a 1D array
    static void reverseArray(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }

    // Method to rotate a 2D array 90 degrees
    static void rotate90(int[][] arr, int n){
        //transpose
        transposeInPlace(arr, n, n);

        //reverse each row of a transpose array
        for(int i = 0; i < n; i++){
            reverseArray(arr[i]);
        }
    }

    // Method to form a pascal triangle
    static void pascalTriangle(int[][] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            
        }
    }

    static void printSpiral(int[][] arr, int r, int c ){
        int topRow = 0, bottomRow = r-1, leftCol = 0, rightCol = c-1;
        int current = 0;

        while(current < r*c ){
            //top row -> leftCol to rightCol
            for(int j = leftCol; j <= rightCol && current <r*c; j++){
                System.out.print(arr[topRow][j] + " ");
                current++;
            }
            topRow++;

            //right col -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && current <r*c; i++){
                System.out.print(arr[i][rightCol] + " ");
                current++;
            }
            rightCol--;

            //bottom row -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && current <r*c; j--){

                System.out.print(arr[bottomRow][j] + " ");
                current++;
            }
            bottomRow--;

            //left col -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && current <r*c; i--){
                System.out.print(arr[i][leftCol] + " ");
                current++;
            }
            leftCol++;
        }
    }
    
    static int[][] printSpiralOrder(int n) {
        int[][] arr = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int current = 1;
        
        while(current <= n*n ){
            //top row -> leftCol to rightCol
            for(int j = leftCol; j <= rightCol && current <= n*n; j++){
                arr[topRow][j] = current++;
            }
            topRow++;

            //right col -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && current <= n*n; i++){
                arr[i][rightCol] = current;
                current++;
            }
            rightCol--;

            //bottom row -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && current <= n*n; j--){

                arr[bottomRow][j] = current;
                current++;
            }
            bottomRow--;

            //left col -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && current <= n*n; i--){
                arr[i][leftCol] = current;
                current++;
            }
            leftCol++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix input
        System.out.println("Enter the number of rows and columns for first matrix:");
        int r1 = sc.nextInt();
//        int c1 = sc.nextInt();
//        int[][] arr1 = new int[r1][c1];
//        System.out.println("Enter the elements of the matrix:");
//        for(int i = 0; i < r1; i++) {
//            for (int j = 0; j < c1; j++) {
//                arr1[i][j] = sc.nextInt();
//            }
//        }

//        System.out.println("Input Matrix:");
//        printTwoDArray(arr1);

        int[][] arr2 = printSpiralOrder(r1);
        printTwoDArray(arr2);
//        System.out.println("Spiral Matrix:");
//        printSpiral(arr1, r1, c1);

        // Second matrix input
//        System.out.println("Enter the number of rows and columns for second matrix:");
//        int r2 = sc.nextInt();
//        int c2 = sc.nextInt();
//        int[][] arr2 = new int[r2][c2];
//        System.out.println("Enter the elements of the second matrix:");
//        for(int i = 0; i < r2; i++) {
//            for(int j = 0; j < c2; j++) {
//                arr2[i][j] = sc.nextInt();
//            }
//        }

//        System.out.println("First matrix:");
//        printTwoDArray(arr1);
//        System.out.println("Second matrix:");
//        printTwoDArray(arr2);
//
//        System.out.println("Matrix Addition Result:");
//        add(arr1, r1, c1, arr2, r2, c2);
//
//        System.out.println("Matrix Multiplication Result:");
//        mul(arr1, r1, c1, arr2, r2, c2);
//        printTwoDArray(transpose(arr1, r1, c1));
//        transposeInPlace(arr1, r1, c1);
//        System.out.println("Original matrix:");
//        printTwoDArray(arr1);
//        rotate90(arr1, r1);
//        System.out.println("Rotated matrix:");
//        printTwoDArray(arr1);

    }
}