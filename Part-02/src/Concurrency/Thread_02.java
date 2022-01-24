package Concurrency;

import static Concurrency.ThreadColor.*;

// Runnable Class
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnable Class Thread");
    }
}

public class Thread_02 {
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "Main Thread");
        System.out.println("---------------");

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous Class Thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_PURPLE + "Runnable Thread Again");
            }
        });
        myRunnableThread.start();

        System.out.println("Main Thread Again");
        System.out.println("---------------");
    }
}
