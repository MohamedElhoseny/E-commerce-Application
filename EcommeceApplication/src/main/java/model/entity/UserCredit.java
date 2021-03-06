package model.entity;
// Generated Mar 30, 2019, 4:19:02 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * UserCredit generated by hbm2java
 */
@Entity
@Table(name = "user_credit",
         catalog = "ecommerce"
)
public class UserCredit implements java.io.Serializable {

    private int id;
    private User user;
    private String creditcard;
    private Integer wallet;

    public UserCredit() {
    }

    public UserCredit(User user) {
        this.user = user;
    }

    public UserCredit(User user, String creditcard, Integer wallet) {
        this.user = user;
        this.creditcard = creditcard;
        this.wallet = wallet;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "generator")
    //@Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
   // @PrimaryKeyJoinColumn
    @JoinColumn(name = "userID")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "creditcard")
    public String getCreditcard() {
        return this.creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    @Column(name = "wallet")
    public Integer getWallet() {
        return this.wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

}
