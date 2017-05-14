/**
 *
 */
package com.manage.book.controller;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.SHA;

import javax.servlet.http.HttpServletResponse;
import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengfei.ypf
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ProjectDAO projectDAO;

    /**
     * @param modelMap
     * @param name
     * @return
     */
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, String name) {
        modelMap.put("a", "hello");
        projectDAO.queryByProject("万宝城");
        System.out.println(projectDAO.queryByProject("万宝城"));
        return new ModelAndView("templates/home/project/index.vm");
    }

    /**
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/vali.htm", method = RequestMethod.GET)
    public void vali(HttpServletResponse response, String signature, String timestamp, String nonce, String echostr) throws DigestException {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("nonce", nonce);
        maps.put("timestamp", timestamp);
        maps.put("nonce", nonce);
        String s = Sha1.SHA1(maps);
        if (s.equals(signature)) {
            BaseController.writeJsonStr(response, echostr);
        }
        BaseController.writeJsonStr(response, echostr);
    }
}
