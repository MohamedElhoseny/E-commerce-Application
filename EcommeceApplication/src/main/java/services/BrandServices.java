/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import model.dal.dao.BrandDAO;
import model.dal.dao.CategoryDAO;
import model.dal.daoFactory.HibernateDAOFactory;
import model.entity.Brand;
import model.entity.Category;

/**
 *
 * @author ghazallah
 */
public class BrandServices {
    BrandDAO brandDAO = new HibernateDAOFactory().getBrandDAO();
    CategoryDAO categoryDAO = new HibernateDAOFactory().getCategoryDAO();

    public void setCategoryName(String brandName,int categoryId) throws UniqueExceptionEmplementation {
        Category category = categoryDAO.getCategory(categoryId);
        Brand brand = new Brand();
        brand.setCategory(category);
        brand.setName(brandName);
        brandDAO.create(brand);
    }

    public List<Brand> getAllBrands() {
        List<Brand> brandList = brandDAO.retreive();
        return brandList;
    }

    public void updateCategoryName(int brandId,String brandName,int ctegoryId) throws UniqueExceptionEmplementation {
        Category category = categoryDAO.getCategory(ctegoryId);
        Brand brand = brandDAO.getBrand(brandId);
        brand.setCategory(category);
        brand.setName(brandName);
        brandDAO.update(brand);
    }

    public void deleteCategory(int id) throws UniqueExceptionEmplementation {
        Brand brand = brandDAO.getBrand(id);
        brandDAO.delete(brand);
    }
}
