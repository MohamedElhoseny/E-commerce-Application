package model.entity;
// Generated Mar 30, 2019, 4:19:02 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CartId generated by hbm2java
 */
@Embeddable
public class CartId  implements java.io.Serializable {


     private int userId;
     private int productId;

    public CartId() {
    }

    public CartId(int userId, int productId) {
       this.userId = userId;
       this.productId = productId;
    }
   


    @Column(name="userID", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name="productID", nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CartId) ) return false;
		 CartId castOther = ( CartId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && (this.getProductId()==castOther.getProductId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + this.getProductId();
         return result;
   }   


}


