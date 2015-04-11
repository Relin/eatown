package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.model.Lieux;

public interface LieuxDAO {

	public void save(Lieux l);
    
    public List<Lieux> list();
}
