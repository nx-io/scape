package me.scape.ti.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 封装EntityManager相关操作, 更容易使用。
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月1日 下午11:01:05
 */
public abstract class EntityManagerAccessor implements EntityManagerOperations, InitializingBean {

	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz) {
		return getEntityManager().createQuery(query, clazz);
	}

	@Override
	public <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Map<String, Object> args) {
		return queryMerger(getEntityManager().createQuery(query, clazz), args);
	}

	@Override
	public <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Object[] args) {
		return queryMerger(getEntityManager().createQuery(query, clazz), args);
	}

	@Override
	public <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz) {
		return getEntityManager().createNamedQuery(queryName, clazz);
	}

	@Override
	public <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Map<String, Object> args) {
		return queryMerger(getEntityManager().createNamedQuery(queryName, clazz), args);
	}

	@Override
	public <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Object[] args) {
		return queryMerger(getEntityManager().createNamedQuery(queryName, clazz), args);
	}

	@Override
	public Query createNativeQuery(String query, Class<?> clazz) {
		return getEntityManager().createNativeQuery(query, clazz);
	}

	@Override
	public Query createNativeQuery(String query, Class<?> clazz, Map<String, Object> args) {
		return queryMerger(getEntityManager().createNativeQuery(query, clazz), args);
	}

	@Override
	public Query createNativeQuery(String query, Class<?> clazz, Object[] args) {
		return queryMerger(getEntityManager().createNativeQuery(query, clazz), args);
	}

	@Override
	public final void afterPropertiesSet() throws Exception {
		init();
	}

	protected void init() throws Exception {

	}

	protected final <Q extends Query> Q queryMerger(Q query, Map<String, Object> args) {
		if (query == null || args == null || args.isEmpty()) {
			return query;
		}
		for (Map.Entry<String, Object> entry : args.entrySet()) {
			if (entry.getValue() instanceof java.util.Date) {
				query.setParameter(entry.getKey(), (java.util.Date) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			if (entry.getValue() instanceof java.sql.Date) {
				query.setParameter(entry.getKey(), (java.sql.Date) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			if (entry.getValue() instanceof java.util.Calendar) {
				query.setParameter(entry.getKey(), (java.util.Calendar) entry.getValue(), TemporalType.TIMESTAMP);
				continue;
			}
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	protected final <Q extends Query> Q queryMerger(Q query, Object[] args) {
		if (query == null || args == null || args.length <= 0) {
			return query;
		}
		int position = 1;
		for (Object value : args) {
			if (value instanceof java.util.Date) {
				query.setParameter(position++, (java.util.Date) value, TemporalType.TIMESTAMP);
				continue;
			}
			if (value instanceof java.sql.Date) {
				query.setParameter(position++, (java.sql.Date) value, TemporalType.TIMESTAMP);
				continue;
			}
			if (value instanceof java.util.Calendar) {
				query.setParameter(position++, (java.util.Calendar) value, TemporalType.TIMESTAMP);
				continue;
			}
			query.setParameter(position++, value);
		}
		return query;
	}

	public abstract EntityManager getEntityManager();
}