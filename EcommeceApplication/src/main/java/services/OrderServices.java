/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.UniqueExceptionEmplementation;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dal.dao.CartDAO;
import model.dal.dao.OrderDAO;
import model.dal.dao.OrderProductsDAO;
import model.dal.dao.ProductDAO;
import model.dal.dao.UserCreditDAO;
import model.dal.dao.UserDAO;
import model.dal.daoFactory.DAOFactory;
import model.dal.daoFactory.HibernateDAOFactory;
import model.dal.daoImplementation.OrderDAOImpl;
import model.dal.daoImplementation.UserDAOImpl;
import model.dto.OrderDTO;
import model.dto.OrderProductDTO;
import model.dto.OrderValidationDTO;
import model.entity.Cart;
import model.entity.CartId;
import model.entity.Order;
import model.entity.OrderHasProducts;
import model.entity.OrderHasProductsId;
import model.entity.Product;
import model.entity.User;
import model.entity.UserCredit;

/**
 *
 * @author ghazallah
 */
public class OrderServices {

    DAOFactory dAOFactory = new HibernateDAOFactory();
    ProductDAO productDAO = dAOFactory.getProductDAO();
    OrderDAO orderDAO = new OrderDAOImpl();
    UserDAO userDAO = dAOFactory.getUserDAO();
    OrderProductsDAO orderProductDAO = dAOFactory.getOrderProductsDAO();
    UserCreditDAO userCreditDAO = dAOFactory.getUserCreditDAO();
    CartDAO cartDAO = dAOFactory.getCartDAO();

    public int getNewOrders() {
        return orderDAO.getNewOrders();
    }

    public void checkoutOrder(User user, Set<Cart> cartElements) {
        int wallet = user.getUserCredit().getWallet();
        double totalPrice = 0.0;
        List<Product> products = null;

        //check all elements quantities
        cartElements.forEach(element -> {
            //products.add(productDAO.retreive(element.getProduct().getPid()));
            Product product = productDAO.retreive(element.getProduct().getPid());
            if (element.getQuantity() > product.getQuantity()) {

            }
        });

    }

    public OrderValidationDTO validateOrderQuantity(OrderValidationDTO validationInput, User user) {
        double totalAmount = 0.0;
        double discount = 0.0;

        for (OrderProductDTO element : validationInput.getOrderProducts()) {
            System.out.println("checked !!");
            Product product = productDAO.retreive(element.getPid());
            if (element.getQuantity() > product.getQuantity()) {
                
                element.setAvailable(product.getQuantity());
                element.setValid(false);
            } else {
                element.setValid(true);
                totalAmount += product.getPrice() * element.getQuantity();
            }

        }
        if (totalAmount > user.getUserCredit().getWallet()) {
            validationInput.setSufficient(false);
        } else {
            validationInput.setSufficient(true);
        }

        return validationInput;
    }

    
    public int addNewOrder(OrderDTO orderDTO, User user) {
        int orderID = -1;
        int totalPrice = 0;
        
        // fill the order information
        Order order = new Order();
        order.setFullName(orderDTO.getFname() + " " + orderDTO.getLname());
        order.setCity(orderDTO.getCity());
        order.setCountry(orderDTO.getCountry());
        order.setPhoneNumber(orderDTO.getPhone());
        order.setPostcode(orderDTO.getPostalcode());
        Date date = new Date();
        order.setDate(date);
        order.setUser(user);
        order.setStreet(orderDTO.getAddress());
        orderID =orderDAO.create(order);
       // Order createdOrder = orderDAO.retreiveByDate(date);  //null pointer here
       

        // update product quantities
        // set products in the order
         
        for (OrderProductDTO element : orderDTO.getProducts()) {
            Product product = productDAO.retreive(element.getPid());
            product.setQuantity(product.getQuantity() - element.getQuantity());
            totalPrice += product.getPrice() * element.getQuantity();
            CartId cartId = new CartId(user.getId(), product.getPid());
            Cart cart = new Cart(cartId, product, user);
            cartDAO.delete(cart);
            try {
                productDAO.update(product);
            } catch (UniqueExceptionEmplementation ex) {
                Logger.getLogger(OrderServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            OrderHasProducts orderProducts = new OrderHasProducts();
            OrderHasProductsId orderHasProductsId = new OrderHasProductsId(orderID, product.getPid());
            orderProducts.setId(orderHasProductsId);
            orderProducts.setQuantity(element.getQuantity());
            orderProductDAO.create(orderProducts);
        }

        // reduce the wallet of the 
        order.setId(orderID);
        order.setTotalPrice(totalPrice);
        orderDAO.update(order);
        UserCredit userCredit = user.getUserCredit();
        userCredit.setWallet(userCredit.getWallet() - totalPrice);
        userCreditDAO.update(userCredit);

        return orderID;

    }

    //start Ahmed Abdelkarim
    
    
    public List<Order> getUsersPagenation(int currentPage,int recordsPerPage){
        return orderDAO.getOrdersPagenation(currentPage,recordsPerPage);
    }
    
    public int getNumberOfRows(){
        return orderDAO.getNumberOfRows();
    }
    
    public int getNewOrdersWeek() {
        return orderDAO.getNewOrdersWeek();
    }
    
    
    
    
     // end 
    //Ghazalla
    /*
    
    
    
    
    
    
    
    
     */
}
