package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// im following the rest convention to develop web service endpoints
// The endpoint represents the address book resource we are using
// the base path, which will precede the other paths inside the methods

@RestController
@RequestMapping("/address-books")
public class AddressBookRestController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    //We are doing a post to save buddies onto our address book
    @RequestMapping(path="", method = RequestMethod.POST)
    public AddressBook createAddressBook(@RequestBody AddressBook addressBook) {
        addressBookRepository.save(addressBook);
        return addressBook;
    }
    //We are doing a get to retrieve the buddies saved on the addressbook
    @RequestMapping(path="", method = RequestMethod.GET)
    public List<AddressBook> retrieveAll() {
        return addressBookRepository.findAll();
    }
}

