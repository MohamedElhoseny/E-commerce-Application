/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Elhoseni
 */
public class BrandDTO {
     private int id;
     private String name;
     private CategoryDTO categoryDTO;

     public BrandDTO(){}
     
    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
