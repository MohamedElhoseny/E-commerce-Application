/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import exceptions.UniqueExceptionEmplementation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import model.dal.dao.ProductDAO;
import model.entity.Brand;
import model.entity.Product;
import model.entity.ProductDetails;
import model.entity.User;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author ghazallah
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    synchronized public void create(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(product);

            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Product retreive(int id) {
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    synchronized public void update(Product product) throws UniqueExceptionEmplementation {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
//            session.close();
        } catch (PersistenceException ex) {
            throw new UniqueExceptionEmplementation("duplicated name");
        }
    }

    @Override
    synchronized public void delete(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            //session.close();
        } catch (PersistenceException ex) {
//                throw new UniqueExceptionEmplementation("duplicated name");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Product> retreiveAllProducts() {
        List<Product> productList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);
            Query<Product> q = session.createQuery(query);
            productList = q.getResultList();
            session.getTransaction().commit();
            session.close();
        }

        return productList;
    }

    @Override
    public int getProductNumberOfRows() {

        Integer numOfRows = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);
            Query<Product> q = session.createQuery(query);
            numOfRows = q.list().size();
            System.out.println(numOfRows);
//            session.getTransaction().commit();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return numOfRows;

//        Integer numOfRows = 0;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Product.class);
//        numOfRows = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        return numOfRows;
    }

    @Override
    public List<Product> getProductsPagenation(int currentPage, int recordsPerPage) {

        List<Product> productList;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);
            Query<Product> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            productList = q.getResultList();
//            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return productList;

//        List<Product> products = null;
//
//        int start = currentPage * recordsPerPage - recordsPerPage;
//
////        try {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Product.class);
//        criteria.setFirstResult(start);
//        criteria.setMaxResults(recordsPerPage);
//        products = criteria.list();
//
//        return products;
    }

    @Override
    public void decreaseQuantity(int productID, int quantity) {

    }

    @Override
    public int getNumberOfRowsProductSearch(String productSearch) {

        Integer numOfRows = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            Path<String> name = root.get("name");
            query.select(root).where(builder.like(root.get("name").as(String.class), "%" + productSearch + "%"));
            Query<Product> q = session.createQuery(query);
            numOfRows = q.list().size();
            System.out.println(numOfRows);
//            session.getTransaction().commit();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return numOfRows;

//        Integer numOfRows = 0;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Product.class);
//        Criterion nameCriteria = Restrictions.like("name", productSearch, MatchMode.ANYWHERE);
//        criteria.add(nameCriteria);
//        numOfRows = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        return numOfRows;
    }

    @Override
    public List<Product> getProductSearch(int currentPage, int recordsPerPage, String productSearch) {

        List<Product> productList;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = builder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            Path<String> name = root.get("name");

            query.select(root).where(builder.like(root.get("name").as(String.class), "%" + productSearch + "%"));
            Query<Product> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            productList = q.getResultList();
//            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return productList;
//        
//        List<Product> products = null;
//        int start = currentPage * recordsPerPage - recordsPerPage;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(Product.class);
//        Criterion nameCriteria = Restrictions.like("name", productSearch, MatchMode.ANYWHERE);
//        criteria.add(nameCriteria);
//        criteria.setFirstResult(start);
//        criteria.setMaxResults(recordsPerPage);
//        products = criteria.list();
//        return products;
    }

    @Override
    public int getNewProducts() {
        // we need to add date column in database for user table
        int productCount = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select la from Product la where la.date > :date");
            query.setParameter("date", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
            productCount = query.list().size();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return productCount;
    }

    /*
    azza
     */
    @Override
    public List<Product> search(String input) {
        //SessionFactory sessionFactory = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        // session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);
        Criterion rest1 = Restrictions.like("name", input, MatchMode.ANYWHERE);
        criteria.add(rest1);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List acountList = criteria.list();
        return acountList;
    }

    @Override
    public List<Product> filter(String price, String color, int brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.and(Restrictions.like(
                "productColor", color, MatchMode.ANYWHERE), (Restrictions.like(
                        "brandID", brand)), Restrictions.like("price", price, MatchMode.ANYWHERE)));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List acountList = criteria.list();
        return acountList;
    }
}
