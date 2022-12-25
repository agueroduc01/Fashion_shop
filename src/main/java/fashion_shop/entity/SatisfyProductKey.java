package fashion_shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SatisfyProductKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ProductID")
	private String productId;
	
	@Column(name = "HistoryID")
	private int historyId;

	public SatisfyProductKey() {
		// TODO Auto-generated constructor stub
	}

	public SatisfyProductKey(String productId, int historyId) {
		super();
		this.productId = productId;
		this.historyId = historyId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
}
