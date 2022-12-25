package fashion_shop.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@Column(name = "ID")
	private String idProduct;

	@Column(name = "Name")
	private String name;

	@Column(name = "Price")
	private float price;

	@Column(name = "Image")
	private String image;
	
	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Gender")
	private boolean gender;
	
	@Column(name = "ReleaseTime")
	private int releaseTime;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "ProductType")
	private String productType;
	
	@Column(name = "ProductCluster")
	private int productCluster;
	
	@Column(name = "ProductMaterial")
	private String material;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, targetEntity = Rating.class)
	private Collection<Rating> ratings;
	

public Product(String idProduct, String name, float price, String image, String brand, boolean gender,
			int releaseTime, String productType, int productCluster, Collection<Cart> carts,
			ProductCategory prodCategory, String material) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.image = image;
		this.brand = brand;
		this.gender = gender;
		this.releaseTime = releaseTime;
		this.productType = productType;
		this.productCluster = productCluster;
		this.carts = carts;
		this.material = material;
		this.ProdCategory = prodCategory;
	}



//	@OneToMany(mappedBy = "prod", fetch = FetchType.EAGER)
//	private Collection<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private Collection<Cart> carts;
	
	@ManyToOne 
	@JoinColumn(name = "IDCategory")
	private ProductCategory ProdCategory;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public ProductCategory getProductCategory() {
		return ProdCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		ProdCategory = productCategory;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(int releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductCluster() {
		return productCluster;
	}

	public void setProductCluster(int productCluster) {
		this.productCluster = productCluster;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	public ProductCategory getProdCategory() {
		return ProdCategory;
	}

	public void setProdCategory(ProductCategory prodCategory) {
		ProdCategory = prodCategory;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", image=" + image
				+ ", brand=" + brand + ", gender=" + gender + ", releaseTime=" + releaseTime + ", productType="
				+ productType + ", productCluster=" + productCluster + ", material=" + material + ", ratings=" + ratings
				+ ", carts=" + carts + ", ProdCategory=" + ProdCategory + "]";
	}

	public Collection<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Collection<Rating> ratings) {
		this.ratings = ratings;
	}


//	public Collection<OrderDetail> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}
}