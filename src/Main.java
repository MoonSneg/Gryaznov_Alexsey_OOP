//package main
//
//public class Main {
//
//    // 10 вариант
//    //
//    //     a.  из одномерной матрицы сформируйте двумерную квадратную матрицу заданного размера,
//    //         располагая элементы «по спирали», закручивающейся от левого верхнего угла,
//    //         недостающие элементы обозначить нулями;
//    //
//    //     b.  найти в строке содержащей числа разделенные пробелами которое встречается чаще всего
//    //
//    //     c.  найти среднее арифметическое отрицательных элементов двумерной матрицы;
//    //
//    //     d.  представить элементы побочной диагонали в виде строки, разделять пробелами.
//
//    // Задача b
//    //========================================================================
//    public static void main(String[] args) {
//        int n = 3;
//        System.out.println("=== Тест A ===");
//        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Matrix matrix1 = new Matrix(n, nums1);
//        matrix1.print();
//        // Ожидаем по спирали:
//        // 1 8 7
//        // 2 9 6
//        // 3 4 5
//
//        // Тест для задачи b
//        System.out.println("\n=== Тест B ===");
//        String strNums = "3 2 5 7 5 15 44 3 5 3 4 4 4 4 4 5 ";
//        NumAnalyzer.findMostPopNums(strNums);
//        // Ожидаем: 4
//
//        String strNums2 = "10 20 10 30 30 30 20";
//        NumAnalyzer.findMostPopNums(strNums2);
//        // Ожидаем: 30
//
//        // Тест для задачи c
//        System.out.println("\n=== Тест C ===");
//        int[][] matrix2 = {
//                {-1, 2, -3},
//                {4, -2, 0}
//        };
//        System.out.println("Среднее отрицательных: " + Matrix.findAvgOfNegative(matrix2));
//        // Ожидаем: -2.0
//
//        System.out.println("Среднее отрицательных: " + matrix1.findAvgOfNegative());
//        // Ожидаем: 0.0
//
//
//        // Тест для задачи d
//        System.out.println("\n=== Тест D ===");
//        int[][] matrix4 = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        Matrix.printSecondaryDiagonal(matrix4);
//        // Ожидаем: 7 5 3
//
//        matrix1.printSecondaryDiagonal();
//        // Ожидаем: 3 9 7
//
//        Matrix matrixNew = new Matrix();
//        matrixNew.setMatrix(matrix4);
//        matrixNew.print();
//    }
//}
