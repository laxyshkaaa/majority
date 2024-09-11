import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //  метод для нахождения элементов, которые встречаются более заданного процента
    public static void findElementsByPercentage(int[] nums, double percentage) {
        Map<Integer, Integer> elements = new HashMap<>();
        int rate = (int) Math.ceil(nums.length * (percentage / 100.0));  // находим колво элементов, которые войдут в мажоритарность

        //  считаем количество каждого элемента в мапе
        for (int num : nums) {
            int count = elements.getOrDefault(num, 0) + 1;
            elements.put(num, count);
        }

        // Выводим элементы, которые встречаются больше или равны порогу
        System.out.println("Элементы, встречающиеся более " + percentage + "%: ");
        boolean found = false;
        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            if (entry.getValue() >= rate) {  // Проверка >= rate
                System.out.println("Элемент: " + entry.getKey() + ", Количество: " + entry.getValue());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Нет элементов, удовлетворяющих условию.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = input.nextInt(); // Читаем количество элементов

        int[] nums = new int[n];

        // Ввод элементов массива
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt(); // Читаем каждый элемент массива
        }

        // Нахождение элементов, которые встречаются более определённого процента
        System.out.print("Введите процент мажоритарности: ");
        double percentage = input.nextDouble();
        findElementsByPercentage(nums, percentage);
    }
}
