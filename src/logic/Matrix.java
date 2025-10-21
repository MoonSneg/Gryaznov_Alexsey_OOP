package logic;

import java.util.Scanner;

public class Matrix {
    private int[][] data;
    private int row;
    private int col;

    public Matrix(){
        this.data = new int[0][0];
        this.row = 0;
        this.col = 0;
    }



    public Matrix(Scanner scanner, boolean spiral) {
        if(spiral){
            System.out.print("Введите размерность матрицы: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите элементы массива через пробел: ");
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");

            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }

            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            int cnt = 0;
            int[][] matrix = new int[n][n];

            while (left <= right && top <= bottom) {
                // Заполнение сверху вниз
                for (int i = top; i <= bottom; i++) {
                    matrix[i][left] = (cnt < nums.length) ? nums[cnt] : 0;
                    if (cnt < nums.length) cnt++;
                }
                left++;
                // Заполенине слева направо
                for (int i = left; i <= right; i++) {
                    matrix[bottom][i] = (cnt < nums.length) ? nums[cnt] : 0;
                    if (cnt < nums.length) cnt++;
                }
                bottom--;
                // заполнение снизу вверх
                if (top <= bottom) {
                    for (int i = bottom; i >= top; i--) {
                        matrix[i][right] = (cnt < nums.length) ? nums[cnt] : 0;
                        if (cnt < nums.length) cnt++;
                    }
                    right--;
                }
                // заполнение справа налево
                if (left <= right) {
                    for (int i = right; i >= left; i--) {
                        matrix[top][i] = (cnt < nums.length) ? nums[cnt] : 0;
                        if (cnt < nums.length) cnt++;
                    }
                    top++;
                }
            }
            this.data = matrix;
            this.row = n;
            this.col = n;
        }
        else {
            System.out.print("Введите кол-во строк: ");
            int iRow = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите кол-во столбцов: ");
            int iCol = scanner.nextInt();
            
            int[][] matrix = new int[iRow][iCol];
            
            System.out.println("Введите элементы матрицы построчно:");
            for (int i = 0; i < iRow; i++) {
                System.out.print("Строка " + (i + 1) + ": ");
                for (int j = 0; j < iCol; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            this.data = matrix;
            this.row = iRow;
            this.col = iCol;
        }
    }

    public void setMatrix(int[][] inpMatrix){
        this.data = inpMatrix;
        this.row = inpMatrix.length;
        this.col = inpMatrix[0].length;
        int[][] newMatrix = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                newMatrix[i][j] = inpMatrix[i][j];
            }
        }
        this.data=newMatrix;
    }

    public void print(){
        System.out.println("\nМатрица: ");
        for(int i = 0;i < this.row;i++){
            for (int j=0;j < this.col;j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
    }


    public double findAvgOfNegative(){
        return findAvgOfNegative(this.data);
    }

    public static double findAvgOfNegative(int[][] matrix) {
        float sum = 0;
        float cnt = 0;
        for (int[] i : matrix) {
            for (int j : i) {
                if (j < 0) {
                    sum += j;
                    cnt++;
                }
            }
        }
        return (cnt == 0) ? 0.0 : sum / cnt;
    }

    public void printSecondaryDiagonal(){
        printSecondaryDiagonal(this.data);
    }

    public static void printSecondaryDiagonal(int[][] matrix){
        if (matrix[0].length == matrix.length) {
            int i = matrix.length - 1;
            System.out.print("Побочная диагональ: ");
            while (i >= 0) {
                System.out.print(matrix[i][matrix.length - i - 1] + " ");
                i--;
            }
            System.out.println();
        }
        else {
            System.out.println("ОШИБКА: Матрица должна быть квадратной");
        }
    }

}

