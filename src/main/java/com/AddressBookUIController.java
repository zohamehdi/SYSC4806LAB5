package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AddressBookUIController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    //Im using the URL to get the ID passed. If the id doesnt exist i get the error message, otherwise i get the list of buddy infos

    @GetMapping(path="/{id}")
    public String getUi(@PathVariable("id") int id, Model model) {
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        List<BuddyInfo> buddyInfos;
        if(addressBook.isPresent()) {
            buddyInfos = addressBook.get().getBuddyInfos();
        } else {
            model.addAttribute("error", "Address book doesn't exist");
            buddyInfos = new ArrayList<>();
        }
        model.addAttribute("buddyInfos", buddyInfos);

        return "buddyInfos";
    }
}
