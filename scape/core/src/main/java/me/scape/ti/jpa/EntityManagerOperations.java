package me.scape.ti.jpa;

import java.util.Map;

import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月2日 下午3:27:58
 */
public interface EntityManagerOperations {
	
	Query createQuery(String ql);

	Query createQuery(String ql, Map<String, Object> args);

	Query createQuery(String ql, Object[] args);
	
	<T> TypedQuery<T> createQuery(String ql, Class<T> clazz);

	<T> TypedQuery<T> createQuery(String ql, Class<T> clazz, Map<String, Object> args);

	<T> TypedQuery<T> createQuery(String ql, Class<T> clazz, Object[] args);

	Query createNamedQuery(String name);

	Query createNamedQuery(String name, Map<String, Object> args);

	Query createNamedQuery(String name, Object[] args);
	
	<T> TypedQuery<T> createNamedQuery(String name, Class<T> clazz);

	<T> TypedQuery<T> createNamedQuery(String name, Class<T> clazz, Map<String, Object> args);

	<T> TypedQuery<T> createNamedQuery(String name, Class<T> clazz, Object[] args);

	Query createNativeQuery(String sql);

	Query createNativeQuery(String sql, Map<String, Object> args);

	Query createNativeQuery(String sql, Object[] args);
	
	Query createNativeQuery(String sql, Class<?> clazz);

	Query createNativeQuery(String sql, Class<?> clazz, Map<String, Object> args);

	Query createNativeQuery(String sql, Class<?> clazz, Object[] args);

	<T> T persist(T entity);
	
	<T> void remove(T entity);

	<T> T merge(T entity);
	
	<T, PK> T get(Class<T> clazz, PK primaryKey);
	<T, PK> T get(Class<T> clazz, PK primaryKey, LockModeType lockMode);
	<T, PK> T load(Class<T> clazz, PK primaryKey);
	
	<T> T refresh(T entity);
	<T> T refresh(T entity, LockModeType lockMode);

	void flush();

	void clear();
}