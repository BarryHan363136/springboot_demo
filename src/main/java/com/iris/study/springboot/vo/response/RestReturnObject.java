package com.iris.study.springboot.vo.response;

import java.io.Serializable;

/**
 * rest 接口统一返回对象
 * 
 * @author chongwenjun
 *
 */
public class RestReturnObject implements Serializable {
	private static final long serialVersionUID = 1L;
	// 返回状态
	private String code;
	// 返回提示信息
	private String message;
	// 返回结果对象
	private Object obj;

	public RestReturnObject() {
		this.code = "fail";
		this.message = "系统异常";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * 成功返回
	 * 
	 * @param obj
	 * @return
	 */
	public static RestReturnObject generateSuccessObject(Object obj) {
		RestReturnObject returnObject = new RestReturnObject();
		returnObject.setCode("success");
		returnObject.setMessage("success");
		returnObject.setObj(obj);
		return returnObject;
	}

	/**
	 * 错误返回
	 * 
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static RestReturnObject generateFailedObject(String msg, Object obj) {
		RestReturnObject returnObject = new RestReturnObject();
		returnObject.setCode("fail");
		returnObject.setMessage(msg);
		returnObject.setObj(obj);
		return returnObject;
	}

}
