/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.util;

import com.manage.book.util.string.StringUtil;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: DataTypeHandleUtil.java, v 0.1 2017-05-29 18:52 pengfei.ypf Exp $$
 */
public class DataTypeHandleUtil {

    public static int ZERO = 0;


    public static int parseInt(String value) {
        if (StringUtil.isBlank(value)) {
            return ZERO;
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return ZERO;
        }
    }


}
