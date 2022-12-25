package fashion_shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id_detail;
	
	@Column(name = "Price")
	private float price;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "IDOrder")
	private Order idOrder;
	
	@ManyToOne 
	@JoinColumn(name = "IDProduct")
	private Product prod;
	
	public Integer getId_detail() {
		return id_detail;
	}

	public void setId_detail(Integer id_detail) {
		this.id_detail = id_detail;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return idOrder;
	}

	public void setOrder(Order order) {
		this.idOrder = order;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
}