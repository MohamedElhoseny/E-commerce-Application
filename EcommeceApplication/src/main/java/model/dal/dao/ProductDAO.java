/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import model.entity.Product;
import model.entity.User;

/**
 *
 * @author ghazallah
 */
public interface ProductDAO {

    public void create(Product product) throws UniqueExceptionEmplementation;

 

    public Product retreive(int id);

    public void update(Product product) throws UniqueExceptionEmplementation;

    public void delete(Product product);

    public List<Product> retreiveAllProducts();

    public int getProductNumberOfRows();

    public List<Product> getProductsPagenation(int currentPage, int recordsPerPage);

    public void decreaseQuantity(int productID, int quantity);

    public int getNumberOfRowsProductSearch(String productSearch);

    public List<Product> getProductSearch(int currentPage, int recordsPerPage, String productSearch);

    public int getNewProducts();
    /*
    azza
    */
    public List<Product> search(String inptut);
    public List<Product> filter(String price,String color,int brand);

}
