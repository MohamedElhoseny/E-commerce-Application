/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.dal.dao.UserDAO;
import model.dal.daoImplementation.UserDAOImpl;
import model.entity.User;

/**
 *
 * @author pc
 */
public class SearchService {

    UserDAO userDAO = new UserDAOImpl();
    
    public List<User> getUserSearch(int currentPage, int recordsPerPage,String searchTxt,String phoneTxt) {
        return userDAO.getUserSearch(currentPage, recordsPerPage, searchTxt,phoneTxt);
    }

    public int getNumberOfRowsSearch(String searchTxt,String phoneTxt) {
        return userDAO.getNumberOfRowsSearch(searchTxt,phoneTxt);
    }
}
