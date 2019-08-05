/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import java.util.Date;
import java.util.List;
import model.entity.Order;
import model.entity.Product;

/**
 *
 * @author ghazallah
 */
public interface OrderDAO {

    public int create(Order order);

    public List<Order> retreive();

    public int getNewOrders();

    public void update(Order order);

    public void delete(Order order);

    public Order retreiveByDate(Date date);

    public int getNumberOfRows();

    public List<Order> getOrdersPagenation(int currentPage, int recordsPerPage);

    public int getNumberOfRowsOrderSearch(String productSearch);

    public List<Order> getOrderSearch(int currentPage, int recordsPerPage, String productSearch);

    public int getNewOrdersWeek();

}
