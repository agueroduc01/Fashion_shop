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
@Table(name = "Rating")
public class Rating implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RatingKey key;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "ProductID", nullable = false)
	private Product product;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name = "Username", nullable = false)
	private Account account;
	
	@Column(name = "Rating")
	private int rating;

	public Rating(RatingKey key, Product product, Account account, int rating) {
		super();
		this.key = key;
		this.product = product;
		this.account = account;
		this.rating = rating;
	}

	public RatingKey getKey() {
		return key;
	}

	public void setKey(RatingKey key) {
		this.key = key;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Rating(RatingKey key, Product product, Account account) {
		super();
		this.key = key;
		this.product = product;
		this.account = account;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}	
	
}
