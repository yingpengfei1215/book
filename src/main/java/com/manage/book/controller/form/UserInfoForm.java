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
public class UserInfoForm {

    /**
     * id
     */
    Integer id;

    /**
     * id
     */
    Integer openid;

    /**
     * id
     */
    String userName;
    /**
     * id
     */
    String phoneNo;
    /**
     * id
     */
    String userEmail;
    /**
     * id
     */
    String sex;

    /**
     * id
     */
    Integer userAddress;

    /**
     * id
     */
    String provinceCode;
    /**
     * id
     */
    String cityCode;
    /**
     * id
     */
    String areaCode;
    /**
     * id
     */
    String address;
    /**
     * id
     */
    String preferenceType;

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
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>phoneNo</tt>.
     *
     * @return property value of phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Setter method for property <tt>phoneNo</tt>.
     *
     * @param phoneNo value to be assigned to property phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Getter method for property <tt>userEmail</tt>.
     *
     * @return property value of userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Setter method for property <tt>userEmail</tt>.
     *
     * @param userEmail value to be assigned to property userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Getter method for property <tt>sex</tt>.
     *
     * @return property value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for property <tt>sex</tt>.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property <tt>provinceCode</tt>.
     *
     * @return property value of provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * Setter method for property <tt>provinceCode</tt>.
     *
     * @param provinceCode value to be assigned to property provinceCode
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * Getter method for property <tt>cityCode</tt>.
     *
     * @return property value of cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Setter method for property <tt>cityCode</tt>.
     *
     * @param cityCode value to be assigned to property cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * Getter method for property <tt>areaCode</tt>.
     *
     * @return property value of areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Setter method for property <tt>areaCode</tt>.
     *
     * @param areaCode value to be assigned to property areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for property <tt>preferenceType</tt>.
     *
     * @return property value of preferenceType
     */
    public String getPreferenceType() {
        return preferenceType;
    }

    /**
     * Setter method for property <tt>preferenceType</tt>.
     *
     * @param preferenceType value to be assigned to property preferenceType
     */
    public void setPreferenceType(String preferenceType) {
        this.preferenceType = preferenceType;
    }

    /**
     * Getter method for property <tt>openid</tt>.
     *
     * @return property value of openid
     */
    public Integer getOpenid() {
        return openid;
    }

    /**
     * Setter method for property <tt>openid</tt>.
     *
     * @param openid value to be assigned to property openid
     */
    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    /**
     * Getter method for property <tt>userAddress</tt>.
     *
     * @return property value of userAddress
     */
    public Integer getUserAddress() {
        return userAddress;
    }

    /**
     * Setter method for property <tt>userAddress</tt>.
     *
     * @param userAddress value to be assigned to property userAddress
     */
    public void setUserAddress(Integer userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserInfoForm{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", phoneNo='").append(phoneNo).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", userAddress=").append(userAddress);
        sb.append(", provinceCode='").append(provinceCode).append('\'');
        sb.append(", cityCode='").append(cityCode).append('\'');
        sb.append(", areaCode='").append(areaCode).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", preferenceType='").append(preferenceType).append('\'');
        sb.append(", Openid='").append(openid).append('\'');

        sb.append('}');
        return sb.toString();
    }
}
