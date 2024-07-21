package com.smallcode.common.exception;

/**
 * @description: smallcode 异常
 * @author: lenny
 * @create: 2020-02-02 14:16
 **/
public enum CommonExceptionEnum implements ExceptionCode {

	INVALID_TOKEN(400, "无访问权限"),

	NO_ACCESS_RIGHT(402, "无访问权限"),

	SYSTEM_EXCEPTION(500, "系统异常"),

	ERROR_PARAM(10001, "参数错误");


	private Integer code;

	private String message;

	CommonExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}


	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}
}

