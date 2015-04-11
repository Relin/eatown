package be.relin.eatown.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import be.relin.eatown.model.Resto;

public class RestoDAOImpl implements RestoDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void save(Resto r) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(r);
        tx.commit();
        session.close();
	}

	@Override
	public List<Resto> list() {
		Session session = this.sessionFactory.openSession();
        List<Resto> restoList = session.createQuery("from Resto").list();
        session.close();
        return restoList;
	}

}
