/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import model.entity.Cart;

/**
 *
 * @author ghazallah
 */
public interface CartDAO {

    public void create(Cart cart);

    public void delete(Cart cart);

    public void update(Cart cart);

}
