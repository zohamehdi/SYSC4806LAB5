package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

// The Controller coordinates interactions
// between the View and Model
@Component
public class AddressBookController {
    @Autowired
    private AddBuddyButtonListener addBuddyButtonListener;
    @Autowired
    private AddressBookView theView;
    @Autowired
    private AddressBookModel theModel;


    public AddressBookController() {

    }

    public AddBuddyButtonListener getAddBuddyButtonListener() {
        return addBuddyButtonListener;
    }

    public void setAddBuddyButtonListener(AddBuddyButtonListener addBuddyButtonListener) {
        this.addBuddyButtonListener = addBuddyButtonListener;
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
    //method needs to be executed after dependency injection is done to perform initialization of the view and model

    @PostConstruct
    public void init() {
        theView.setVisible(true);
        theView.pack();
        theModel.loadFromDatabase();
        theView.update();
        this.theView.addBuddyListener(addBuddyButtonListener);
    }


}