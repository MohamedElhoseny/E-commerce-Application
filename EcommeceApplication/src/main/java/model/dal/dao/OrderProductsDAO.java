/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import model.entity.OrderHasProducts;

/**
 *
 * @author ghazallah
 */
public interface OrderProductsDAO {

    public void create(OrderHasProducts orderProducts);

    public OrderHasProducts retrieve(int id);

    public void update(OrderHasProducts orderProducts);

    public void delete(OrderHasProducts orderProducts);

}
