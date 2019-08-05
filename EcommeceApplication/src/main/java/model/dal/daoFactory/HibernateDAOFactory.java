/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoFactory;

import model.dal.dao.BrandDAO;
import model.dal.dao.CartDAO;
import model.dal.dao.CategoryDAO;
import model.dal.dao.CouponsDAO;
import model.dal.dao.OrderDAO;
import model.dal.dao.OrderProductsDAO;
import model.dal.dao.ProductDAO;
import model.dal.dao.ProductDetailsDAO;
import model.dal.dao.ShippingDAO;
import model.dal.dao.UserCreditDAO;
import model.dal.dao.UserDAO;
import model.dal.daoImplementation.BrandDAOImpl;
import model.dal.daoImplementation.CartDAOImpl;
import model.dal.daoImplementation.CategoryDAOImpl;
import model.dal.daoImplementation.CouponsDAOImpl;
import model.dal.daoImplementation.OrderDAOImpl;
import model.dal.daoImplementation.OrderProductsDAOImpl;
import model.dal.daoImplementation.ProductDAOImpl;
import model.dal.daoImplementation.ProductDetailsDAOImpl;
import model.dal.daoImplementation.ShippingDAOImpl;
import model.dal.daoImplementation.UserCreditDAOImpl;
import model.dal.daoImplementation.UserDAOImpl;

/**
 *
 * @author ghazallah
 */
public class HibernateDAOFactory implements DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryDAOImpl();
    }

    @Override
    public BrandDAO getBrandDAO() {
        return new BrandDAOImpl();
    }

    @Override
    public CouponsDAO getCouponsDAO() {
        return new CouponsDAOImpl();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOImpl();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAOImpl();
    }

    @Override
    public ShippingDAO getShippingDAO() {
        return new ShippingDAOImpl();
    }

    @Override
    public UserCreditDAO getUserCreditDAO() {
        
        return new UserCreditDAOImpl();
    }

    @Override
    public ProductDetailsDAO getProductDetailsDAO() {
        
        return new ProductDetailsDAOImpl();
    }

    @Override
    public CartDAO getCartDAO() {
        
        return new CartDAOImpl();
    }

    @Override
    public OrderProductsDAO getOrderProductsDAO() {
        return new  OrderProductsDAOImpl();
    }

}
