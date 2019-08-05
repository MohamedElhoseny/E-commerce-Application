/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Azza
 */
public class CouponDTO {
    private int id;
    private String cdiscount;
    private String description;
    private String discount;

    public CouponDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCdiscount(String cdiscount) {
        this.cdiscount = cdiscount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getCdiscount() {
        return cdiscount;
    }

    public String getDescription() {
        return description;
    }

    public String getDiscount() {
        return discount;
    }
}
