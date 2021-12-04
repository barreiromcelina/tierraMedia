package dao;

import java.util.ArrayList;

public interface GenericDAO<T> {

	public ArrayList<T> findAll();
	public int countAll();
	public int insert(T t);
	public int update(T t);
	public int delete(T t);
	
}
