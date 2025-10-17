package logic;

public class NumAnalyzer {
    private String strNums;

    public NumAnalyzer() {
        this.strNums = "";
    }

    public NumAnalyzer(String strNums) {
        this.strNums = strNums;
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
