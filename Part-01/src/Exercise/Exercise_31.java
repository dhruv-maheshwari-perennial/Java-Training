package Exercise;

import java.util.ArrayList;
import java.util.Scanner;

// Exercise 31 - Mobile Phone
class MobilePhone {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    // Getters and setters
    public ArrayList<Contact> getContacts() {
        return contactList;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contactList = contacts;
    }

    // Methods
    public void printListOfContacts() {
        if(contactList.size() == 0) {
            System.out.println("List of contacts is empty");
        } else {
            System.out.println("/*--- List of contacts ---*/");
            for(int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i).getName() + ": " + contactList.get(i).getNumber());
            }
        }
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added");
    }

    public void updateContact(String name, Contact newContact) {
        int position = findContact(name);
        if(position < 0) {
            System.out.println("Contact not found");
        }
        contactList.set(position, newContact);
        System.out.println("Contact updated");
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if(position < 0) {
            System.out.println("Contact not found");
        }
        contactList.remove(position);
        System.out.println("Contact deleted");
    }

    public int findContact(Contact contact) {
        return contactList.indexOf(contact);
    }

    public int findContact(String contactName) {
        for(int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if(contact.getName().toLowerCase().equals(contactName.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}

class Contact {

    private String name;
    private int number;

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class Exercise_31 {
    public static void main(String[] args) {
        printMenu();
        boolean quit = false;
        while(!quit) {
            System.out.println("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    printListOfContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    quit();
                    break;
                default:
                    System.out.println("Invalid option");
                    printMenu();
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    private static void printMenu() {
        System.out.println("Print:");
        System.out.println("\t 1- Print list of contacts");
        System.out.println("\t 2- Add new contact");
        System.out.println("\t 3- Update existing contact");
        System.out.println("\t 4- Remove contact");
        System.out.println("\t 5- Search / find contact");
        System.out.println("\t 6- Quit");
    }

    private static void printListOfContacts() {
        mobilePhone.printListOfContacts();
    }

    private static void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        mobilePhone.addContact(new Contact(name, number));
    }

    private static void updateContact() {
        System.out.println("Enter contact you want to update: ");
        String name = scanner.nextLine();

        System.out.println("Enter contact new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter contact new number: ");
        int newPhoneNumber = scanner.nextInt();
        scanner.nextLine();

        Contact newContact = new Contact(newName, newPhoneNumber);

        mobilePhone.updateContact(name, newContact);
    }

    private static void removeContact() {
        System.out.println("Enter contact you want to remove: ");
        String name = scanner.nextLine();

        mobilePhone.removeContact(name);
    }

    private static void searchContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();

        int contactPosition = mobilePhone.findContact(name);
        if(contactPosition < 0) {
            System.out.println("Contact not found");
        }
        System.out.println(name + ": " + mobilePhone.getContacts().get(contactPosition).getNumber());
    }

    private static void quit() {
        System.out.println("/*--- Goodbye ---*/");
    }
}
