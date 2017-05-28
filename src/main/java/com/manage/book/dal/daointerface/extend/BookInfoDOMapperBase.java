package com.manage.book.dal.daointerface.extend;

import com.manage.book.dal.dataobject.BookInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookInfoDOMapperBase {

    List<BookInfoDO> selectByKey(@Param("key") String key, @Param("start") int start, @Param("end") int end);
}