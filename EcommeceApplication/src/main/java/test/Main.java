/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exceptions.UniqueExceptionEmplementation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dal.dao.BrandDAO;
import model.dal.dao.CartDAO;
import model.dal.dao.CategoryDAO;
import model.dal.dao.OrderDAO;
import model.dal.dao.ProductDAO;
import model.dal.dao.ProductDetailsDAO;
import model.dal.dao.UserCreditDAO;
import model.dal.dao.UserDAO;
import model.dal.daoFactory.DAOFactory;
import model.dal.daoFactory.HibernateDAOFactory;
import model.dal.daoImplementation.BrandDAOImpl;
import model.dal.daoImplementation.CartDAOImpl;
import model.dal.daoImplementation.CategoryDAOImpl;
import model.dal.daoImplementation.OrderDAOImpl;
import model.dal.daoImplementation.ProductDAOImpl;
import model.dal.daoImplementation.ProductDetailsDAOImpl;
import model.dal.daoImplementation.UserCreditDAOImpl;
import model.dal.daoImplementation.UserDAOImpl;
import model.entity.Brand;
import model.entity.Cart;
import model.entity.CartId;
import model.entity.Category;
import model.entity.Order;
import model.entity.Product;
import model.entity.ProductDetails;
import model.entity.User;
import model.entity.UserCredit;
import model.util.HibernateUtil;
import org.hibernate.Session;
import services.ProductServices;

/**
 *
 * @author ghazallah
 */
public class Main {

    public static void main(String[] args) throws UniqueExceptionEmplementation {

        //   method();
        //  method();
        orderMethod();
    }

    private static void method() {

        User user = new User();
        user.setAddress("Cairo");
        user.setBirthday(new Date());
        user.setEmail("admin@gmail.com");
        user.setGender("male");
        user.setName("Admin");
        user.setRole(1);
        user.setPicture("pic");
        user.setPassword("admin");
        user.setPhone("01060707894");
//        User user = new User();
//        user.setAddress("Menoufia");
//        user.setBirthday(new Date());
//        user.setEmail("ghazallah64@gmail.com");
//        user.setGender("male");
//        user.setName("Mo");
//        user.setRole(1);
//        user.setPicture("pic");
//        user.setPassword("123");
//        user.setPhone("01000");
//
        UserDAO userDAO = new UserDAOImpl();
//        userDAO.create(user);

        ArrayList<User> allUsers = new ArrayList<>();
        allUsers = (ArrayList<User>) userDAO.getUsersPagenation(1, 10);
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println(allUsers.get(i).getEmail());
        }

//         UserDAO userDAO = new UserDAOImpl();
//         CartDAO cartDAO   =new CartDAOImpl();
//         CartId  id = new CartId(2, 2);
//         
//         Cart cart = new Cart  ();
//         cart.setId(id);
//         cartDAO.create(cart);z
    }

    private static void method2() {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.retrieve("m1@gmail.com");
        ProductDAO productDAO = new ProductDAOImpl();

        Product product = productDAO.retreive(3);
        Set<Product> products = user.getProducts();
        //  System.out.println(products.size());
        for (Product object : products) {
            if (object.getPid() == product.getPid()) {
                product = object;
            }
        }
        boolean value = products.remove(product);
        System.out.println(value);
        System.out.println(products.size());
        userDAO.update(user);

    }

    private static void orderMethod() {
        Order order = new Order();
        order.setFullName("Ghazallah");

        OrderDAO orderDAO = new OrderDAOImpl();
        int id = orderDAO.create(order);
        System.out.println(order.getId());
    }

}
