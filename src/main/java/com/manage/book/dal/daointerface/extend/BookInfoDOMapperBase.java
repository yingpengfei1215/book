package com.manage.book.dal.daointerface.extend;

import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.dal.dataobject.UserCarDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookInfoDOMapperBase {

    BookInfoDO checkBookIn(@Param("ownerId") int ownerId, @Param("isbn") String isbn);


    List<BookInfoDO> selectByKey(@Param("key") String key, @Param("start") int start, @Param("end") int end);

    List<BookInfoDO> selectByType(@Param("typeId") String typeId, @Param("start") int start, @Param("end") int end);

    List<BookInfoDO> selectMyBook(@Param("ownerId") String ownerId, @Param("start") int start, @Param("end") int end);

    List<BookInfoDO> selectMyBorrower(@Param("borrowerId") String borrowerId, @Param("start") int start, @Param("end") int end);

    List<BookInfoDO> selectCartByUser(@Param("userId")int userId, @Param("start") int start, @Param("end") int end);

}