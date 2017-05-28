/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.manage.book.util.httpclient;

/**
 * @author huazhong.whz
 * @version $Id: HttpRequestException.java, v 0.1 2015年7月29日 下午8:44:18 huazhong.whz Exp $
 */
public class HttpRequestException extends Exception {
    /**  */
    private static final long serialVersionUID = -8052985366982996905L;
    private String errroCode;
    private String errorMsg;

    /**
     * @param statusCode
     */
    public HttpRequestException(int statusCode) {
        String commonErrorCode = new Integer(statusCode).toString();
        String commonErrorMsg = "http错误状态码:" + commonErrorCode;

        this.errroCode = commonErrorCode;
        this.errorMsg = commonErrorMsg;
    }

    public String getErrroCode() {
        return errroCode;
    }

    public void setErrroCode(String errroCode) {
        this.errroCode = errroCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
