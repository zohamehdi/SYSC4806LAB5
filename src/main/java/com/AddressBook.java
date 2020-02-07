package com;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook implements Serializable {
    int size = 0;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyInfos;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_SEQ_GEN")
    @SequenceGenerator(name="PROJECT_SEQ_GEN", sequenceName="PROJECT_SEQ_GEN")

    private int id;

    public AddressBook() {
        buddyInfos = new ArrayList<>();
    }

    public static AddressBook Import(String in) {
        String[] str = in.split("\n");
        AddressBook addr = new AddressBook();
        if (str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                addr.addBuddy(BuddyInfo.Import(str[i]));
            }
        }
        return addr;
    }

    public static void main(String[] args) {
        AddressBook Friends = new AddressBook();
        BuddyInfo Tom = new BuddyInfo("Tom", "Carleton", "61300000", 16);
        BuddyInfo Jill = new BuddyInfo("Jill", "Carleton", "61300001", 18);
        BuddyInfo Alex = new BuddyInfo("Alex", "Carleton", "61300002", 21);
        Friends.addBuddy(Tom);
        Friends.addBuddy(Jill);
        Friends.addBuddy(Alex);
        System.out.println(Friends.toString());
        System.out.println("Exporting and reimporting friends list;");
        System.out.println(Import(Friends.toString()));
    }

    public List<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public void setBuddyInfos(ArrayList<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    public void addBuddy(BuddyInfo Friend) {
        buddyInfos.add(Friend);
        size++;
    }

    public void setBuddy(int i, BuddyInfo Friend) {
        buddyInfos.set(i, Friend);
    }

    public void removeBuddy(BuddyInfo Friend) {
        buddyInfos.remove(Friend);
        size--;
    }

    public void removeBuddy(int i) {
        buddyInfos.remove(i);
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        buddyInfos.clear();
        size = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        String str = "";
        for (BuddyInfo Buddy : buddyInfos) {
            str += Buddy;
        }
        return str;
    }

    public String Export() {
        return toString();
    }
}
