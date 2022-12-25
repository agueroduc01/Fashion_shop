package fashion_shop.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "History")
public class History implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "RequestTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestTime;
	
	@Column(name = "SessionID", nullable = false)
	private String sessionId;
	
	@Column(name = "ProductID", nullable = false)
	private String productId;
	
	@OneToMany(mappedBy = "history", targetEntity = SatisfyProduct.class)
	Collection<SatisfyProduct> satisfyProducts;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(int id, String username, Date requestTime, String sessionId, String productId,
			Collection<SatisfyProduct> satisfyProducts) {
		super();
		this.id = id;
		this.username = username;
		this.requestTime = requestTime;
		this.sessionId = sessionId;
		this.productId = productId;
		this.satisfyProducts = satisfyProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Collection<SatisfyProduct> getSatisfyProducts() {
		return satisfyProducts;
	}

	public void setSatisfyProducts(Collection<SatisfyProduct> satisfyProducts) {
		this.satisfyProducts = satisfyProducts;
	}
}
