package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
class AddBuddyButtonListener implements ActionListener {
    @Autowired
    public AddressBookView theView;
    @Autowired
    public AddressBookModel theModel;
    public AddBuddyButtonListener(){

    }

    public AddressBookView getTheView() {
        return theView;
    }

    public void setTheView(AddressBookView theView) {
        this.theView = theView;
    }

    public AddressBookModel getTheModel() {
        return theModel;
    }

    public void setTheModel(AddressBookModel theModel) {
        this.theModel = theModel;
    }

    public void actionPerformed(ActionEvent e) {

        String name, address,number;
        int age;

        // Surround interactions with the view with
        // a try block in case numbers weren't
        // properly entered
        System.out.println("Button Clicked");
        try{

            name = theView.getName();
            address = theView.getAddress();
            age=theView.getAge();
            number=theView.getNumber();
            BuddyInfo buddyInfo= new BuddyInfo(name, address, number, age);
            theModel.getAddressBook().addBuddy(buddyInfo);
            theModel.updateDatabase();
            theView.update();
        }

        catch(NumberFormatException ex){

            System.out.println(ex);

            theView.displayErrorMessage("You Need to enter buddy info");

        }

    }

}