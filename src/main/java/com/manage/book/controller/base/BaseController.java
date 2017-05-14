/**
 * Alipay.com Inc.
 * <p>
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.manage.book.controller.base;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * BaseController
 *
 * @author sheya.lsy
 * @version v0.1 17/1/13 上午11:37.
 */
public class BaseController {


//    /**
//     * 写json到前台
//     *
//     * @param response
//     * @param data
//     */
//    public static void writeJson(HttpServletResponse response, Object data) {
//        PrintWriter writer = null;
//        try {
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("Cache-Control", "no-cache");
//            writer = response.getWriter();
//            String json = JSON.toJSONString(data);
//            writer.write(json);
//            writer.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != writer) {
//                writer.close();
//            }
//        }
//    }

    public static void writeJsonStr(HttpServletResponse response, String result) {
        PrintWriter writer = null;
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            writer = response.getWriter();
            writer.write(result);
            writer.flush();
        } catch (Exception e) {
        } finally {
            if (null != writer) {
                writer.close();
            }
        }

    }
//
//    public static void writeJsonp(HttpServletResponse response, String callback, Object data) {
//        PrintWriter writer = null;
//        try {
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("Cache-Control", "no-cache");
//            writer = response.getWriter();
//            String jsonp = String.format("%s(%s)", callback, JSON.toJSONString(data));
//            writer.write(jsonp);
//            writer.flush();
//        } catch (Exception e) {
//            LOGGER.error("writeJsonp exception.", e);
//        } finally {
//            if (null != writer) {
//                writer.close();
//            }
//        }
//
//    }

}