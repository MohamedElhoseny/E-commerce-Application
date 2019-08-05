/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import java.util.List;
import model.entity.User;

/**
 *
 * @author ghazallah
 */
public interface UserDAO {

    public void create(User user);

    public User retrieve(String email);

    public void update(User user);

    public void delete(User user);
    
    public List<User> retrieveAllUsers();
    
    public int getNewUsers();
    
    public int getNumberOfRows();
    
    public List<User> getUsersPagenation(int currentPage,int recordsPerPage);
    
     public int getNumberOfRowsSearch(String searchTxt,String phoneTxt);
    
    public List<User> getUserSearch(int currentPage,int recordsPerPage,String searchTxt,String phoneTxt);
    
    
}
