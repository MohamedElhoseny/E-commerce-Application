/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import java.util.List;
import model.entity.Coupon;

/**
 *
 * @author ghazallah
 */
public interface CouponsDAO {

    public void create(Coupon coupon);

    public Coupon retrieve(int id);

    public void update(Coupon coupon);

    public void delete(Coupon coupon);
    
    public List<Coupon> getAllCoupons();
}
