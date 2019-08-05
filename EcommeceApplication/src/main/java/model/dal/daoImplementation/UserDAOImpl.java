/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import model.dal.dao.UserDAO;
import model.entity.Category;
import model.entity.User;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author ghazallah
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void create(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public User retrieve(String email) {
        User user;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root).where(builder.equal(root.get("email"), email));
            Query<User> q = session.createQuery(query);
            user = q.uniqueResult();
            session.getTransaction().commit();
            session.close();
        }

        return user;
    }

    @Override
    public void update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<User> retrieveAllUsers() {

        List<User> userList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root);
            Query<User> q = session.createQuery(query);
            userList = q.getResultList();
            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
//        for (int i = 0; i < userList.size(); i++) {
//            System.out.println(userList.get(i).getAddress());
//            System.out.println(userList.get(i).getName());
//        }

        return userList;
    }

    @Override
    public int getNewUsers() {
        // we need to add date column in database for user table
        int userCount = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select la from User la where la.registerationDate > :date");
            query.setParameter("date", new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
            userCount = query.list().size();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return userCount;
    }

    @Override
    public int getNumberOfRows() {

        Integer numOfRows = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root);
            Query<User> q = session.createQuery(query);
            numOfRows = q.list().size();
            System.out.println(numOfRows);
            session.getTransaction().commit();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return numOfRows;

//        Integer numOfRows = 0;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(User.class);
//        numOfRows = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        return numOfRows;
    }

    @Override
    public List<User> getUsersPagenation(int currentPage, int recordsPerPage) {

        List<User> userList;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            query.select(root);
            Query<User> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            userList = q.getResultList();
            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }

        return userList;

//        List<User> users = null;
//
//        int start = currentPage * recordsPerPage - recordsPerPage;
//
////        try {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.setFirstResult(start);
//        criteria.setMaxResults(recordsPerPage);
//        users = criteria.list();
//
//        return users;
    }

    @Override
    public int getNumberOfRowsSearch(String searchTxt, String phoneTxt) {

        Integer numOfRows = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            Path<String> name = root.get("name");
            Path<String> phone = root.get("phone");
            query.select(root).where(builder.and(builder.like(root.get("name").as(String.class), "%" + searchTxt + "%"), builder.like(root.get("phone").as(String.class), "%" + phoneTxt + "%")));
            Query<User> q = session.createQuery(query);
            numOfRows = q.list().size();
            System.out.println(numOfRows);
            session.getTransaction().commit();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return numOfRows;

//        Integer numOfRows = 0;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.and(Restrictions.like(
//                "name", searchTxt, MatchMode.ANYWHERE), (Restrictions.like(
//                        "phone", phoneTxt, MatchMode.ANYWHERE))));
//
//        numOfRows = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//        return numOfRows;
    }

    @Override
    public List<User> getUserSearch(int currentPage, int recordsPerPage, String searchTxt, String phoneTxt) {

        List<User> userList;
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            Path<String> name = root.get("name");
            Path<String> phone = root.get("phone");

            query.select(root).where(builder.and(builder.like(root.get("name").as(String.class), "%" + searchTxt + "%"), builder.like(root.get("phone").as(String.class), "%" + phoneTxt + "%")));
            Query<User> q = session.createQuery(query);
            q.setFirstResult(start);
            q.setMaxResults(recordsPerPage);
            userList = q.getResultList();
            session.getTransaction().commit();
            //session.close();
            System.out.println("donnnnnnnnnnnnnnnnnne");
        }
        return userList;
//        List<User> users = null;
//        int start = currentPage * recordsPerPage - recordsPerPage;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.and(Restrictions.like(
//                "name", searchTxt, MatchMode.ANYWHERE), (Restrictions.like(
//                        "phone", phoneTxt, MatchMode.ANYWHERE))));
//        criteria.setFirstResult(start);
//        criteria.setMaxResults(recordsPerPage);
//        users = criteria.list();
//        return users;
    }
}
