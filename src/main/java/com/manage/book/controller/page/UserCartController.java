package com.manage.book.controller.page;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.UserCarDOMapper;
import com.manage.book.dal.dataobject.BookInfoDO;
import com.manage.book.dal.dataobject.UserCarDO;
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
import java.util.List;

/**
 * @author pengfei.ypf
 * @version \$Id: UserCartController.java, v 0.1 2017-05-28 16:26 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class UserCartController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCartController.class);

    @Autowired
    public UserCarDOMapper userCarDOMapper;


    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bookCart.htm", method = RequestMethod.GET)
    public ModelAndView mycart(HttpServletResponse response, ModelMap modelMap, String page) {
        int pageI = DataTypeHandleUtil.parseInt(page);
        List<BookInfoDO> booklist = userCarDOMapper.selectCartByU(BaseController.getUserId(), pageI, pageAdd(pageI));

        modelMap.put("booklist", booklist);
        return new ModelAndView("templates/home/project/page/bookCart.vm");
    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/addbookCart.json", method = RequestMethod.POST)
    public void bookCart(HttpServletResponse response, ModelMap modelMap, String bookId) {

        if (StringUtil.isBlank(bookId)) {
            modelMap.put("result", "书籍未找到");
        }
        int bookIdInt = DataTypeHandleUtil.parseInt(bookId);

        UserCarDO cart = new UserCarDO();
        cart.setBookId(bookIdInt);
        cart.setIsdelete(0);
        cart.setUserId(BaseController.getUserId());
        int re = userCarDOMapper.insert(cart);
        modelMap.put("result", "S");
        writeJson(response, modelMap);
    }

}
