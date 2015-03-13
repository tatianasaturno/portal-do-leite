package models.dao;

import java.util.List;

import javax.persistence.Query;

public interface AbstractDAO<T>{
	
	public void flush();
	
	public void commitAndContinue();
	
	public void commit();
	
	public void refresh(T obj);
	
	public void merge(T obj);
	
	public void persist(T obj);
	
	public void remove(T obj);
	
	public void removeElementById(Class<T> clazz, Long id);
	
	public T getElementById(Class<T> clazz, Long id);
	
	public List<T> getAllByClass(Class<T> clazz);
	
	public List<T> getByAttributeName(Class<T> clazz, String attributeName, String attributeValue);
	
	public Query createQuery(String query);

}
