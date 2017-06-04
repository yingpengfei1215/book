/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core.book;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.manage.book.controller.form.UserInfoForm;
import com.manage.book.core.result.BaseResult;
import com.manage.book.dal.daointerface.AddressInfoDOMapper;
import com.manage.book.dal.daointerface.UserInfoDOMapper;
import com.manage.book.dal.dataobject.AddressInfoDO;
import com.manage.book.dal.dataobject.UserInfoDO;
import com.manage.book.util.BeanCovertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: UserInfoService.java, v 0.1 2017-06-04 22:14 pengfei.ypf Exp $$
 */
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDOMapper userInfoDoMapper;
    @Autowired
    private AddressInfoDOMapper addressInfoDOMapper;

    //@Autowired
    //SqlMapClientTemplate transactionTemplate;

    @Override
    public BaseResult saveUserInfo(final UserInfoForm from) {
        //TODO 检查数据格式

        UserInfoDO userinfo = BeanCovertUtil.beanCovert(from, UserInfoDO.class);
        AddressInfoDO addressInfoDO = BeanCovertUtil.beanCovert(from, AddressInfoDO.class);
        addressInfoDO.setUserId(userinfo.getId());
        addressInfoDO.setId(from.getUserAddress());
        if (from.getId() == null) {
            int addressId = addressInfoDOMapper.insert(addressInfoDO);
            userinfo.setUserAddress(addressId);
            userInfoDoMapper.insert(userinfo);
        } else {
            userInfoDoMapper.updateByPrimaryKey(userinfo);
            addressInfoDOMapper.updateByPrimaryKey(addressInfoDO);
        }
        return new BaseResult();
    }

}
