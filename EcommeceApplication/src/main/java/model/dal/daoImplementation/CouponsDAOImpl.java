/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.dal.dao.CouponsDAO;
import model.entity.Coupon;
import model.entity.Product;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ghazallah
 */
public class CouponsDAOImpl implements CouponsDAO {
    @Override
    public void create(Coupon coupon) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(coupon);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(Coupon coupon) {
    }

    @Override
    public void delete(Coupon coupon) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(coupon);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public Coupon retrieve(int id) {
        Coupon coupon = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            coupon = session.get(Coupon.class, id);

            session.getTransaction().commit();
        } catch (HibernateException ex) {
            //exceptions in server 
            ex.printStackTrace();
        }
        return coupon;
    }

    /*@Override
    public List<Coupon> getAllCoupons() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Coupon.class);
        //criteria.add(Restrictions.like("userName", word, MatchMode.ANYWHERE));
        List<Coupon> acountList = (List<Coupon>) criteria.list();
        return acountList;
    }*/
   /* @Override
    public List<Coupon> getAllCoupons() {
        List<Coupon> couponList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Coupon> query = builder.createQuery(Coupon.class);
            Root<Coupon> root = query.from(Coupon.class);
            query.select(root);
            Query<Coupon> q = session.createQuery(query);
            couponList = q.getResultList();
            session.getTransaction().commit();
            session.close();
        }
        return couponList;
    }*/

    @Override
    public List<Coupon> getAllCoupons() {
 List<Coupon> couponList;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Coupon> query = builder.createQuery(Coupon.class);
            Root<Coupon> root = query.from(Coupon.class);
            query.select(root);
            Query<Coupon> q = session.createQuery(query);
            couponList = q.getResultList();
            session.getTransaction().commit();
            session.close();
        }
        return couponList;    }
}
