package com.manage.book.controller.page;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.UserInfoDOMapper;
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
 * @author pengfei.ypf
 * @version \$Id: UserInfoController.java, v 0.1 2017-05-28 16:26 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class UserInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoDOMapper userInfoDoMapper;

    /**
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping(value = "/userInfo.htm", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, String id) {
        modelMap.put("name", id);
        UserInfoDO userinfo = userInfoDoMapper.selectByPrimaryKey(Integer.parseInt(id));
        modelMap.put("userinfo", userinfo);
        return new ModelAndView("templates/home/project/page/userinfo.vm");
    }

}
