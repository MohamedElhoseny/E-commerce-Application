/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal.dao;

import model.entity.UserCredit;

/**
 *
 * @author ghazallah
 */
public interface UserCreditDAO {

    public void create(UserCredit userCredit);

    public void update(UserCredit userCredit);

    public void delete(UserCredit userCredit);

}
