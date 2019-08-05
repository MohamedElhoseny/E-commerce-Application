package model.entity;
// Generated Mar 30, 2019, 4:19:02 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="\"user\""
    ,catalog="ecommerce"
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String email;
     private String gender;
     private Date birthday;
     private String address;
     private String phone;
     private String picture;
     private String password;
     private Integer role;
     private Date registerationDate;
     private Set<Cart> carts = new HashSet<>(0);
     private UserCredit userCredit;
     private Set<Product> products = new HashSet<>(0);
     private Set<Order> orders = new HashSet<>(0);
     private Set<Coupon> coupons = new HashSet<>(0);

    public User() {
    }

	
    public User(String name, String email, String phone, String picture, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.picture = picture;
        this.password = password;
    }
    public User(String name, String email, String gender, Date birthday, String address, String phone, String picture, String password, Integer role, Set<Cart> carts, UserCredit userCredit, Set<Product> products, Set<Order> orders, Set<Coupon> coupons) {
       this.name = name;
       this.email = email;
       this.gender = gender;
       this.birthday = birthday;
       this.address = address;
       this.phone = phone;
       this.picture = picture;
       this.password = password;
       this.role = role;
       this.carts = carts;
       this.userCredit = userCredit;
       this.products = products;
       this.orders = orders;
       this.coupons = coupons;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="register_date")
    public Date getRegisterationDate() {
        return registerationDate;
    }

    public void setRegisterationDate(Date registerationDate) {
        this.registerationDate = registerationDate;
    }

    
    @Column(name="email",unique = true, nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="gender")
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birthday", length=10)
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
    @Column(name="address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="phone", nullable=false)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="picture", nullable=false)
    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="role")
    public Integer getRole() {
        return this.role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="user")
    public UserCredit getUserCredit() {
        return this.userCredit;
    }
    
    public void setUserCredit(UserCredit userCredit) {
        this.userCredit = userCredit;
    }

@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="wishlist", catalog="ecommerce", joinColumns = { 
        @JoinColumn(name="userID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="productID", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_has_coupon", catalog="ecommerce", joinColumns = { 
        @JoinColumn(name="userID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="couponID", nullable=false, updatable=false) })
    public Set<Coupon> getCoupons() {
        return this.coupons;
    }
    
    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }




}


