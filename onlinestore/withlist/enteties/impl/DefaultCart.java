/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore.withlist.enteties.impl;


import java.util.ArrayList;
import java.util.List;
import onlinestore.withlist.enteties.Cart;
import onlinestore.withlist.enteties.Product;
public class DefaultCart implements Cart {

    private List<Product> products;
    
    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
                return;
        }
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void clear() {
        products.clear();
    }

}
