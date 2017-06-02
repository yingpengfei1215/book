package com.manage.book.dal.daointerface.extend;

import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.dal.dataobject.UserCarDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCarDOMapperBase {

    List<BookInfoDO> selectCartByU(@Param("userId") int userId, @Param("start") int start, @Param("end") int end);

    UserCarDO selectBookByUserAndId(@Param("userId") int userId, @Param("bookId") int bookId);


}