/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.manage.book.core.result;

/**
 */
public class ModelResult<T> extends BaseResult {

    private T model;

    public ModelResult(T model) {
        this.model = model;
    }

    /**
     * Getter method for property <tt>model</tt>.
     *
     * @return property value of model
     */
    public T getModel() {
        return model;
    }

    /**
     * Setter method for property <tt>model</tt>.
     *
     * @param model value to be assigned to property model
     */
    public void setModel(T model) {
        this.model = model;
    }

}
