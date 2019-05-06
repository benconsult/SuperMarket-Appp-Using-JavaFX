/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;

import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author Rebecca
 */
public class Supplier {
    SimpleStringProperty id,firstname,lastname,companyname,email,phonenumber,address;
   private Image photo;

    public Supplier(String id, String firstname, String lastname, String companyname, String email, String phonenumber, String address) {
        this.id = new SimpleStringProperty (id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname =  new SimpleStringProperty(lastname);
        this.companyname = new SimpleStringProperty(companyname);
        this.email = new SimpleStringProperty(email);
        this.phonenumber = new SimpleStringProperty(phonenumber);
        this.address = new SimpleStringProperty(address);
        
        photo = new Image("default.jpg");
    }
    public Supplier(String id, String firstname, String lastname, String companyname, String email, String phonenumber, String address,Image photo) {
        this.id = new SimpleStringProperty (id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname =  new SimpleStringProperty(lastname);
        this.companyname = new SimpleStringProperty(companyname);
        this.email = new SimpleStringProperty(email);
        this.phonenumber = new SimpleStringProperty(phonenumber);
        this.address = new SimpleStringProperty(address);
        this.photo=photo;
        
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname = new SimpleStringProperty(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname = new SimpleStringProperty(lastname);
    }

    public String getCompanyname() {
        return companyname.get();
    }

    public void setCompanyname(String companyname) {
        this.companyname = new SimpleStringProperty(companyname);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = new SimpleStringProperty(phonenumber);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public Image getImage() {
        return photo;
    }

    public void setImage(Image photo) {
        this.photo = photo;
    }
    
          
    
    
}
