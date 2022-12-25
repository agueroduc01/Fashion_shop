package fashion_shop.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fashion_shop.entity.Product;
import fashion_shop.entity.ProductCategory;
import fashion_shop.entity.Rating;
import fashion_shop.entity.SizeAndColor;
import fashion_shop.entity.SizeAndColor.PK;

@Transactional
@Repository
public class productDAO {
	@Autowired
	SessionFactory factory;
	
	//Get List Product includes Size, Color and Quantity 
	//( mix between 2 Entity: Product & SizeAndColor)
	public List<Object[]> getLMixProd() {
		Session session = factory.getCurrentSession();
		String hql = "select P.idProduct, P.ProdCategory, P.name, P.price, P.image, S.pk.color, S.pk.size, S.pk.quantity  " +
				" from Product P, SizeAndColor S "
				+ "where P.idProduct = S.pk.productID";
		Query query = session.createQuery(hql);
		List<Object[]> listProd = query.list();
		return listProd;
	}
	
	// Get List Product DOES NOT includes Size, Color and Quantity 
	//( just Entity: Product)
	public List<Product> getLProd() {
		Session session = factory.getCurrentSession();
		String hql = "from Product";
		Query query = session.createQuery(hql);
		List<Product> listProd = query.list();
		return listProd;
	}
	
	public List<Product> getProductsByCluster(String id) throws IOException, InterruptedException {
		Session session = factory.getCurrentSession();
		Product currentProduct = (Product) session.get(Product.class, id);
		String hql = String.format("from Product where id != %s and productCluster = %d and ProdCategory.idCategory = %d", 
				currentProduct.getIdProduct(), 
				currentProduct.getProductCluster(),
				currentProduct.getProductCategory().getIdCategory());
		Query query = session.createQuery(hql);
		List<Product> listProd = query.list();
		listProd.sort(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				Double avgRating1 = 0.0;
				if (o1.getRatings().size() != 0) {
					for (Rating rating : o1.getRatings()) {
						avgRating1 += rating.getRating();
					}
					avgRating1 /= o1.getRatings().size();
				}
				Double avgRating2 = 0.0;
				if (o2.getRatings().size() != 0) {
					for (Rating rating : o2.getRatings()) {
						avgRating2 += rating.getRating();
					}
					avgRating2 /= o2.getRatings().size();
				}
				return avgRating1.compareTo(avgRating2);
			}
		});
		Process p = Runtime.getRuntime().exec("C:/Users/THANHTRUNG/miniconda3/envs/tf-gpu/python.exe \"c:/Users/THANHTRUNG/OneDr\r\n"
				+ "ive - student.ptithcm.edu.vn/Desktop/eclipse_workspace/do-an-phat-trien-cac-he-thong-thong-minh/kmeans-clustering.py\"");
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
		    System.out.println(line);
		}
		p.waitFor();
		System.out.println("ok!");
		return listProd.subList(0, 20);
	}
	
	
	
	public List<ProductCategory> getLCat() {
		Session session = factory.getCurrentSession();
		String hql = "from ProductCategory";
		Query query = session.createQuery(hql);
		List<ProductCategory> listCat = query.list();
		return listCat;
	}
	
	public ProductCategory getCat( String id) {
		Session session = factory.getCurrentSession();
		ProductCategory Cat = (ProductCategory) session.get(ProductCategory.class, id);
		return Cat;
	}
	
	public Product getProduct(String idProduct) {
		Session session = factory.getCurrentSession();
		Product pd = (Product) session.get(Product.class, idProduct);
		return pd;
	}
	
	
	
	public List<String> getLColor() {
		List<String> list = new ArrayList<String>();
		
		list.add("White");
		list.add("Black");
		list.add("Brown");
		list.add("Red");
		list.add("Green");
		list.add("Yellow");
		
		return list;
	}
	
	public List<String> getLBrand() {
		List<String> list = new ArrayList<String>();
		list.add("Nike");
		list.add("Louis Vuitton");
		list.add("GUCCI");
		list.add("Chanel");
		list.add("Adidas");
		list.add("Hermes");
		list.add("ZARA");
		list.add("H&M");
		list.add("Cartier");
		list.add("Dior");
		list.add("UNIQLO");
		
		return list;
	}
	
	public Map<Integer, String> getHMGender() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Nu");
		map.put(1, "Nam");
		return map;
	}
	
	public boolean saveProduct( Product prod) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(prod);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Insert product Failed");
			return false;
		} finally {
			session.close();
		}
		System.out.println("Insert product Success!");
		return true;
	}
	
	public boolean updateProduct( String prodID,
			String cat,
			String name,
			Float price,
			String image) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		Product prod = (Product) session.get(Product.class, prodID);
		
		prod.setProductCategory(getCat(cat));
		prod.setName(name);
		prod.setPrice(price);
		prod.setImage(image);
		
		try {
			session.update(prod);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Update product Failed");
			return false;
		} finally {
			session.close();
		}
		System.out.println("Update product Success!");
		return true;
	}
	
	public boolean deleteProduct( String prodID ) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		Product prod = (Product) session.get(Product.class, prodID);
		
		String hql = "DELETE SizeAndColor where pk.productID = " + prodID;
		
		try {
			Query query = session.createQuery(hql);
			int line = query.executeUpdate();
			System.out.println("There's " + line + " lines executes!");
			session.delete(prod);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Delete product Failed");
			System.out.println(e);
			return false;
		} finally {
			session.close();
		}
		System.out.println("Delete product Success!");
		return true;
	}
	
	public List<SizeAndColor> getLCS( String prodID) {
		Session session = factory.getCurrentSession();
		String hql = "from SizeAndColor where pk.productID = " + prodID;
		Query query = session.createQuery(hql);
		List<SizeAndColor> list = query.list();
		
		return list;
	}
	
	public SizeAndColor getCS( String ID, String color, String size) {
		Session session = factory.getCurrentSession();
		
		SizeAndColor.PK pk = new SizeAndColor.PK();
		pk.setProductID(ID);
		pk.setColor(color);
		pk.setSize(size);
		
		SizeAndColor cs = (SizeAndColor) session.get(SizeAndColor.class, pk);
		
		return cs;
	}
	
	public boolean saveCS(SizeAndColor cs) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(cs);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Insert cs Failed");
			return false;
		} finally {
			session.close();
		}
		System.out.println("Insert cs Success!");
		return true;
	}
	
	public boolean deleteCS( String id, String color, String size) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		SizeAndColor.PK pk = new SizeAndColor.PK();
		pk.setProductID(id);
		pk.setColor(color);
		pk.setSize(size);
		
		SizeAndColor cs = (SizeAndColor) session.get(SizeAndColor.class, pk);
		
		if(cs ==null) {
			System.out.println("NULL");
		} else {
			System.out.println("NOT NULL");
		}
		
		try {
			session.delete(cs);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Delete cs Failed");
			System.out.println(e);
			return false;
		} finally {
			session.close();
		}
		System.out.println("Delete cs Success!");
		return true;
	}
	
	public boolean updateCS( String id, String color, String size, Integer quantity) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		SizeAndColor.PK pk = new SizeAndColor.PK();
		pk.setProductID(id);
		pk.setColor(color);
		pk.setSize(size);
		
		SizeAndColor cs = (SizeAndColor) session.get(SizeAndColor.class, pk);
		cs.setQuantity(quantity);
	 
		
		try {
			session.update(cs);
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Update cs Failed");
			System.out.println(e);
			return false;
		} finally {
			session.close();
		}
		System.out.println("Update cs Success!");
		return true;
	}
}
