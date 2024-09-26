package fashion_shop.model;

import java.io.Serializable;

public class APIResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private int cluster;

	public APIResult(int code, int cluster) {
		super();
		this.code = code;
		this.cluster = cluster;
	}

	public APIResult() {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	@Override
	public String toString() {
		return "APIResult [code=" + code + ", cluster=" + cluster + "]";
	}

}
