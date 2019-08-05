/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import model.dal.dao.OrderDAO;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

/**
 *
 * @author ghazallah
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public int create(Order order) {
        Order createdOrder = null;
        int id = -1;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            id = (int) session.save(order);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            try {
                throw new UniqueExceptionEmplementation("duplicated name");
            } catch (UniqueExceptionEmplementation ex1) {
                Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return id;
    }

    @Override
    public List<Order> retreive() {
//        //modify code (this code just for testing) 
//        List<Order> orderList = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Criteria criteria = session.createCriteria(Order.class);
//            orderList = criteria.list();
////            session.close();
//        } catch (HibernateException ex) {
//            //exceptions in server 
//            ex.printStackTrace();
//        }
//        return orderList;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void update(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            try {
                throw new UniqueExceptionEmplementation("duplicated name");
            } catch (UniqueExceptionEmplementation ex1) {
                Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void delete(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            try {
                throw new UniqueExceptionEmplementation("duplicated name");
            } catch (UniqueExceptionEmplementation ex1) {
                Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public int getNewOrders() {
        //modify code (this code just for testing) 
        int orderCount = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Criteria criteria = session.createCriteria(Order.class);
//            orderCount = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

            Query query = session.createQuery("select la from Order la where la.date > :date");
            query.setParameter("date", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
            orderCount = query.list().size();

        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return orderCount;
    }

    @Override
    public Order retreiveByDate(Date date) {
        Order order;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            System.out.println("date in hibernate" + date);
            query.select(root).where(builder.equal(root.get("date"), date));
            Query<Order> q = session.createQuery(query);
            order = q.getSingleResult();
            session.getTransaction().commit();
            //session.close();
        }

        return order;
    }

    @Override
    public List<Order> getOrdersPagenation(int currentPage, int recordsPerPage) {
        List<Order> orders;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            query.select(root);
            Query<Order> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            orders = q.getResultList();
        }
        return orders;
    }

    @Override
    public int getNumberOfRows() {
        Integer numOfRows = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Order.class);
        numOfRows = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        return numOfRows;
    }

    @Override
    public int getNumberOfRowsOrderSearch(String productSearch) {
        Integer numOfRows = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            Path<String> city = root.get("city");
            query.select(root).where(builder.like(root.get("city").as(String.class), "%" + productSearch + "%"));
            Query<Order> q = session.createQuery(query);
            numOfRows = q.list().size();
            System.out.println(numOfRows);
//            session.getTransaction().commit();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return numOfRows;
    }

    @Override
    public List<Order> getOrderSearch(int currentPage, int recordsPerPage, String productSearch) {
        List<Order> productList;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = builder.createQuery(Order.class);
            Root<Order> root = query.from(Order.class);
            Path<String> city = root.get("city");

            query.select(root).where(builder.like(root.get("city").as(String.class), "%" + productSearch + "%"));
            Query<Order> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            productList = q.getResultList();
//            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");

        }
        return productList;
    }
    
    @Override
    public int getNewOrdersWeek() {
        int orderCount = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select la from Order la where la.date > :date");
            query.setParameter("date", new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000));
            orderCount = query.list().size();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return orderCount;
    }
}
