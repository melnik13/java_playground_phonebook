package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MobilePhone {

    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public MobilePhone() {
    }

    public void printContacts() {
        new ContactPrinter(contactList);
    }

    public Contact addContact(String name, String phoneNumber) {
        Contact contact;
        if (this.findContact(name) == null) {
            contact = new Contact(name, phoneNumber);
            contactList.add(contact);
        } else {
            contact = null;
        }
        return contact;
    }

    public Contact removeContact(String name) {
        Contact contact = findContact(name);
        if (contact != null) {
            contactList.remove(contact);
        }
        return (contact);
    }

    public Contact editContact(String name, String newName, String newPhoneNumber) {
        Contact contact = findContact(name);
        if (contact != null) {
            if (newName.length() > 0) {
                contact.setName(newName);
            }
            if (newPhoneNumber.length() > 0) {
                contact.setPhoneNumber(newPhoneNumber);
            }
        }
        return contact;
    }

    public Contact getContact(String name) {
        return (findContact(name));
    }

    public Contact findContact(String name) {
        Contact contact;
        for (int i = 0; i < contactList.size(); i++) {
            contact = contactList.get(i);
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    private class ContactPrinter {

        private static final String HEADER_NAME = "Name";
        private static final String HEADER_PHONE_NUMBER = "Phone Number";

        public ContactPrinter(ArrayList<Contact> contactList) {
            int maxLengthOfName = HEADER_NAME.length();
            int maxLengthOfPhoneNumber = HEADER_PHONE_NUMBER.length();
            if (contactList.size() == 0) {
                System.out.println("No contacts found");
                return;
            }
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                int lengthOfName = contact.getName().length();
                int lengthOfPhoneNumber = contact.getPhoneNumber().length();
                if (lengthOfName > maxLengthOfName) {
                    maxLengthOfName = lengthOfName;
                }
                if (lengthOfPhoneNumber > maxLengthOfPhoneNumber) {
                    maxLengthOfPhoneNumber = lengthOfPhoneNumber;
                }
            }
            drawHorisontalDivider(new int[]{maxLengthOfName, maxLengthOfPhoneNumber});
            drawContactListEntry(new ArrayList<PrintableEntity>(asList(
                    new PrintableEntity(maxLengthOfName, HEADER_NAME),
                    new PrintableEntity(maxLengthOfPhoneNumber, HEADER_PHONE_NUMBER)
            )));
            drawHorisontalDivider(new int[]{maxLengthOfName, maxLengthOfPhoneNumber});
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                drawContactListEntry(new ArrayList<PrintableEntity>(asList(
                        new PrintableEntity(maxLengthOfName, contact.getName()),
                        new PrintableEntity(maxLengthOfPhoneNumber, contact.getPhoneNumber())
                )));
            }
            drawHorisontalDivider(new int[]{maxLengthOfName, maxLengthOfPhoneNumber});
        }

        private void drawHorisontalDivider(int[] fieldsLengths) {
            for (int i = 0; i < Array.getLength(fieldsLengths); i++) {
                System.out.print("+");
                for (int j = 0; j < fieldsLengths[i] + 2; j++) {
                    if (j == 0 || j == fieldsLengths[i] + 2 - 1) {
                        System.out.print("-");
                    } else {
                        System.out.print("-");
                    }
                }
                if (i == Array.getLength(fieldsLengths) - 1) {
                    System.out.println("+");
                }
            }
        }

        private void drawContactListEntry(ArrayList<PrintableEntity> entry) {
            for (int i = 0; i < entry.size(); i++) {
                int fieldLength = entry.get(i).getLength();
                String fieldValue = entry.get(i).getValue();
                System.out.print("|");
                System.out.printf(" %" + (fieldLength) + "s ", fieldValue);
                if (i == entry.size() - 1) {
                    System.out.println("|");
                }
            }
        }

        private class PrintableEntity {
            private int length;
            private String value;

            public PrintableEntity(int length, String value) {
                this.length = length;
                this.value = value;
            }

            public int getLength() {
                return length;
            }

            public String getValue() {
                return value;
            }
        }

    }

}
