/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.daoImplementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dal.dao.StatisticsDAO;
import model.entity.Order;
import model.entity.User;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class StatisticsDaoImpl implements StatisticsDAO {

    @Override
    public int getNumbersOfNewUsers() {

        return 0;
    }

    @Override
    public int getNumbersOfNewOreders() {
        List<Order> numberOfOrdersToday = null ;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Order.class);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
            LocalDate localDate = LocalDate.now();
            String myDate = DateTimeFormatter.ofPattern("dd-MM-yyy").format(localDate);
            // Create date 17-04-2011 - 00h00
            Date minDate = formatter.parse(myDate);
            // Create date 18-04-2011 - 00h00
            // -> We take the 1st date and add it 1 day in millisecond thanks to a useful and not so known class
            Date maxDate = new Date(minDate.getTime() + TimeUnit.DAYS.toMillis(1));
            Conjunction and = Restrictions.conjunction();
            // The order date must be >= 17-04-2011 - 00h00
            and.add(Restrictions.ge("orderDate", minDate));
            // And the order date must be < 18-04-2011 - 00h00
            and.add(Restrictions.lt("orderDate", maxDate));
            
            criteria.add(and);
            numberOfOrdersToday = criteria.list();
            
            System.out.println(numberOfOrdersToday.size());
        } catch (ParseException ex) {
            Logger.getLogger(StatisticsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfOrdersToday.size();

    }

}
