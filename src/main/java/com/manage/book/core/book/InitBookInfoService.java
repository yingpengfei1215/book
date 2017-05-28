/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core.book;

import com.manage.book.core.model.BookInfoModel;
import com.manage.book.dal.dataobject.BookInfoDO;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: InitBookInfoService.java, v 0.1 2017-05-29 0:03 pengfei.ypf Exp $$
 */
public interface InitBookInfoService {

    /**
     * @param code
     * @return
     */
    public BookInfoDO getBookInfo(String id);

    /**
     * @param code
     * @return
     */
    public BookInfoModel initBookInfo(String code);


}
