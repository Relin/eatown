package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.bean.Utilisateurs;

public interface UtilisateursDAO {

	public void save(Utilisateurs u);
    
    public List<Utilisateurs> list();
}
