package com.manage.book.controller.page;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.BookInfoDOMapper;
import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.dal.dataobject.UserInfoDO;
import com.manage.book.util.DataTypeHandleUtil;
import com.manage.book.util.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author pengfei.ypf
 * @version \$Id: UserInfoController.java, v 0.1 2017-05-28 16:26 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class BookSearchController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookSearchController.class);

    @Autowired
    public BookInfoDOMapper bookInfoDOMapper;

    /**
     * @param modelMap
     * @param key
     * @return
     */
    @RequestMapping(value = "/bookSearch.htm", method = RequestMethod.GET)
    public ModelAndView bookSearch(ModelMap modelMap, String key, String page) {

        modelMap.put("key", key);
        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = bookInfoDOMapper.selectByKey(key, pageI, pageAdd(pageI));
        modelMap.put("booklist", booklist);
        return new ModelAndView("templates/home/project/page/bookSearch.vm");
    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookSearchByType.htm", method = RequestMethod.GET)
    public ModelAndView bookSearchByType(ModelMap modelMap, String typeId, String page) {
        if (StringUtil.isBlank(typeId)) {
            typeId = "1";
        }
        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = bookInfoDOMapper.selectByKey(typeId, pageI, pageAdd(pageI));
        modelMap.put("booklist", booklist);
        return new ModelAndView("templates/home/project/page/bookSearch.vm");
    }

}
