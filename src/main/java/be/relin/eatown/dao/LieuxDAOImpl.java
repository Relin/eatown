package be.relin.eatown.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import be.relin.eatown.bean.Lieux;

public class LieuxDAOImpl implements LieuxDAO{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void save(Lieux l) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(l);
        tx.commit();
        session.close();
	}

	@Override
	public List<Lieux> list() {
		Session session = this.sessionFactory.openSession();
        List<Lieux> lieuxList = session.createQuery("from Lieux").list();
        session.close();
        return lieuxList;
	}

}
