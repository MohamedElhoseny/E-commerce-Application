/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import javax.persistence.PersistenceException;
import model.dal.dao.CartDAO;
import model.entity.Cart;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ghazallah
 */
public class CartDAOImpl implements CartDAO {

    @Override
    public void create(Cart cart) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cart);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();   
        }
    }

    @Override
    public void delete(Cart cart) {
          try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(cart);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();   
        }
    }

    @Override
    public void update(Cart cart) {
          try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(cart);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();   
        }
    }

}
