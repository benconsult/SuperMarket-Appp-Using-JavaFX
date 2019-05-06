/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Rebecca
 */
public class Product {
    SimpleStringProperty  id;
    SimpleStringProperty  batchname;
    SimpleStringProperty  productname;
    SimpleStringProperty  quantity;
    SimpleStringProperty  costprice;
    SimpleStringProperty  sellingprice;

    public Product(String id, String batchname, String productname, String quantity, String costprice, String sellingprice) {
        this.id = new SimpleStringProperty(id); 
        this.batchname = new SimpleStringProperty (batchname);
        this.productname = new SimpleStringProperty (productname);
        this.quantity = new SimpleStringProperty (quantity);
        this.costprice = new SimpleStringProperty (costprice);
        this.sellingprice = new SimpleStringProperty (sellingprice);
    }

    public String getId() {
        return id.get();
    }

    public String getBatchname() {
        return batchname.get();
    }

    public String getProductname() {
        return productname.get();
    }

    public String getQuantity() {
        return quantity.get();
    }

    public String getCostprice() {
        return costprice.get();
    }

    public String getSellingprice() {
        return sellingprice.get();
    }
    
}
