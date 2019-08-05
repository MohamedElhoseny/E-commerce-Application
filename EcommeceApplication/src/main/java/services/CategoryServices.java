/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import model.dal.dao.CategoryDAO;
import model.dal.daoFactory.HibernateDAOFactory;
import model.entity.Category;

/**
 *
 * @author ghazallah
 */
public class CategoryServices {

    CategoryDAO categoryDAO = new HibernateDAOFactory().getCategoryDAO();

    public void setCategoryName(String categoryName) throws UniqueExceptionEmplementation {
        Category category = new Category();
        category.setName(categoryName);
        categoryDAO.create(category);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryDAO.retreive();
        return categoryList;
    }

    public void updateCategoryName(int id, String categoryName) throws UniqueExceptionEmplementation {
        Category category = categoryDAO.getCategory(id);
        category.setName(categoryName);
        categoryDAO.update(category);
    }

    public void deleteCategory(int id) throws UniqueExceptionEmplementation {
        Category category = categoryDAO.getCategory(id);
        categoryDAO.delete(category);
    }

}
