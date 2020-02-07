package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// im following the rest convention to develop web service endpoints
// The endpoint represents the address book resource we are using
// the base path, which will precede the other paths inside the methods

@RestController
@RequestMapping("/address-books")
public class AddressBookRestController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository budyInfoRepository;

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


    @RequestMapping(path="/{id}/buddyInfo/{id2}", method= RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        Optional <AddressBook> optional = addressBookRepository.findById(id);
        AddressBook addressBook;
        if(optional.isPresent()) {
            addressBook = optional.get();
        } else return;
        for(BuddyInfo buddyInfo : addressBook.getBuddyInfos()) {
            if(buddyInfo.getId()  == id2) {
                addressBook.getBuddyInfos().remove(buddyInfo);
            }
        }
        addressBookRepository.save(addressBook);
    }

}


