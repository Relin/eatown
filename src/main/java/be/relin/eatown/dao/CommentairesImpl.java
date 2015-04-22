package be.relin.eatown.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import be.relin.eatown.bean.Commentaires;

public class CommentairesImpl implements CommentairesDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void save(Commentaires c) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
	}

	@Override
	public List<Commentaires> list() {
		Session session = this.sessionFactory.openSession();
		List<Commentaires> commentairesList = session.createQuery("from Commentaires").list();
        session.close();
        return commentairesList;
	}

}
