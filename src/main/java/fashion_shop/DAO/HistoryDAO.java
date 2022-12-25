package fashion_shop.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fashion_shop.entity.History;
import fashion_shop.entity.Product;
import fashion_shop.entity.SatisfyProduct;

@Transactional
@Repository
public class HistoryDAO {
	@Autowired
	SessionFactory factory;

	public HistoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public History saveHistory(History h) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.saveOrUpdate(h);
			t.commit();
			session.refresh(h);
			System.out.println(h.getId());
			return h;
		} catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
			session.close();
			return null;
		}
	}
	
	public History getHistory(int id) {
		Session session = factory.getCurrentSession();
		History e = (History) session.get(History.class, id);
		return e;
	}
	
	public SatisfyProduct updateSatisfyProduct(SatisfyProduct sp) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.saveOrUpdate(sp);
			transaction.commit();
			session.refresh(sp);
			session.close();
			System.out.println("update history success");
			return sp;
		} catch (Exception e) {
			transaction.rollback();
			session.close();
			e.printStackTrace();
			return null;
		}
	}
}
