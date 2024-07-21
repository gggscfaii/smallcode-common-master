package com.smallcode.common.exception;

/**
 * @author lenny
 * @Title: SmallCodeRuntimeException
 * @ProjectName smallcode-mall
 * @Description: 自定义异常类
 * @date 2019-01-07 15:47
 **/
public class SmallCodeRuntimeException extends RuntimeException {

  private String message;

  private Integer code = 500;

  public SmallCodeRuntimeException() {
  }

  public SmallCodeRuntimeException(ExceptionCode exceptionCode) {
    this.message = exceptionCode.getMessage();
    this.code = exceptionCode.getCode();
  }

  public SmallCodeRuntimeException(String message, String message1) {
    super(message);
    this.message = message1;
  }

  public SmallCodeRuntimeException(String message) {
    this.message = message;
  }


  public SmallCodeRuntimeException(String message, Throwable cause, String message1) {
    super(message, cause);
    this.message = message1;
  }

  public SmallCodeRuntimeException(Throwable cause, String message) {
    super(cause);
    this.message = message;
  }

  public SmallCodeRuntimeException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace, String message1) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.message = message1;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
