/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rebecca
 */
public class Customer {
   SimpleStringProperty id;
   SimpleStringProperty firstname;
   SimpleStringProperty lastname;
   SimpleStringProperty jobtittle;
   SimpleStringProperty phonenumber;
    SimpleStringProperty address;
    SimpleStringProperty sex;

    public Customer(String id, String firstname, String lastname, String jobtittle, String phonenumber, String address, String sex) {
        this.id =  new SimpleStringProperty(id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.jobtittle = new SimpleStringProperty(jobtittle);
        this.phonenumber = new SimpleStringProperty(phonenumber);
        this.address = new SimpleStringProperty(address);
        this.sex = new SimpleStringProperty(sex);
    }

    public String getId() {
        return id.get();
    }

    public String getFirstname() {
        return firstname.get();
    }

    public String getLastname() {
        return lastname.get();
    }

    public String getJobtittle() {
        return jobtittle.get();
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getSex() {
        return sex.get();
    }
    
    
}

