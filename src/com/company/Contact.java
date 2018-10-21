package com.company;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        } else {
            System.err.println("The name is too short");
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.err.println("The phone number is too short");
        }
    }

    private boolean validateName(String name) {
        return name.length() >= 1;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() >= 1;
    }

}
