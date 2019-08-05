/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import java.util.List;
import model.entity.ProductDetails;

/**
 *
 * @author ghazallah
 */
public interface ProductDetailsDAO {
    
    public void create (ProductDetails productDetails);
    
    public void update (ProductDetails productDetails);
    
    public ProductDetails retrieve (int id);
    
    public void delete  (ProductDetails productDetails);
    
    public List<ProductDetails> retreiveAllProductDetails();
    
}
