/**
 *
 */
package com.manage.book.controller;

import com.manage.book.controller.base.BaseController;
import com.manage.book.core.WechatProcess;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        modelMap.put("name", name);
        LOGGER.info("hello" + name);
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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            /** 读取接收到的xml消息 */
            StringBuffer sb = new StringBuffer();
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据

            String result = "";
            /** 判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回 */
            String echostr = request.getParameter("echostr");
            if (echostr != null && echostr.length() > 1) {
                result = echostr;
            } else {
                //正常的微信处理流程
                result = new WechatProcess().processWechatMag(xml);
            }

            try {
                OutputStream os = response.getOutputStream();
                os.write(result.getBytes("UTF-8"));
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
