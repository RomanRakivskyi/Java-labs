import java.util.*;
public class PIP {
    public static void main(String Args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your surname: ");
        String surname = in.nextLine();
        System.out.println("Input your first name: ");
        String first_name = in.nextLine();
        System.out.println("Input your patronymic: ");
        String patronymic = in.nextLine();
        System.out.println("PIP: " + surname + " " + first_name + " " + patronymic + ".");
    }
}
