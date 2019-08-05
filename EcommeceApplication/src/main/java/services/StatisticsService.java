/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.dal.dao.StatisticsDAO;
import model.dal.daoImplementation.StatisticsDaoImpl;

/**
 *
 * @author pc
 */
public class StatisticsService {
    public int getNewOrders(){
        StatisticsDAO statisticsDAO = new StatisticsDaoImpl();
        return statisticsDAO.getNumbersOfNewOreders();
    }
}
