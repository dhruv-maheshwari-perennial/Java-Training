package Concurrency;

import static Concurrency.ThreadColor.*;

// Interrupt & Join
class AnotherThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLACK + "Another Thread woke me up");
            return;
        }

        System.out.println(ANSI_CYAN + "3 Sec passed & I'm awake");

    }
}

public class Thread_03 {
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "Main Thread");
        System.out.println("---------------");

        Thread anotherThread2 = new AnotherThread2();
        anotherThread2.setName("Another Thread from Main");
        anotherThread2.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_RED + "Anonymous Class Thread");
            }
        }.start();

        Thread myRun = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_PURPLE + "Runnable Thread Again");

                try {
                    anotherThread2.join(2000);
                    System.out.println(ANSI_RED + "Another Thread terminated");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "Interrupted");
                }
            }
        });

        myRun.start();
//        anotherThread2.interrupt();

        System.out.println("Main Thread Again");
        System.out.println("---------------");
    }
}
