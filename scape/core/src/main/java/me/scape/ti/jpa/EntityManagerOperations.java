package me.scape.ti.jpa;

import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月2日 下午3:27:58
 */
public interface EntityManagerOperations {

	<Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz);

	<Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Map<String, Object> args);

	<Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Object[] args);

	<Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz);

	<Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Map<String, Object> args);

	<Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Object[] args);

	Query createNativeQuery(String query, Class<?> clazz);

	Query createNativeQuery(String query, Class<?> clazz, Map<String, Object> args);

	Query createNativeQuery(String query, Class<?> clazz, Object[] args);

}