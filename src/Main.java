import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Метод для нахождения элементов, которые встречаются более заданного процента в один проход
    public static void findElementsByPercentage(int[] nums, double percentage) {
        Map<Integer, Integer> elements = new HashMap<>();
        int rate = (int) Math.ceil(nums.length * (percentage / 100.0)); // Рассчитываем порог для мажоритарности
        System.out.println("Элементы, встречающиеся более " + percentage + "%: ");

        boolean found = false;

        // Проходим по массиву
        for (int num : nums) {
            // Считаем количество текущего элемента
            int count = elements.getOrDefault(num, 0) + 1;
            elements.put(num, count);

            // Проверяем, превышает ли количество текущего элемента порог
            if (count == rate) {
                System.out.println("Элемент: " + num + ", Количество: " + count);
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
