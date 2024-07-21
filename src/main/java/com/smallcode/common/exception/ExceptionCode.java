package com.smallcode.common.exception;

/**
 * @author lenny
 * @Title: ExceptionCode
 * @ProjectName smallcode-mall-common
 * @date 2019-06-02 18:07
 **/
public interface ExceptionCode {

  Integer getCode();

  void setCode(Integer code);

  String getMessage();

  void setMessage(String message);
}
