package fashion_shop.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
	@Id
	@Column(name = "ID")
	private int idCategory;
	
	@Column(name = "Name")
	private String nameCategory;
	
	@OneToMany(mappedBy = "ProdCategory", fetch = FetchType.EAGER)
	private Collection<Product> prods;
	
	public Collection<Product> getProds() {
		return prods;
	}

	public void setProds(Collection<Product> prods) {
		this.prods = prods;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
