/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.dal.dao.OrderDAO;
import model.dal.dao.ProductDAO;
import model.dal.dao.UserDAO;
import model.dal.daoImplementation.OrderDAOImpl;
import model.dal.daoImplementation.ProductDAOImpl;
import model.dal.daoImplementation.UserDAOImpl;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;

/**
 *
 * @author pc
 */
public class OrderSearchService {

    OrderDAO orderDAO = new OrderDAOImpl();
    
    public List<Order> getOrderSearch(int currentPage, int recordsPerPage,String searchTxt) {
        return orderDAO.getOrderSearch(currentPage, recordsPerPage, searchTxt);
    }

    public int getNumberOfRowsOrderSearch(String searchTxt) {
        return orderDAO.getNumberOfRowsOrderSearch(searchTxt);
    }
}
