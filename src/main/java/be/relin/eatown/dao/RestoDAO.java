package be.relin.eatown.dao;

import java.util.List;

import be.relin.eatown.bean.Resto;

public interface RestoDAO {

	public void save(Resto r);
    
    public List<Resto> list();
}
