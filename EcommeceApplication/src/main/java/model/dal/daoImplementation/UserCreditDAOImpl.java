/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import model.dal.dao.UserCreditDAO;
import model.entity.UserCredit;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ghazallah
 */
public class UserCreditDAOImpl implements UserCreditDAO {

    @Override
    public void create(UserCredit userCredit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(userCredit);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void delete(UserCredit userCredit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(userCredit);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void update(UserCredit userCredit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(userCredit);
            session.getTransaction().commit();
            session.close();
        }
    }

}
