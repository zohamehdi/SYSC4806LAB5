package com;

import javax.persistence.*;
import java.io.Serializable;

@Entity
class BuddyInfo implements Serializable {
    String message;
    int age;
    String name;
    String address;
    String phone_number;
    @ManyToOne(cascade = CascadeType.ALL)
    private AddressBook addressBook;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_SEQ_GEN")
    @SequenceGenerator(name="PROJECT_SEQ_GEN", sequenceName="PROJECT_SEQ_GEN")
    private int id;

    public BuddyInfo() {
    }

    public BuddyInfo(String Name, String Address, String Phone_Number, int Age) {
        this.setName(Name);
        this.setAddress(Address);
        this.setPhone_number(Phone_Number);
        this.setAge(Age);
    }

    public BuddyInfo(String Name, String Address, String Phone_Number) {
        this.setName(Name);
        this.setAddress(Address);
        this.setPhone_number(Phone_Number);
    }

    public BuddyInfo(BuddyInfo Bud) {
        this.setName(Bud.getName());
        this.setAddress(Bud.getAddress());
        this.setPhone_number(Bud.getPhone_number());
        this.setAge(Bud.getAge());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BuddyInfo Homer = new BuddyInfo("Homer", "Some Place", "00000000", 16);
        System.out.println("Hello " + Homer.getName());
        System.out.println(Import(Homer.toString()).toString());
    }

    public static BuddyInfo Import(String in) {

        String[] str = in.split("\\|");
        if (str.length == 3) {
            String name = str[0].trim();
            String address = str[1].trim();
            String phone = str[2].trim();
            return new BuddyInfo(name, address, phone);
        } else {
            System.out.println("Invalid import string");
            return new BuddyInfo("", "", "");
        }
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String toString() {
        String str = String.format("%15s", name) + String.format("%15s", address)+ String.format("%15s", age) + String.format("%15s", phone_number) + "\n";
        return str;
    }

    public String Greeting(String speak) {
        message = speak;
        return message;
    }

    public boolean isOver18() {
        if (this.getAge() > 18) {
            return true;
        } else {
            return false;
        }
    }
}
