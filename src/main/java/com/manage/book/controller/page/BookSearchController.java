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

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param key
     * @return
     */
    @RequestMapping(value = "/bookSearch.json", method = RequestMethod.GET)
    public void bookSearchJson(HttpServletResponse response, ModelMap modelMap, String key, String page) {
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("key", key);
        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = bookInfoDOMapper.selectByKey(key, pageI, pageAdd(pageI));
        re.put("booklist", booklist);
        writeJson(response, re);
    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookTypes.json", method = RequestMethod.GET)
    public void bookTypes(HttpServletResponse response, ModelMap modelMap, String typeId, String page) {
        if (StringUtil.isBlank(typeId)) {
            typeId = "1";
        }
        int pageI = DataTypeHandleUtil.parseInt(page);
        // List<BookInfoDO> booklist = bookInfoDOMapper.selectByKey(typeId, pageI, pageAdd(pageI));
        List<String> typelist = new ArrayList<String>();
        typelist.add("漫画");
        typelist.add("动漫");
        typelist.add("美食");
        typelist.add("科技");

        modelMap.put("typelist", typelist);
        writeJson(response, modelMap);
    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookSearchByType.json", method = RequestMethod.GET)
    public void bookSearchByType(HttpServletResponse response, ModelMap modelMap, String typeId, String page) {
        if (StringUtil.isBlank(typeId)) {
            typeId = "1";
        }

        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = bookInfoDOMapper.selectByType(typeId, pageI, pageAdd(pageI));
        modelMap.put("booklist", booklist);
        writeJson(response, modelMap);
    }

//    /**
//     * @param modelMap
//     * @return
//     */
//    @RequestMapping(value = "/typeList.htm", method = RequestMethod.GET)
//    public ModelAndView getTypeList(ModelMap modelMap) {
//        int pageI = DataTypeHandleUtil.parseInt(page);
//        List<BookInfoDO> booklist = bookInfoDOMapper.selectByKey(typeId, pageI, pageAdd(pageI));
//        modelMap.put("booklist", booklist);
//        return new ModelAndView("templates/home/project/page/bookSearch.vm");
//    }

}
