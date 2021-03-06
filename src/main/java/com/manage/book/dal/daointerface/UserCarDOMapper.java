package com.manage.book.dal.daointerface;

import com.manage.book.dal.daointerface.extend.UserCarDOMapperBase;
import com.manage.book.dal.dataobject.UserCarDO;
import java.util.List;

public interface UserCarDOMapper extends UserCarDOMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_car
     *
     * @mbggenerated
     */
    int insert(UserCarDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_car
     *
     * @mbggenerated
     */
    List<UserCarDO> selectAll();
}