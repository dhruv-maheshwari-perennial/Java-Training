package Exercise;

// Exercise 11 - Sum Odd
public class Exercise_11 {
    public static void main(String[] args) {
        int start = 1, end = 100;

        int result = sumOdd(start, end);
        System.out.println(result);
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;

        if (start < 0 || end < 0 || end < start) {
            return -1;
        } else {
            for (int i = start; i <= end ; i++) {
                boolean odd = isOdd(i);

                if(odd) {
                    sum += i;
                }
            }
            return sum;
        }
//        if (start < 0 && end < 0 && end < start) return -1;
//        for (int i = start; i <= end ; i++) {
//            boolean odd = isOdd(i);
//
//            if(odd) {
//                sum += i;
//            }
//        }
//        return sum;
    }

    public static boolean isOdd(int i) {
        if (i < 0) return false;
        else if (i % 2 != 0) return true;
        else return false;
    }
}
