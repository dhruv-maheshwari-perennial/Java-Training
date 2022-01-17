package Arrays_Lists;

import java.util.ArrayList;
import java.util.Scanner;

class Grocery {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have: " + groceryList.size() + " items in your grocery list.");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + " . " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery Item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findGroceryItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);

        int pos = groceryList.indexOf(searchItem);
        if (pos >= 0) return groceryList.get(pos);
        return null;
    }

}

public class ArrayLists_02 {
    private static Scanner sc = new Scanner(System.in);
    private static Grocery groceryList = new Grocery();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstruction();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItems();
                    break;
                case 3:
                    modifyItems();
                    break;
                case 4:
                    removeItems();
                    break;
                case 5:
                    searchForItems();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstruction() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print list of grocery items.");
        System.out.println("\t 2 - To add an item to the grocery list.");
        System.out.println("\t 3 - To modify an item in the grocery list.");
        System.out.println("\t 4 - To remove an item from the grocery list.");
        System.out.println("\t 5 - To search for an item in the grocery list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItems() {
        System.out.println("Please enter the grocery item");
        groceryList.addGroceryItem(sc.nextLine());
    }

    public static void modifyItems() {
        System.out.println("Enter item number: ");
        int itemNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = sc.nextLine();
        groceryList.modifyGroceryItem(itemNo-1, newItem);
    }

    public static void removeItems() {
        System.out.println("Enter item number: ");
        int itemNo = sc.nextInt();
        sc.nextLine();
        groceryList.removeGroceryItem(itemNo-1);
    }

    public static void searchForItems() {
        System.out.println("Enter item to search: ");
        String searchItem = sc.nextLine();
        if (groceryList.findGroceryItem(searchItem) != null) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the grocery list");
        }
    }
}

