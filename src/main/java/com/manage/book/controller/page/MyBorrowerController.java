package com.manage.book.controller.page;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.BookInfoDOMapper;
import com.manage.book.dal.dataobject.BookInfoDO;
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
 * @version \$Id: MyBooksController.java, v 0.1 2017-05-28 16:26 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class MyBorrowerController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBorrowerController.class);

    @Autowired
    private BookInfoDOMapper bookInfoDOMapper;


    /**
     * @param modelMap
     * @param page
     * @return
     */
    @RequestMapping(value = "/myBorrower.htm", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, String borrowerId, String page) {
        if (StringUtil.isBlank(borrowerId)) {
            modelMap.put("errorMsg", "用户id为空，无法还书,请重新登录,");
            return new ModelAndView("templates/home/project/error.vm");
        }
        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = bookInfoDOMapper.selectMyBook(borrowerId, pageI, pageAdd(pageI));
        modelMap.put("booklist", booklist);
        return new ModelAndView("templates/home/project/page/myBorrower.vm");
    }

}
