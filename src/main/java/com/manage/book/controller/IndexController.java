/**
 *
 */
package com.manage.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.book.controller.base.BaseController;
import com.manage.book.controller.form.WeixinTextForm;
import com.manage.book.dal.daointerface.ProjectDAO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengfei.ypf
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

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
        LOGGER.info("asdfasdfasdfasd");
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

    /**
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vali.htm", method = RequestMethod.POST)
    public void vali(HttpServletRequest request, HttpServletResponse response) {

        try {

            String params = JSONObject.toJSONString(request.getParameterMap());
            Map<String, String> xmlMap = xmlToMap(request);
            String xml = JSONObject.toJSONString(xmlMap);

            System.out.println(",url:" + request.getRequestURL() + ",param:" + params + ",xml:" + xml);
            LOGGER.info(",url:" + request.getRequestURL() + ",param:" + params + ",xml:" + xml);
            BaseController.writeJsonStr(response, "form.toString()");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * xml转换为map
     *
     * @param request
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = null;
        try {
            ins = request.getInputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc = null;
        try {
            doc = reader.read(ins);
            Element root = doc.getRootElement();

            List<Element> list = root.elements();

            for (Element e : list) {
                map.put(e.getName(), e.getText());
            }

            return map;
        } catch (DocumentException e1) {
            e1.printStackTrace();
        } finally {
            ins.close();
        }

        return null;
    }

}
