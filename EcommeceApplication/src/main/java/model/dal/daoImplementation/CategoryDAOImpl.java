/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import model.dal.dao.CategoryDAO;
import model.entity.Category;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ghazallah
 */
public class CategoryDAOImpl implements CategoryDAO {

    @Override
    synchronized public void create(Category category) throws UniqueExceptionEmplementation {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            throw new UniqueExceptionEmplementation("duplicated name");
        }

    }

    @Override
    public List<Category> retreive() {
        //modify code (this code just for testing) 
        List<Category> categoryList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Category.class);
            categoryList = criteria.list();
            
            session.close();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return categoryList;
    }

    @Override
    synchronized public void update(Category category) throws UniqueExceptionEmplementation {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
//            session.close();
        } catch (PersistenceException ex) {
            throw new UniqueExceptionEmplementation("duplicated name");
        }

    }

    @Override
    synchronized public void delete(Category category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
//            session.close();
        } catch (PersistenceException ex) {
//                throw new UniqueExceptionEmplementation("duplicated name");
            ex.printStackTrace();
        }
    }

    @Override
    public Category getCategory(int id) {
        Category category = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            category = session.get(Category.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return category;
    }

}
