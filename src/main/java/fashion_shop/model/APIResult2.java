package fashion_shop.model;

import java.io.Serializable;

public class APIResult2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;

	public APIResult2(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public APIResult2() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "APIResult [code=" + code + ", message=" + message + "]";
	}

}
