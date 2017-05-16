package com.manage.book.core;

import com.manage.book.core.model.ReceiveXmlEntity;

import java.util.Date;

/**
 * 封装最终的xml格式结果
 *
 * @author pengfei.ypf
 * @version \$Id: FormatXmlProcess.java, v 0.1 2017-05-16 23:48 pengfei.ypf Exp $$
 */
public class FormatXmlProcess {

    /**
     * 封装文字类的返回消息
     *
     * @param to
     * @param from
     * @param content
     * @return
     */
    public String formatXmlContentAnswer(String to, String from, String content) {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        sb.append("<xml><ToUserName><![CDATA[");
        sb.append(to);
        sb.append("]]></ToUserName><FromUserName><![CDATA[");
        sb.append(from);
        sb.append("]]></FromUserName><CreateTime>");
        sb.append(date.getTime());
        sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
        sb.append(content);
        sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");
        return sb.toString();
    }

    /**
     * 封装文字类的返回消息
     *
     * @param to
     * @param from
     * @param title
     * @param url
     * @return
     */
    public String formatXmlUrlAnswer(String to, String from, String title, String url) {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        sb.append("<xml><ToUserName><![CDATA[");
        sb.append(to);
        sb.append("]]></ToUserName><FromUserName><![CDATA[");
        sb.append(from);
        sb.append("]]></FromUserName><CreateTime>");
        sb.append(date.getTime());
        sb.append("</CreateTime><MsgType><![CDATA[news]]></MsgType>");
        sb.append("<ArticleCount>1</ArticleCount>");
        sb.append("<Articles><item>");
        sb.append("<Title><![CDATA[").append(title).append("]]></Title>");
        sb.append("<Description><![CDATA[").append(title).append("]]></Description>");
        sb.append("<PicUrl><![CDATA[").append(url).append("]]></PicUrl>");
        sb.append("<Url><![CDATA[").append(url).append("]]></Url>");
        sb.append("</item></Articles>");
        sb.append("</xml>");
        return sb.toString();
    }

//    public static String textMessageToXml(ReceiveXmlEntity textMsg) {
//        XStream xstream = new XStream();
//        // 将根元素替换成<xml>，默认根元素为<类名>
//        xstream.alias("xml", textMsg.getClass());
//        return xstream.toXML(textMsg);
//    }
}
