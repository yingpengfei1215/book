/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core.book;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.manage.book.core.model.BookInfoModel;
import com.manage.book.dal.daointerface.BookInfoDOMapper;
import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.util.BeanCovertUtil;
import com.manage.book.util.PrintLogUtil;
import com.manage.book.util.httpclient.HttpsUtil;
import com.manage.book.util.string.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    public BookInfoModel initBookInfo(String code, int ownerId) {

        try {
            BookInfoModel model = readBookIsbn(code);
            if (model == null) {
                return model;
            }

            BookInfoDO infoDo = BeanCovertUtil.beanCovert(model, BookInfoDO.class);
            if (infoDo != null) {
                if (StringUtil.isNotBlank(infoDo.getBookComment()) && infoDo.getBookComment().length() > 4000) {
                    infoDo.setBookComment(infoDo.getBookComment().substring(3996) + "...");
                }
                if (StringUtil.isNotBlank(infoDo.getAuthor())) {
                    infoDo.setAuthor(jionList(infoDo.getAuthor()));
                }
                infoDo.setOwnerId(ownerId);
                bookInfoDOMapper.insert(infoDo);
            }
            return model;
        } catch (Exception e) {
            PrintLogUtil.error(InitBookInfoServiceImpl.class, e, "");
            return null;
        }
    }

    public String jionList(String value) {
        try {
            String authors = value;
            List<String> authorList = JSONArray.parseArray(authors, String.class);
            return StringUtils.join(authorList.toArray(), ",");
        } catch (Exception e) {
            return value;
        }
    }

    @Override
    public BookInfoModel readBookIsbn(String code) {
        try {
            if (StringUtil.isBlank(code)) {
                return null;
            }
            String url = "https://api.douban.com//v2/book/isbn/" + code;
            String bookJson = "";
            try {
                bookJson = HttpsUtil.get(url, new HashMap<String, String>(), 5000);
            } catch (Exception e) {

                return null;
            }
            BookInfoModel model = JSONObject.parseObject(bookJson, BookInfoModel.class);
            return model;
        } catch (Exception e) {
            PrintLogUtil.error(InitBookInfoServiceImpl.class, e, "");
            return null;
        }
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
