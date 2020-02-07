package com;

// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;

import javax.swing.*;

@Component
public class AddressBookView extends JFrame{

    @Autowired
    private AddressBookModel theModel;

    private JButton AddBuddyButton = new JButton("Add Buddy");
    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField name  = new JTextField(10);
    private JLabel addressLabel = new JLabel("Address: ");
    private JTextField address = new JTextField(10);
    private JLabel ageLabel = new JLabel("Age: ");
    private JTextField age = new JTextField(10);
    private JLabel numberLabel = new JLabel("Phone Number: ");
    private JTextField number = new JTextField(10);
    private JTextArea addressBook= new JTextArea(20,5);

    AddressBookView(){

        // Sets up the view and adds the components

        JPanel addBookPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        addBookPanel.add(nameLabel);
        addBookPanel.add(name);
        addBookPanel.add(addressLabel);
        addBookPanel.add(address);
        addBookPanel.add(ageLabel);
        addBookPanel.add(age);
        addBookPanel.add(numberLabel);
        addBookPanel.add(number);

        addBookPanel.add(AddBuddyButton);
        addBookPanel.add(addressBook);


        this.add(addBookPanel);
        pack();

        // End of setting up the components --------

    }

    public String getName(){
        return (name.getText());

    }

    public String getAddress(){

        return (address.getText());

    }
    public int getAge(){

        return Integer.parseInt(age.getText());

    }
    public String getNumber(){

        return (number.getText());

    }
    public void clearFields(){
        name.setText("");
        address.setText("");
        age.setText("");
        number.setText("");
    }
    public void update(){
        System.out.println("View Updated");
        String textToView = "";
        for(BuddyInfo buddyInfo : theModel.getAddressBook().getBuddyInfos()) {
            textToView += buddyInfo + "\n";
        };
        addressBook.setText(textToView);
        //clearFields();
    }


    // If the calculateButton is clicked execute a method
    // in the Controller named actionPerformed

    void addBuddyListener(ActionListener listenForAddBuddyButton){
        System.out.println("Set action listener");

        AddBuddyButton.addActionListener(listenForAddBuddyButton);

    }

    // Open a popup that contains the error message passed

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }

}