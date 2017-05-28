package com.manage.book.dal.daointerface;

import com.manage.book.dal.daointerface.extend.BookInfoDOMapperBase;
import com.manage.book.dal.dataobject.BookInfoDO;
import java.util.List;

public interface BookInfoDOMapper extends BookInfoDOMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    int insert(BookInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    BookInfoDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    List<BookInfoDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BookInfoDO record);
}