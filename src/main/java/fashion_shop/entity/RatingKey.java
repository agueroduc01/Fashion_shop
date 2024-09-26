package fashion_shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatingKey implements Serializable {
	@Column(name = "ProductID")
	private String productId;
	@Column(name = "Username")
	private String username;
	
	public RatingKey(String productId, String username) {
		super();
		this.productId = productId;
		this.username = username;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RatingKey() {
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
