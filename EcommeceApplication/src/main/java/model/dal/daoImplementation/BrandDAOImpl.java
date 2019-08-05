/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import javax.persistence.PersistenceException;
import model.dal.dao.BrandDAO;
import model.entity.Brand;
import model.entity.Category;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ghazallah
 */
public class BrandDAOImpl implements BrandDAO {

    @Override
    synchronized public void create(Brand brand) throws UniqueExceptionEmplementation {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(brand);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            throw new UniqueExceptionEmplementation("duplicated name");
        }
    }

    @Override
    public List<Brand> retreive() {
        //modify code (this code just for testing) 
        List<Brand> brandList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Brand.class);
            brandList = criteria.list();
           
            //session.close();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return brandList;
    }

    @Override
    synchronized public void update(Brand brand) throws UniqueExceptionEmplementation {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(brand);
            session.getTransaction().commit();
//            session.close();
        } catch (PersistenceException ex) {
            throw new UniqueExceptionEmplementation("duplicated name");
        }
    }

    @Override
    synchronized public void delete(Brand brand) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(brand);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
//                throw new UniqueExceptionEmplementation("duplicated name");
            ex.printStackTrace();
        }
    }

    @Override
    public Brand getBrand(int id) {
        Brand brand = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            brand = session.get(Brand.class, id);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return brand;
    }

}
