package Challenges;

//Primitive datatype practice
public class Challenge_03 {
    public static void main(String[] args) {
        byte myByte = 1;
        short myShort = 10;
        int myInt = 100;

        long myLong = 50000 + (10 * (myByte+myInt+myShort));

        System.out.println(myLong);
    }
}
