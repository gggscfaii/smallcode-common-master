package com.smallcode.common.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.smallcode.common.exception.ExceptionCode;
import lombok.Data;

/**
 * @description: 返回值
 * @author: lenny
 * @create: 2020-01-27 14:17
 **/
@Data
public class ReturnResult implements Serializable {

    private int code = 0;

    private boolean success;

    private String message;

    private Map<String, Object> result = null;


    public ReturnResult(boolean success, String message) {
        this(success, message, 200);
    }


    public ReturnResult(boolean success, String message, Integer code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }


    public static ReturnResult success() {
        return new ReturnResult(true, "");
    }

    public static <T>  ReturnResult success(T t) {
      ReturnResult returnResult = new ReturnResult(true, "");
      returnResult.setItem(t);
      return returnResult;
    }

    public static ReturnResult failure(String message) {
        return failure(message, 500);
    }


    public static ReturnResult failure(ExceptionCode exceptionCode) {
        return failure(exceptionCode.getMessage(), exceptionCode.getCode());
    }

    public static ReturnResult failure(String message, Integer code) {
        return new ReturnResult(false, message, code);
    }


    public <T> ReturnResult setItem(T t) {
        if (t != null) {
            if (result == null) {
                this.result = new HashMap<String, Object>();
            }
            this.result.put("item", t);
        }
        return this;
    }

    public ReturnResult addResult(String key, Object val) {
        if (key != null && val != null) {
            if (result == null) {
                this.result = new HashMap<String, Object>();
            }
            result.put(key, val);
        }
        return this;
    }

    public <T extends Serializable> ReturnResult setItems(Collection<T> t) {
        if (t != null) {
            if (result == null) {
                this.result = new HashMap<String, Object>();
            }
            result.put("items", t);
        }
        return this;
    }

    public ReturnResult setPageBean(PageBean pageBean) {
        if (pageBean != null) {
            if (result == null) {
                this.result = new HashMap<String, Object>();
            }
            this.result.put("pageBean", pageBean);
        }
        return this;
    }

    public static ReturnResult page(PageResult pageResult) {
        return ReturnResult.success().setPageBean(pageResult.getPageBean())
                .setItems(pageResult.getItems());
    }
}
