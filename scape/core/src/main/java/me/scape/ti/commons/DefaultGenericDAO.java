package me.scape.ti.commons;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月17日 下午11:11:22
 */
@SuppressWarnings("unchecked")
public class DefaultGenericDAO<T, PK extends Serializable> implements GenericDAO<T, PK>, InitializingBean {

	protected Logger log = LoggerFactory.getLogger(getClass());

	@PersistenceContext(name = "scape")
	protected EntityManager entityManager;
	
	protected final Class<T> entityType;
	
	public DefaultGenericDAO() {
		entityType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected List<T> findByQuery(Query query, Map<String, Object> args) {
		if (args == null || args.isEmpty()) {
			return query.getResultList();
		}
		for (Map.Entry<String, Object> entry : args.entrySet()) {
			if (entry.getValue() instanceof Date) {
				query.setParameter(entry.getKey(), (Date) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			if (entry.getValue() instanceof java.sql.Date) {
				query.setParameter(entry.getKey(), (java.sql.Date) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			if (entry.getValue() instanceof Calendar) {
				query.setParameter(entry.getKey(), (Calendar) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	protected List<T> findByQuery(Query query, Object[] args) {
		if (args == null || args.length <= 0) {
			return query.getResultList();
		}
		int position = 1;
		for (Object value : args) {
			if (value instanceof Date) {
				query.setParameter(position++, (Date) value, TemporalType.TIMESTAMP);
				continue;
			}
			if (value instanceof java.sql.Date) {
				query.setParameter(position++, (java.sql.Date) value, TemporalType.TIMESTAMP);
				continue;
			}
			if (value instanceof Calendar) {
				query.setParameter(position++, (Calendar) value, TemporalType.TIMESTAMP);
				continue;
			}
			query.setParameter(position++, value);
		}
		return query.getResultList();
	}

	@Override
	public List<T> findByQuery(String query, Map<String, Object> args) {
		return findByQuery(getEntityManager().createQuery(query), args);
	}

	@Override
	public List<T> findByQuery(String query, Object[] args) {
		return findByQuery(getEntityManager().createQuery(query), args);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Map<String, Object> args) {
		return findByQuery(getEntityManager().createNamedQuery(queryName), args);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object[] args) {
		return findByQuery(getEntityManager().createNamedQuery(queryName), args);
	}

	@Override
	public List<T> findByQuery(String query) {
		return findByQuery(getEntityManager().createQuery(query), new Object[]{});
	}

	@Override
	public List<T> findByNamedQuery(String queryName) {
		return findByQuery(getEntityManager().createNamedQuery(queryName), new Object[]{});
	}

	@Override
	public T findById(PK id) {
		return getEntityManager().find(getEntityType(), id);
	}

	@Override
	public T persist(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public void flush() {
		getEntityManager().flush();
	}

	@Override
	public void clear() {
		getEntityManager().clear();
	}

	@Override
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public final void afterPropertiesSet() throws Exception {
		init();
	}
	
	protected void init() throws Exception {
		
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected Class<T> getEntityType() {
		return entityType;
	}
}