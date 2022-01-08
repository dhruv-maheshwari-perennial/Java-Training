package Control_Flow_Statements;

public class While_DoWhile_03 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("");

        do {
            System.out.println(i);
            i++;
        } while(i < 20);
    }
}
