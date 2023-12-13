public class lab_02_20 {
    public static void main(String[] args) {

        //Variables Definition and Initialization
        int a = 20;
        int b = 10;

        System.out.println();
        System.out.println("Variable a = " + a);
        System.out.println("Variable b = " + b);
        System.out.println();

        System.out.println("1. Arithmetic operators");
        //Modulus, to get the area of the division of two operands
        System.out.println(a + " % " + b + " = " + (a % b));
        //Subtraction, to subtract two operands
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println();

        System.out.println("2. Unary arithmetic operators");
        //Increments "b" then store the new value of "b" in "val"
        System.out.println("Increment ++b = " + (++b));
        //Decrements "a" then store the new value of "a" in "val"
        System.out.println("Decrement --a = " + (--a));
        System.out.println();

        System.out.println("3. Relational operators");
        //Greater than
        System.out.println("a > b = " + (a > b));
        //Is not equal to
        System.out.println("a != b = " + (a != b));
        System.out.println();

        System.out.println("4. Logical Operators");
        //Logical AND
        System.out.println("(a > b) && a != b = " + ((a > b) && (a != b)));
        //Logical Not
        System.out.println("! (a > b) = " + ! (a > b));
        System.out.println();

        System.out.println("5. Bitwise Operators");
        //Binary XOR Operator
        System.out.println("a ^ b = " + (a ^ b));
        //Binary Left Shift Operator
        System.out.println("a << b = " + (a << b));
        System.out.println();

        System.out.println("6. Compound Assignment Operators");
        //Binary AND assigns
        System.out.println("Binary AND assigns a &= b = " + (a &= b));
        //Decrements then assigns
        System.out.println("Decrements then assigns a -= b = " + (a -= b));
        System.out.println();

        System.out.println("7. Conditional Operators together with Relational operators");
        String out;
        //Greater than or equal to
        out = a>=b ? "Yes":"No";
        System.out.println("Ans a >= b: " + out);
        //Less than or equal to
        out = a<=b ? "Yes":"No";
        System.out.println("Ans a <= b: " + out);
        System.out.println();
    }
}

