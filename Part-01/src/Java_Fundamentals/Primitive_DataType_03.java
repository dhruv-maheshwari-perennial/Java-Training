package Java_Fundamentals;

// There are total 8 primitive data types in java
// boolean, byte, char, short, int, long, float & double
public class Primitive_DataType_03 {
    public static void main(String[] args) {

        // 1. int
        int myInt = 1000;
        int myIntMax = Integer.MAX_VALUE; // Integer is Wrapper Class
        int myIntMin = Integer.MIN_VALUE;
        System.out.println(myInt);
        System.out.println(myIntMax);
        System.out.println(myIntMin);

        // 2. byte
        byte myByteMax = Byte.MAX_VALUE; // Byte is Wrapper Class
        byte myByteMin = Byte.MIN_VALUE;
        System.out.println(myByteMax);
        System.out.println(myByteMin);

        // 3. short
        short myShortMax = Short.MAX_VALUE; // Short is Wrapper Class
        short myShortMin = Short.MIN_VALUE;
        System.out.println(myShortMax);
        System.out.println(myShortMin);

        // 4. long
        long myLong = 100L;
        long myLongMax = Long.MAX_VALUE; // Long is Wrapper Class
        long myLongMin = Long.MIN_VALUE;
        System.out.println(myLong);
        System.out.println(myLongMax);
        System.out.println(myLongMin);

        // 5. float
        float myFloat = (float) 2.25; // double is mostly used than float
        float myFloatMax = Float.MAX_VALUE; // Float is Wrapper Class
        float myFloatMin = Float.MIN_VALUE;
        System.out.println(myFloat);
        System.out.println(myFloatMax);
        System.out.println(myFloatMin);

        // 6. double
        double myDouble = 2.250909;
        double myDoubleMax = Double.MAX_VALUE; // Double is Wrapper Class
        double myDoubleMin = Double.MIN_VALUE;
        System.out.println(myDouble);
        System.out.println(myDoubleMax);
        System.out.println(myDoubleMin);

        // 7. char
        char myChar = 'D';
        char myUnicodeChar = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        // 8. boolean
        boolean myBool = true; // boolean has two value - true or false

        // String
        String myString = "Hello World";
        System.out.println("MyString: " + myString);
    }
}
