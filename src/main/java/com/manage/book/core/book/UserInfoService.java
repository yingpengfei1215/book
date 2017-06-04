/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.manage.book.core.book;

import com.manage.book.controller.form.UserInfoForm;
import com.manage.book.core.result.BaseResult;

/**
 * TODO pengfei.ypf Javadoc
 *
 * @author pengfei.ypf
 * @version \$Id: UserInfoService.java, v 0.1 2017-06-04 22:14 pengfei.ypf Exp $$
 */
public interface UserInfoService {

    public BaseResult saveUserInfo(UserInfoForm from);
}
