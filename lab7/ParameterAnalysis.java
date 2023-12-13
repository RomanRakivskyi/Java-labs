import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParameterAnalysis {
    public static void main(String[] args) {
        // Введення параметрів з командного рядка
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть параметри через пробіл:");
        String[] inputParams = scanner.nextLine().split(" ");

        // Аналіз параметрів
        analyzeParameters(inputParams);
    }

    // Метод для аналізу параметрів
    private static void analyzeParameters(String[] params) {
        // Створення колекції для визначення унікальних параметрів
        Set<String> uniqueParams = new HashSet<>();

        // Лічильник для визначення кількості різних параметрів
        int differentParamsCount = 0;

        // Цикл для визначення унікальних параметрів та їх кількості
        for (String param : params) {
            if (uniqueParams.add(param)) {
                // Параметр ще не був доданий, тобто це новий унікальний параметр
                differentParamsCount++;
            }
        }

        // Виведення результатів аналізу
        System.out.println("Кількість заданих параметрів: " + params.length);
        System.out.println("Кількість різних параметрів: " + differentParamsCount);
        System.out.println("Значення різних параметрів:");

        // Виведення унікальних параметрів
        for (String uniqueParam : uniqueParams) {
            System.out.println(uniqueParam);
        }
    }
}
