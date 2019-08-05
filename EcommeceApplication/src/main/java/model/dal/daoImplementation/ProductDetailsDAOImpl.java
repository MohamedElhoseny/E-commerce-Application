/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.dal.dao.ProductDetailsDAO;
import model.entity.Category;
import model.entity.Product;
import model.entity.ProductDetails;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ghazallah
 */
public class ProductDetailsDAOImpl implements ProductDetailsDAO{

    @Override
    public void create(ProductDetails productDetails) {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(productDetails);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public void update(ProductDetails productDetails) {
        
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(productDetails);
            session.getTransaction().commit();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ProductDetails retrieve(int id) {
         ProductDetails productDetails = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            productDetails = session.get(ProductDetails.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return productDetails;
    }

    @Override
    public void delete(ProductDetails productDetails) {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(productDetails);
            session.getTransaction().commit();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<ProductDetails> retreiveAllProductDetails()
    {
        List<ProductDetails> productList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductDetails> query = builder.createQuery(ProductDetails.class);
            Root<ProductDetails> root = query.from(ProductDetails.class);
            query.select(root);
            Query<ProductDetails> q = session.createQuery(query);
            productList = q.getResultList();
            session.getTransaction().commit();
            session.close();
        }

        return productList;
    }
}
