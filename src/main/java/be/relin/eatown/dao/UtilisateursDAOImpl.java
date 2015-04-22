package be.relin.eatown.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import be.relin.eatown.bean.Utilisateurs;

public class UtilisateursDAOImpl implements UtilisateursDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void save(Utilisateurs u) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u);
        tx.commit();
        session.close();
	}

	@Override
	public List<Utilisateurs> list() {
		Session session = this.sessionFactory.openSession();
        List<Utilisateurs> utilisateursList = session.createQuery("from Utilisateurs").list();
        session.close();
        return utilisateursList;
	}

}
