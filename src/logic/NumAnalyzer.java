package logic;

import java.util.Scanner;

public class NumAnalyzer {
    private String strNums;

    public NumAnalyzer() {
        this.strNums = "";
    }

    public NumAnalyzer(Scanner scanner) {
        inputNumbers(scanner);
    }

    private void inputNumbers(Scanner scanner) {
        while (true) {
            System.out.print("Введите числа через пробел: ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("Ошибка: строка не может быть пустой!");
                continue;
            }
            
            // Проверка, что в строке только числа и пробелы
            if (!input.matches("[0-9\\s-]+")) {
                System.out.println("Ошибка: в строке должны быть только числа и пробелы!");
                continue;
            }
            
            // Проверка отдельных чисел
            String[] parts = input.split("\\s+");
            boolean valid = true;
            for (String part : parts) {
                try {
                    Integer.valueOf(part);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: '" + part + "' не является числом!");
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                this.strNums = input;
                System.out.println("Числа успешно введены: " + input);
                break;
            }
        }
    }

    public void findMostPopNums() {
        Dict<String, Integer> dict = new Dict<>();


        for (String num : this.strNums.split(" ")) {
            Integer count = dict.get(num);
            if (count == null) {
                dict.put(num, 1);
            } else {
                dict.put(num, count + 1);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < dict.getSize(); i++) {
            int value = dict.getValueAt(i);
            if (value > maxCount) {
                maxCount = value;
            }
        }
        
        for (int i = 0; i < dict.getSize(); i++) {
            String key = dict.getKeyAt(i);
            int value = dict.getValueAt(i);
            if (value == maxCount) {
                System.out.print(key + " ");
            }
        }
    }
    public static void findMostPopNums(String strNums) {
        Dict<String, Integer> dict = new Dict<>();

        for (String num : strNums.split(" ")) {
            Integer count = dict.get(num);
            if (count == null) {
                dict.put(num, 1);
            } else {
                dict.put(num, count + 1);
            }
        }

        int maxCount = 0;
        for (int i = 0; i < dict.getSize(); i++) {
            int value = dict.getValueAt(i);
            if (value > maxCount) {
                maxCount = value;
            }
        }
        System.out.print("Самое популярное число: ");
        for (int i = 0; i < dict.getSize(); i++) {
            String key = dict.getKeyAt(i);
            int value = dict.getValueAt(i);
            if (value == maxCount) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }
    public String getStrNums() {
        return strNums;
    }

    public void setStrNums(String strNums) {
        this.strNums = strNums;
    }
}
