/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.dal.dao.CouponsDAO;
import model.dal.daoFactory.DAOFactory;
import model.dal.daoFactory.HibernateDAOFactory;
import model.dto.CouponDTO;
import model.entity.Coupon;

/**
 *
 * @author ghazallah
 */
public class CouponServices {
    private DAOFactory dAOFactory = new HibernateDAOFactory();
    private CouponsDAO couponsDAO = dAOFactory.getCouponsDAO();
    
    public List<CouponDTO> getAllCoupons()
    {
         //Get all products from dataStore        
         List<Coupon> Coupons = couponsDAO.getAllCoupons();
         //Create dtos for those entity records 
         List<CouponDTO> couponDTOs = new ArrayList<>();
         //Wrapping entities into dtos
         for (Coupon coupon : Coupons) {   
             CouponDTO couponDTO = new CouponDTO();
             couponDTO.setId(coupon.getId());
             couponDTO.setDiscount(coupon.getDiscount());
             couponDTO.setDescription(coupon.getDescription());
             couponDTOs.add(couponDTO);
         }
         
         return  couponDTOs;
    }
}
