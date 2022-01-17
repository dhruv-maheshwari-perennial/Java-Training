package Classes_Interfaces;

//class Gearbox {
//    private ArrayList<Gear> gears;
//    private int maxGears;
//    private int currentGear = 0;
//    private boolean clutchIsIn;
//
//    public Gearbox(int maxGears) {
//        this.gears = new ArrayList<Gear>();
//        this.maxGears = maxGears;
//        Gear neutral = new Gear(0, 0.0);
//        this.gears.add(neutral);
//
//        for (int i = 0; i < maxGears; i++) {
//            addGear(i, i * 5.3);
//        }
//    }
//
//    public void operateClutch(boolean in) {
//        this.clutchIsIn = in;
//    }
//
//    public void addGear(int number, double ratio) {
//        if ((number > 0) && (number <= maxGears)) {
//            this.gears.add(new Gear(number, ratio));
//        }
//    }
//
//    public void changeGear(int newGear) {
//        if ((newGear >= 0) && (newGear < this.gears.size() && this.clutchIsIn)) {
//            this.currentGear = newGear;
//            System.out.println("Gear " + newGear + " selected");
//        } else {
//            System.out.println("Grind!");
//            this.currentGear = 0;
//        }
//    }
//
//    public double wheelSpeed(int revs) {
//        if (clutchIsIn) {
//            System.out.println("Scream!!");
//            return 0.0;
//        }
//        return revs * gears.get(currentGear).getRatio();
//    }
//
//    // non-static inner class - gear
//    private class Gear {
//        private int gearNumber;
//        private double ratio;
//
//        public Gear(int gearNumber, double ratio) {
//            this.gearNumber = gearNumber;
//            this.ratio = ratio;
//        }
//
//        public double getRatio() {
//            return ratio;
//        }
//
//        public void setRatio(double ratio) {
//            this.ratio = ratio;
//        }
//
//        public double driveSpeed(int revs) {
//            return revs * (this.ratio);
//        }
//    }
//}

import java.util.Scanner;

class Button {
    private String title;
    private OnClickListener onClickLister;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickLister(OnClickListener onClickLister) {
        this.onClickLister = onClickLister;
    }

    public void onClick() {
        this.onClickLister.onClick(this.title);
    }

    public interface OnClickListener {
        public void onClick(String title);
    }
}

public class Inner_Classes_02 {
    private static Scanner sc = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        // anonymous class
        btnPrint.setOnClickLister(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    btnPrint.onClick();
            }
        }
    }
}

//        Gearbox gb = new Gearbox(6);
//
//        gb.operateClutch(true);
//        gb.changeGear(1);
//        gb.operateClutch(false);
//
//        System.out.println(gb.wheelSpeed(1000));
//        gb.changeGear(2);
//        System.out.println(gb.wheelSpeed(3000));
//
//        gb.operateClutch(true);
//        gb.changeGear(3);
//        gb.operateClutch(false);
//        System.out.println(gb.wheelSpeed(6000));

//class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I've been attacked");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickLister(new ClickListener());
