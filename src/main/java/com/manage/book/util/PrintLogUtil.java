/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.util;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: PrintLogUtil.java, v 0.1 2017-05-29 23:34 pengfei.ypf Exp $$
 */
public class PrintLogUtil {


    public static void info(Class clazz, String msg) {
        System.out.println(clazz.getCanonicalName() + " " + msg);
    }

    public static void error(Class clazz, Exception e, String msg) {
        e.printStackTrace();
        System.out.println(clazz.getCanonicalName() + " " + msg);
    }

}
