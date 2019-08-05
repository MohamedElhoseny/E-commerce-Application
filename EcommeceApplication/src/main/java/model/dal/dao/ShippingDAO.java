/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import model.entity.Shipping;

/**
 *
 * @author ghazallah
 */
public interface ShippingDAO {

    public void create(Shipping shipping);

    public Shipping retrieve();

    public void update(Shipping shipping);

    public void delete(Shipping shipping);

}
