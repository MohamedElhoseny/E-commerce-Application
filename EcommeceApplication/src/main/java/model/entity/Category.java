package model.entity;
// Generated Mar 30, 2019, 4:19:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="ecommerce"
)
public class Category  implements java.io.Serializable {


     private int id;
     private String name;
     private Set<Brand> brands = new HashSet<Brand>(0);

    public Category() {
    }

	
    public Category(int id) {
        this.id = id;
    }
    public Category(int id, String name, Set<Brand> brands) {
       this.id = id;
       this.name = name;
       this.brands = brands;
    }
   
     @Id 

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
  
    @Column(name="name", unique=true, nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="category" ,cascade = {CascadeType.ALL})
    public Set<Brand> getBrands() {
        return this.brands;
    }
    
    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }




}


