package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        menu_loop:
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println(" 1 - List the contacts");
            System.out.println(" 2 - Add a new entity");
            System.out.println(" 3 - Find a contact by name");
            System.out.println(" 4 - Modify a contact");
            System.out.println(" 5 - Delete a contact");
            System.out.println(" 0 - Quit the application");
            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    mobilePhone.printContacts();
                    break;
                }
                case 2: {
                    System.out.print("Enter name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Enter phone number:");
                    String phoneNumberToAdd = scanner.nextLine();
                    mobilePhone.addContact(nameToAdd, phoneNumberToAdd);
                    System.out.println("Contact added");
                    break;
                }
                case 3: {
                    System.out.print("Enter name: ");
                    String nameToFind = scanner.nextLine();
                    Contact contact = mobilePhone.findContact(nameToFind);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact.getName() + " - " + contact.getPhoneNumber());
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter the name of the contact to modify: ");
                    String nameToModify = scanner.nextLine();
                    Contact contact = mobilePhone.findContact(nameToModify);
                    if (contact != null) {
                        System.out.println("Modifying the following record: " + contact.getName() + " - " + contact.getPhoneNumber());
                        System.out.print("Enter the new name (or leave empty): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter the new phone number (or leave empty): ");
                        String newPhoneNumber = scanner.nextLine();
                        mobilePhone.editContact(contact.getName(), newName, newPhoneNumber);
                        System.out.println("Contact modified");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter the name of the contact to remove: ");
                    String nameToRemove = scanner.nextLine();
                    Contact contact = mobilePhone.findContact(nameToRemove);
                    if (contact != null) {
                        mobilePhone.removeContact(contact.getName());
                        System.out.println("Contact removed");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                }
                case 0:
                    break menu_loop;
            }
        }
    }
}
