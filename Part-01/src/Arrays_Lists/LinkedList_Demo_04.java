package Arrays_Lists;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedList_Demo_04 {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Aligarh");
        addInOrder(placesToVisit, "Pune");
        addInOrder(placesToVisit, "Srinagar");
        addInOrder(placesToVisit, "Kolkata");
        addInOrder(placesToVisit, "Chennai");
        addInOrder(placesToVisit, "Mumbai");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Bangalore");
        printList(placesToVisit);

        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> placesToVisit) {
        for (String s : placesToVisit) {
            System.out.println("Now visiting: " + s);
        }
        System.out.println("===============================");
    }

    private static boolean addInOrder(LinkedList<String> placesToVisit, String newCity) {
        ListIterator<String> stringIterator = placesToVisit.listIterator();

        while (stringIterator.hasNext()) {
            int comparison = stringIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included as a destination");
            } else if (comparison > 0) {
                stringIterator.previous();
                stringIterator.add(newCity);
                return true;
            }
        }

        stringIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        boolean goingForward = true;

        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities.");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("Reached end of list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Avaiable actions:\npress");
        System.out.println("0 - to quit\n" + "1 - go to next city\n" + "2 - go to previous city\n" + "3 - print menu option");
    }
}
