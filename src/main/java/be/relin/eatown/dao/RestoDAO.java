package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.model.Resto;

public interface RestoDAO {

	public void save(Resto r);
    
    public List<Resto> list();
}
