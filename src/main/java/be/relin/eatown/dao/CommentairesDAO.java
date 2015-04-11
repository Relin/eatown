package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.model.Commentaires;

public interface CommentairesDAO {

	public void save(Commentaires c);
    
    public List<Commentaires> list();
}
