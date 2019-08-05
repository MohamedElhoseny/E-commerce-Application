/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import exceptions.UniqueExceptionEmplementation;
import java.util.ArrayList;
import java.util.List;
import model.entity.Category;

/**
 *
 * @author ghazallah
 */
public interface CategoryDAO {

    public void create(Category category) throws UniqueExceptionEmplementation;

    public List<Category> retreive();

    public void update(Category category)throws UniqueExceptionEmplementation;

    public void delete(Category category);
    
    public Category getCategory(int id);

}
