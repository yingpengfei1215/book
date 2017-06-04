package com.manage.book.dal.daointerface.extend;

import java.util.List;

import com.manage.book.dal.dataobject.BookTypeDO;

public interface BookTypeDOMapperBase {
    List<BookTypeDO> getBookType(BookTypeDO BookTypeDO);
}
