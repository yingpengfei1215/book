/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.controller.form;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: UserInfoForm.java; v 0.1 2017-06-04 17:30 pengfei.ypf Exp $$
 */
public class BookInfoForm {

    /**
     * id
     */
    Integer id;

    private Integer deposit;

    private Integer cost;

    private String userWay;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>deposit</tt>.
     *
     * @return property value of deposit
     */
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * Setter method for property <tt>deposit</tt>.
     *
     * @param deposit value to be assigned to property deposit
     */
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * Getter method for property <tt>cost</tt>.
     *
     * @return property value of cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Setter method for property <tt>cost</tt>.
     *
     * @param cost value to be assigned to property cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * Getter method for property <tt>userWay</tt>.
     *
     * @return property value of userWay
     */
    public String getUserWay() {
        return userWay;
    }

    /**
     * Setter method for property <tt>userWay</tt>.
     *
     * @param userWay value to be assigned to property userWay
     */
    public void setUserWay(String userWay) {
        this.userWay = userWay;
    }
}
