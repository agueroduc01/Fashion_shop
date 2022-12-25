package fashion_shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "SizeAndColor")
public class SizeAndColor {
	@EmbeddedId
	private PK pk ;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Embeddable
	public static class PK  implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Column(name = "ProductID")
		private String productID;
		@Column(name = "Size")
		private String size;
		@Column(name = "Color")
		private String color;
		
		public String getProductID() {
			return productID;
		}
		public void setProductID(String productID) {
			this.productID = productID;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
	
		
	}

	public PK getPk() {
		return pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
