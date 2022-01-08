package Java_Fundamentals;

// Operators in Java -
// 1. Arithmetic
// 2. Unary
// 3. Assignment
// 4. Relational
// 5. Shift
// 6. Bitwise
// 7. Ternary
// 8. Logical

public class Operator_04 {
    public static void main(String[] args) {

        // Arithmetic Operators
        int a = 5 + 4;
        int b = 5 - 4;
        int c = 5 * 4;
        int d = 5 / 4;
        double e = 5 % 4;
        System.out.println("Add: " + a);
        System.out.println("Subtract: " + b);
        System.out.println("Multiply: " + c);
        System.out.println("Divide: " + d);
        System.out.println("Reminder: " + e);

        // ternary operator
        boolean base = false;
        String s = base ? "Hello" : "World";
        System.out.println(s);
    }
}
