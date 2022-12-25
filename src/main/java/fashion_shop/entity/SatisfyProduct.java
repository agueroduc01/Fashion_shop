package fashion_shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "SatisfyProduct")
public class SatisfyProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SatisfyProductKey key;
	
	@ManyToOne
	@MapsId("historyId")
	@JoinColumn(name = "HistoryID")
	private History history;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "ProductID")
	private Product product;

	public SatisfyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SatisfyProduct(SatisfyProductKey key, History history, Product product) {
		super();
		this.key = key;
		this.history = history;
		this.product = product;
	}

	public SatisfyProductKey getKey() {
		return key;
	}

	public void setKey(SatisfyProductKey key) {
		this.key = key;
	}

	public History getHistoryId() {
		return history;
	}

	public void setHistoryId(History history) {
		this.history = history;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
