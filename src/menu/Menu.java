package menu;

import logic.Matrix;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static Matrix currentMatrix = null;

    static public void StartMenu(){
         while(true) {
             System.out.println("\n===ГЛАВНОЕ МЕНЮ===");
             System.out.println("1. Матрица");
             System.out.println("2. Числа");
             System.out.println("0. Выход");
             System.out.print("Выберите пункт: ");

             int choice = scanner.nextInt();
             scanner.nextLine();

             switch (choice) {
                 case 1 -> matrixMenu();
                 case 0 -> {
                     System.out.println("Выход из программы...");
                     scanner.close();
                     return;
                 }
             }
         }
    }
    static private void matrixMenu(){
        while(true){
            System.out.println("\n===МЕНЮ МАТРИЦЫ===");
            System.out.println("1. Создать матрицу");
            System.out.println("2. Поиск среднего значение отрицательных чисел");
            System.out.println("3. Вывод побочной диагонли матрицы");
            System.out.println("4. Вывод матрицы");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> createMatrixMenu();
                case 2 -> {
                    if(currentMatrix == null)
                        System.out.println("Матрица пустая");
                    else
                        System.out.println(currentMatrix.findAvgOfNegative());
                }
                case 3 -> {
                    if(currentMatrix == null)
                        System.out.println("Матрица пустая");
                    else
                        currentMatrix.printSecondaryDiagonal();
                }
                case 4 -> {
                    if(currentMatrix == null)
                        System.out.println("Матрица пустая");
                    else
                        currentMatrix.print();
                }
                case 0 -> {
                    System.out.println("Возврат в главное меню...");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
    static private void createMatrixMenu(){
        while(true){
            System.out.println("\n===МЕНЮ СОЗДАНИЯ МАТРИЦЫ===");
            System.out.println("1. Создать стандартную матрицу");
            System.out.println("2. Создать матрицу по спирали из одномерного массива");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    currentMatrix = new Matrix();
                    return;
                }
                case 2 -> {
                    currentMatrix = new Matrix(scanner);
                    return;
                }
                case 0 -> {
                    System.out.println("Возврат в меню матрицы...");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}
