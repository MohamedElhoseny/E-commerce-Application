/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.List;

/**
 *
 * @author ghazallah
 */
public class OrderValidationDTO {

    List<OrderProductDTO> products;
    boolean sufficient;

    public OrderValidationDTO(List<OrderProductDTO> products, boolean sufficient) {
        this.products = products;
        this.sufficient = sufficient;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return products;
    }

    public void setOrderProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    public boolean isSufficient() {
        return sufficient;
    }

    public void setSufficient(boolean sufficient) {
        this.sufficient = sufficient;
    }
    

}
