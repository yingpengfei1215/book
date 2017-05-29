package com.manage.book.dal.daointerface;

import com.manage.book.dal.daointerface.extend.UserInfoDOMapperBase;
import com.manage.book.dal.dataobject.UserInfoDO;
import java.util.List;

public interface UserInfoDOMapper extends UserInfoDOMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    int insert(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    UserInfoDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    List<UserInfoDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserInfoDO record);
}