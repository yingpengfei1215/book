/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core.book;

import com.alibaba.fastjson.JSONObject;
import com.manage.book.core.model.BookInfoModel;
import com.manage.book.dal.daointerface.BookInfoDOMapper;
import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.util.BeanCovertUtil;
import com.manage.book.util.httpclient.HttpsUtil;
import com.manage.book.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: InitBookInfoServiceImpl.java, v 0.1 2017-05-29 0:08 pengfei.ypf Exp $$
 */
public class InitBookInfoServiceImpl implements InitBookInfoService {

    @Autowired
    public BookInfoDOMapper bookInfoDOMapper;
    private int tempId;

    @Override
    public BookInfoModel initBookInfo(String code) {
        if (StringUtil.isBlank(code)) {
            return null;
        }
        String url = "https://api.douban.com//v2/book/isbn/" + code;
        String bookJson = "";
        try {
            bookJson = HttpsUtil.get(url, new HashMap<String, String>(), 5000);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BookInfoModel model = JSONObject.parseObject(bookJson, BookInfoModel.class);

        bookInfoDOMapper.insert(BeanCovertUtil.beanCovert(model, BookInfoDO.class));

        return model;
    }


    @Override
    public BookInfoDO getBookInfo(String id) {
        if (StringUtil.isBlank(id)) {
            return null;
        }
        int tempId = Integer.parseInt(id);
        return bookInfoDOMapper.selectByPrimaryKey(tempId);

    }

}
