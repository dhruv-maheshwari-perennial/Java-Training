package Concurrency;

import static Concurrency.ThreadColor.*;

class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLACK + "Another Thread woke me up");
        }

        System.out.println(ANSI_CYAN + "3 Sec passed & I'm awake");

    }
}

class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
}

public class Thread_01 {
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "Main Thread");
        System.out.println("---------------");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another Thread from Main");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_RED + "Anonymous Class Thread");
            }
        }.start();

        System.out.println("Main Thread Again");
        System.out.println("---------------");
    }
}
