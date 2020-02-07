package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// The Model performs all the calculations needed
// and that is it. It doesn't know the View
// exists
@Component
public class AddressBookModel {
    // Holds the content of the addressBook entered in the view
    AddressBook addressBook;

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookModel() {
        addressBook = new AddressBook();
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    //updating the database with my persisted data
    public void updateDatabase() {

        System.out.println("Saving to database...");
        System.out.println("AddressBook saved: " + addressBook);
        addressBookRepository.save(this.addressBook);
    }

    //loading the database from the database

    public void loadFromDatabase() {
        System.out.println("Loading from database...");
        List<AddressBook> addressBookFromDatabase = addressBookRepository.findAll();
        if(!addressBookFromDatabase.isEmpty()) {
            System.out.println("Data Found!");
            addressBook = addressBookFromDatabase.get(0);
            System.out.println("AddressBook loaded: " + addressBook);
        }
    }

}