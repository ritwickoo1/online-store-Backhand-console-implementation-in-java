/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore.withlist.enteties;

import java.util.List;

public interface Order {

    boolean isCreditCardNumberValid(String userInput);
    void setCreditCardNumber(String userInput);
    void setProducts(List<Product> products);
    void setCustomerId(int customerId);
    int getCustomerId();

}