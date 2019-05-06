/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rebecca
 */
public class Inventory {
    StringProperty id;
     StringProperty batchname;
      StringProperty quantity;
       StringProperty price;
        StringProperty value;
         StringProperty isreturned;
          LocalDate date;

    public Inventory(String id, String batchname, String quantity, String price, String value, String isreturned, LocalDate date) {
        this.id =  new SimpleStringProperty(id);
        this.batchname =  new SimpleStringProperty(batchname);
        this.quantity =  new SimpleStringProperty(quantity);
        this.price =  new SimpleStringProperty(price);
        this.value =  new SimpleStringProperty(value);
        this.isreturned =  new SimpleStringProperty(isreturned);
        this.date= date;
        
    }

    public String getId() {
        return id.get();
    }

    public String getBatchname() {
        return batchname.get();
    }

    public String getQuantity() {
        return quantity.get();
    }

    public String getPrice() {
        return price.get();
    }

    public String getValue() {
        return value.get();
    }

    public String getIsreturned() {
        return isreturned.get();
    }

    public LocalDate getDate() {
        return date;
    }

   /* public void setId(String id) {
        this.id = id;
    }

    public void setBatchname(StringProperty batchname) {
        this.batchname = batchname;
    }

    public void setQuantity(StringProperty quantity) {
        this.quantity = quantity;
    }

    public void setPrice(StringProperty price) {
        this.price = price;
    }

    public void setValue(StringProperty value) {
        this.value = value;
    }

    public void setIsreturned(StringProperty isreturned) {
        this.isreturned = isreturned;
    }*/

    public void setDate(LocalDate date) {
        this.date = date;
    }
          
          
          
          
          
}
