package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.bean.Commentaire;

public interface CommentairesDAO {

	public void save(Commentaire c);
    
    public List<Commentaire> list();
}
