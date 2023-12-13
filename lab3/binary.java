import java.util.Scanner;

class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування розміру масиву
        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Зчитування відсортованого масиву
        System.out.println("Введіть відсортований масив:");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }


        // Зчитування числа для пошуку
        System.out.print("Введіть число для пошуку: ");
        int search = scanner.nextInt();

        int result = binarySearch(array, search) + 1;

        if (result != -1) {
            System.out.println(search + " знайдено на позиції " + result);
        } else {
            System.out.println(search + " не знайдено в масиві.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    // Функція для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Якщо елемент не знайдено
    }
}
