import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class MajorityElement {


    // Метод для нахождения элементов, которые встречаются более заданного процента
    public static Map<Integer, Integer> findElementsByPercentage(int[] nums, double percentage) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int threshold = (int) (nums.length * (percentage / 100.0));

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
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

        // Нахождение элементов, которые встречаются более 30%
        System.out.print("Введите процент мажоритарности: ");
        double percentage = input.nextDouble();
        Map<Integer, Integer> elementsByPercentage = findElementsByPercentage(nums, percentage);
        System.out.println("Элементы, встречающиеся более " + percentage + "%: " + elementsByPercentage);
    }
}
