package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDAO<T> {

	public ArrayList<T> findAll();
	public int countAll();
	public void insert(T t) throws SQLException;
	public int update(T t) throws SQLException;
	public int delete(T t);
	
}
