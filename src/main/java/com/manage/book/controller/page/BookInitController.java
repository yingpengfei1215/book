/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.controller.page;

import com.manage.book.core.book.InitBookInfoService;
import com.manage.book.core.model.BookInfoModel;
import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.dal.dataobject.UserInfoDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: BookInitController.java, v 0.1 2017-05-29 0:51 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class BookInitController {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private InitBookInfoService initBookInfoService;

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookInit.htm", method = RequestMethod.GET)
    public ModelAndView init(ModelMap modelMap, String code) {
        BookInfoModel model = initBookInfoService.initBookInfo(code, 123);
        modelMap.put("model", model);
        return new ModelAndView("templates/home/project/page/bookInfo.vm");
    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookInfo.htm", method = RequestMethod.GET)
    public ModelAndView getInfo(ModelMap modelMap, String id) {
        BookInfoDO bookInfo = initBookInfoService.getBookInfo(id);
        modelMap.put("model", bookInfo);
        return new ModelAndView("templates/home/project/page/bookInfo.vm");
    }

}
