import java.util.Scanner;
class series {
    public static void main(String Args[]) {
        Scanner scan = new Scanner(System. in );
        int num,
        count,
        sum = 0;
        float avg;
        num = scan.nextInt();
        for (count = 0; num != 0; count++) {
            sum += num;
            num = scan.nextInt();
        }
        avg = (float) sum / count;
        System.out.print("Numbers Entered:" + count + "\n" +
                "Sum: " + sum + "\n" + "Average:" + avg);
    }
}



