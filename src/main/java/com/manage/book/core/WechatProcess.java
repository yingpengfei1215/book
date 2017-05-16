/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core;

import com.manage.book.core.model.ReceiveXmlEntity;

/**
 * 微信xml消息处理流程逻辑类
 *
 * @author pengfei.ypf
 * @version \$Id: WechatProcess.java, v 0.1 2017-05-17 0:00 pengfei.ypf Exp $$
 */
public class WechatProcess {
    /**
     * 解析处理xml、获取智能回复结果（通过图灵机器人api接口）
     *
     * @param xml 接收到的微信数据
     * @return 最终的解析结果（xml格式数据）
     */
    public String processWechatMag(String xml) {
        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);

        /** 以文本消息为例，调用图灵机器人api接口，获取回复内容 */
        String result = "";
        if ("text".endsWith(xmlEntity.getMsgType())) {
            result = xmlEntity.getFromUserName() + "已经收到你的消息";

            /** 此时，如果用户输入的是“你好”，在经过上面的过程之后，result为“你也好”类似的内容
             *  因为最终回复给微信的也是xml格式的数据，所有需要将其封装为文本类型返回消息
             * */
            result = new FormatXmlProcess().formatXmlContentAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);

        } else if ("event".endsWith(xmlEntity.getMsgType())) {

            String t = "";
            String url = "";
            if ("V1001_MY_BACK_BOOK".equalsIgnoreCase(xmlEntity.getEventKey())) {
//                t = "我要还书";
//                url = "http://www.maymay.wang/book/index.htm?name=" + xmlEntity.getEventKey();
                result = xmlEntity.getFromUserName() + "你进入了 我要还书 ";
                result = new FormatXmlProcess().formatXmlContentAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);

            } else if ("V1001_MY_BOOK".equalsIgnoreCase(xmlEntity.getEventKey())) {
                t = "我的书会";
                url = "http://www.maymay.wang/book/index.htm?name=" + xmlEntity.getEventKey();
                result = new FormatXmlProcess().formatXmlUrlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), t, url);
            }
        }


        return result;
    }
}
