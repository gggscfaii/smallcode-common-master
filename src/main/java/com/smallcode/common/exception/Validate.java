package com.smallcode.common.exception;

import com.smallcode.common.constant.Errors;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lenny
 * @Title: Validate
 * @ProjectName smallcode-mall
 * @date 2019-01-29 15:47
 **/
public class Validate {


    /**
     * 是否为空
     *
     * @param targetId
     * @return
     */
    public static boolean isNull(Long targetId) {
        return targetId == null;
    }

    /**
     * 判断是不是为空
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 是否为空
     */
    public static <T> T notNull(T object) {
        if (object == null) {
            throw new SmallCodeRuntimeException(Errors.OBJECT_NOT_EXIST);
        } else {
            return object;
        }
    }

    /**
     * 是否为空
     */
    public static <T> T notNull(T object, String errMsg) {
        if (object == null) {
            throw new SmallCodeRuntimeException(errMsg);
        } else {
            return object;
        }
    }

    /**
     * 是否为空
     *
     * @param object        判断的对象
     * @param exceptionCode 错误码
     */
    public static <T> T notNull(T object, ExceptionCode exceptionCode) {
        if (object == null) {
            throw new SmallCodeRuntimeException(exceptionCode);
        } else {
            return object;
        }
    }

    /**
     * 是否为空
     */
    public static <T> T[] notEmpty(T[] array) {
        if (array == null || array.length == 0) {
            throw new SmallCodeRuntimeException(Errors.OBJECT_NOT_EXIST);
        } else {
            return array;
        }
    }

    /**
     * 是否为空
     */
    public static <T extends Collection<?>> T notEmpty(T collection) {
        if (collection == null || collection.isEmpty()) {
            throw new SmallCodeRuntimeException(Errors.OBJECT_NOT_EXIST);
        } else {
            return collection;
        }
    }

    public static <T extends Map<?, ?>> T notEmpty(T map) {
        if (map == null || map.isEmpty()) {
            throw new SmallCodeRuntimeException(Errors.OBJECT_NOT_EXIST);
        } else {
            return map;
        }
    }

    public static <T extends CharSequence> T notBlank(T chars) {
        if (StringUtils.isEmpty(chars)) {
            throw new SmallCodeRuntimeException(Errors.OBJECT_NOT_EXIST);
        } else {
            return chars;
        }
    }
}
