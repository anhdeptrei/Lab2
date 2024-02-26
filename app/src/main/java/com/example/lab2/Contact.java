package com.example.lab2;

import java.io.Serializable;

public class Contact implements Serializable {
    private int Id;
    private String Name;
    private String Phonenumber;
    private boolean Status;

    public Contact(int id, String name, String phoneNumber){
        this.Id = id;
        this.Name = name;
        this.Phonenumber = phoneNumber;
        this.Status = false;
    }
    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public boolean isStatus() {
        return Status;
    }


}