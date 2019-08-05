/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.dal.dao.ProductDAO;
import model.dal.dao.UserDAO;
import model.dal.daoImplementation.ProductDAOImpl;
import model.dal.daoImplementation.UserDAOImpl;
import model.entity.Product;
import model.entity.User;

/**
 *
 * @author pc
 */
public class ProductSearchService {

    ProductDAO productDAO = new ProductDAOImpl();
    
    public List<Product> getProductSearch(int currentPage, int recordsPerPage,String searchTxt) {
        return productDAO.getProductSearch(currentPage, recordsPerPage, searchTxt);
    }

    public int getNumberOfRowsProductSearch(String searchTxt) {
        return productDAO.getNumberOfRowsProductSearch(searchTxt);
    }
}
