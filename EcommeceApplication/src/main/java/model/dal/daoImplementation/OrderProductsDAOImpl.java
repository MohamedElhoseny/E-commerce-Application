/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import model.dal.dao.OrderProductsDAO;
import model.entity.OrderHasProducts;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ghazallah
 */
public class OrderProductsDAOImpl implements OrderProductsDAO {

    @Override
    public void create(OrderHasProducts orderProducts) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(orderProducts);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public OrderHasProducts retrieve(int id) {
        OrderHasProducts orderProducts = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            orderProducts = session.get(OrderHasProducts.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return orderProducts;
    }

    @Override
    public void update(OrderHasProducts orderProducts) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(orderProducts);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(OrderHasProducts orderProducts) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(orderProducts);
            session.getTransaction().commit();
            session.close();
        }
    }

}
