import java.util.Random;
import java.util.Scanner;

class ReplaceArrayElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int N, M;

        do {
            System.out.print("Введіть значення N (Не більше 10): ");
            N = scanner.nextInt();
        } while (N >= 10);

        do {
            System.out.print("Введіть значення M (Не більше 10): ");
            M = scanner.nextInt();
        } while (M >= 10);

        int[][] array = new int[N][M];

        System.out.println("Заповнений масив:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = random.nextInt(90) + 10; // Випадкові значення від 10 до 99
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Масив зі зміненими значеннями:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] % 2 == 0) {
                    array[i][j] = 1; // Парне число замінюємо на 1
                } else {
                    array[i][j] = 0; // Непарне число замінюємо на 0
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
