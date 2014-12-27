package me.scape.ti.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:01:41
 */
public interface GenericDAO<T, PK extends Serializable> {
	
	List<T> findByQuery(String query, Map<String, Object> args);

	List<T> findByQuery(String query, Object[] args);
	
	T findOneByQuery(String query, Object[] args);
	
	T findOneByQuery(String query, Map<String, Object> args);

	List<T> findByQuery(String query);
	
	

	List<T> findByNamedQuery(String queryName, Map<String, Object> args);

	List<T> findByNamedQuery(String queryName, Object[] args);
	
	T findOneByNamedQuery(String queryName, Map<String, Object> args);

	T findOneByNamedQuery(String queryName, Object[] args);

	List<T> findByNamedQuery(String queryName);
	
	

	int updateByQuery(String query, Map<String, Object> args);

	int updateByQuery(String query, Object[] args);
	

	int updateByNamedQuery(String queryName, Map<String, Object> args);
	
	int updateByNamedQuery(String queryName, Object[] args);
	

	int updateByNativeQuery(String query, Object[] args);

	int updateByNativeQuery(String query, Map<String, Object> args);
	
	
	T findById(PK id);

	T persist(T entity);

	void flush();

	void clear();

	void remove(T entity);

	T merge(T entity);
}