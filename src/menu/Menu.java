package menu;

import java.util.Scanner;
import logic.Matrix;
import logic.NumAnalyzer;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static Matrix currentMatrix = null;
    private static NumAnalyzer strNumbers = null;

    static public void StartMenu(){
         while(true) {
             System.out.println("\n\n===ГЛАВНОЕ МЕНЮ===");
             System.out.println("1. Матрица");
             System.out.println("2. Числа");
             System.out.println("0. Выход");
             System.out.print("Выберите пункт: ");

             int choice = scanner.nextInt();
             scanner.nextLine();

             switch (choice) {
                 case 1 -> matrixMenu();
                 case 2 -> numsMenu();
                 case 0 -> {
                     try (scanner) {
                         System.out.println("Выход из программы...");
                     }
                     return;
                 }

             }
         }
    }
    static private void matrixMenu(){
        while(true){
            System.out.println("\n\n===МЕНЮ МАТРИЦЫ===");
            System.out.println("1. Создать матрицу");
            System.out.println("2. Поиск среднего значение отрицательных чисел");
            System.out.println("3. Вывод побочной диагонли матрицы");
            System.out.println("4. Вывод матрицы");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
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
            System.out.println("\n\n===МЕНЮ СОЗДАНИЯ МАТРИЦЫ===");
            System.out.println("1. Создать стандартную матрицу");
            System.out.println("2. Создать матрицу по спирали из одномерного массива");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> {
                    currentMatrix = new Matrix(scanner, false);
                    return;
                }
                case 2 -> {
                    currentMatrix = new Matrix(scanner, true);
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
    static private void numsMenu(){
        while(true){
            System.out.println("\n\n===МЕНЮ ОБРАБОТКИ ЧИСЕЛ===");
            System.out.println("1. Ввод строки чисел");
            System.out.println("2. Поиск самого популярного числа в строке");
            System.out.println("0. Назад");
            System.out.print("Выберите пункт: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> {
                    strNumbers = new NumAnalyzer(scanner);
                }
                case 2 -> {
                    if (strNumbers == null || strNumbers.getStrNums() == null || strNumbers.getStrNums().isEmpty()) {
                        System.out.println("Сначала введите строку чисел (пункт 1)!");
                    } 
                    else {
                        System.out.print("Самое популярное число: ");
                        strNumbers.findMostPopNums();
                    }
                }
                case 0 -> {
                    System.out.println("Возврат в главное меню... ");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}
