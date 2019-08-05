/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import exceptions.UniqueExceptionEmplementation;
import java.util.List;
import model.entity.Brand;
import model.entity.Category;

/**
 *
 * @author ghazallah
 */
public interface BrandDAO {

    public void create(Brand brand) throws UniqueExceptionEmplementation;

    public List<Brand> retreive();

    public void update(Brand brand)throws UniqueExceptionEmplementation;

    public void delete(Brand brand);
    
    public Brand getBrand(int id);

}
