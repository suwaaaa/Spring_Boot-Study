package net.springboot.demo.domain;

public class MyExecption extends RuntimeException{
	
	/**
	 * 自定义的异常类
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyExecption(String code, String msg) {
		this.code = code;
		this.msg = msg;
		
	}
	
	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
