import java.util.Scanner;

class ThreeOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1, x2, x3;

        ///Input 1-st variable
        while (true) {
            System.out.print("Input First value: ");
            x1 = scanner.nextInt();
            ///Check borders
            if (x1 % 2 != 0) {
                break;
            } else {
                System.out.println("Value X1 is not odd! Input correct value.");
            }
        }

        ///Input 2-nd variable
        while (true) {
            System.out.print("Input Second value: ");
            x2 = scanner.nextInt();
            ///Check borders
            if (x2 % 2 != 0 && x2 < x1) {
                break;
            } else if (x2 % 2 == 0) {
                System.out.println("Value X2 is not odd! Input correct value.");
            } else {
                System.out.println("Value X2 is not less than First value X1! Input correct value.");
            }
        }

        ///Input 3-rd variable
        while (true) {
            System.out.print("Input Third value: ");
            x3 = scanner.nextInt();
            ///Check borders
            if (x3 % 2 != 0 && x3 < x2) {
                break;
            } else if (x3 % 2 == 0) {
                System.out.println("Value X3 is not odd! Input correct value.");
            } else {
                System.out.println("Value X3 is not less than Second value X2! Input correct value.");
            }
        }

        ///Output biggest value
        System.out.println("Result is " + x1 + " " + x2 + " " + x3);
        int largest = Math.max(x1, Math.max(x2, x3));
        System.out.println("Biggest value is: " + largest);
    }
}