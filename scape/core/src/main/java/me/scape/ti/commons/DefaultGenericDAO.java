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
import javax.persistence.TypedQuery;

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

    @Override
    public List<T> findByNativeQuery(String query, Map<String, Object> args) {
        return createNativeQuery(query, args).getResultList();
    }

    @Override
    public List<T> findByNativeQuery(String query, Object[] args) {
        return createNativeQuery(query, args).getResultList();
    }

    @Override
    public T findOneByNativeQuery(String query, Object[] args) {
        return (T) createNativeQuery(query, args).getSingleResult();
    }

    @Override
    public T findOneByNativeQuery(String query, Map<String, Object> args) {
        return (T) createNativeQuery(query, args).getSingleResult();
    }

    @Override
    public List<T> findByNativeQuery(String query) {
        return createNativeQuery(query).getResultList();
    }

    @Override
    public List<T> findByQuery(String query, Map<String, Object> args) {
        return createQuery(query, args).getResultList();
    }

    @Override
    public List<T> findByQuery(String query, Object[] args) {
        return createQuery(query, args).getResultList();
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> args) {
        return createNamedQuery(queryName, args).getResultList();
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Object[] args) {
        return createNamedQuery(queryName, args).getResultList();
    }

    @Override
    public List<T> findByQuery(String query) {
        return createQuery(query).getResultList();
    }

    @Override
    public List<T> findByNamedQuery(String queryName) {
        return createNamedQuery(queryName).getResultList();
    }

    @Override
    public T findOneByQuery(String query, Object[] args) {
        return createQuery(query, args).getSingleResult();
    }

    @Override
    public T findOneByQuery(String query, Map<String, Object> args) {
        return createQuery(query, args).getSingleResult();
    }

    @Override
    public T findOneByNamedQuery(String queryName, Map<String, Object> args) {
        return createNamedQuery(queryName, args).getSingleResult();
    }

    @Override
    public T findOneByNamedQuery(String queryName, Object[] args) {
        return createNamedQuery(queryName, args).getSingleResult();
    }

    @Override
    public T findById(PK id) {
        return getEntityManager().find(getEntityType(), id);
    }

    @Override
    public final List<T> findAll() {
        return getEntityManager().createQuery("FROM " + entityType.getName()).getResultList();
    }

    @Override
    public T persist(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T merge(T entity) {
        getEntityManager().merge(entity);
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
    public int updateByQuery(String query, Map<String, Object> args) {
        return createQuery(query, args).executeUpdate();
    }

    @Override
    public int updateByQuery(String query, Object[] args) {
        return createQuery(query, args).executeUpdate();
    }

    @Override
    public int updateByNamedQuery(String queryName, Map<String, Object> args) {
        return createNamedQuery(queryName, args).executeUpdate();
    }

    @Override
    public int updateByNamedQuery(String queryName, Object[] args) {
        return createNamedQuery(queryName, args).executeUpdate();
    }

    @Override
    public int updateByNativeQuery(String query, Object[] args) {
        return createNativeQuery(query, args).executeUpdate();
    }

    @Override
    public int updateByNativeQuery(String query, Map<String, Object> args) {
        return createNativeQuery(query, args).executeUpdate();
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

    protected TypedQuery<T> createQuery(String query) {
        return createQuery(query, getEntityType());
    }

    protected TypedQuery<T> createNamedQuery(String queryName) {
        return createNamedQuery(queryName, getEntityType());
    }

    protected Query createNativeQuery(String query) {
        return createNativeQuery(query, getEntityType());
    }

    protected <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz) {
        return getEntityManager().createQuery(query, clazz);
    }

    protected <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz) {
        return getEntityManager().createNamedQuery(queryName, clazz);
    }

    protected Query createNativeQuery(String query, Class<?> clazz) {
        if (null == clazz) {
            return getEntityManager().createNativeQuery(query);
        }

        return getEntityManager().createNativeQuery(query, clazz);
    }

    protected <Q extends Query> Q setQuery(Q query, Map<String, Object> args) {
        if (query == null || args == null || args.isEmpty()) {
            return query;
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
        return query;
    }

    protected TypedQuery<T> createQuery(String query, Map<String, Object> args) {
        return setQuery(createQuery(query, getEntityType()), args);
    }

    protected TypedQuery<T> createNamedQuery(String queryName, Map<String, Object> args) {
        return setQuery(createNamedQuery(queryName, getEntityType()), args);
    }

    protected Query createNativeQuery(String query, Map<String, Object> args) {
        return setQuery(createNativeQuery(query, getEntityType()), args);
    }

    protected <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Map<String, Object> args) {
        return setQuery(getEntityManager().createQuery(query, clazz), args);
    }

    protected <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Map<String, Object> args) {
        return setQuery(getEntityManager().createNamedQuery(queryName, clazz), args);
    }

    protected Query createNativeQuery(String query, Class<?> clazz, Map<String, Object> args) {
        if (null == clazz) {
            return setQuery(getEntityManager().createNativeQuery(query), args);
        }

        return setQuery(getEntityManager().createNativeQuery(query, clazz), args);
    }

    protected <Q extends Query> Q setQuery(Q query, Object[] args) {
        if (query == null || args == null || args.length <= 0) {
            return query;
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
        return query;
    }

    protected TypedQuery<T> createQuery(String query, Object[] args) {
        return setQuery(createQuery(query, getEntityType()), args);
    }

    protected TypedQuery<T> createNamedQuery(String queryName, Object[] args) {
        return setQuery(createNamedQuery(queryName, getEntityType()), args);
    }

    protected Query createNativeQuery(String query, Object[] args) {
        return setQuery(createNativeQuery(query, getEntityType()), args);
    }

    protected <Q> TypedQuery<Q> createQuery(String query, Class<Q> clazz, Object[] args) {
        return setQuery(getEntityManager().createQuery(query, clazz), args);
    }

    protected <Q> TypedQuery<Q> createNamedQuery(String queryName, Class<Q> clazz, Object[] args) {
        return setQuery(getEntityManager().createNamedQuery(queryName, clazz), args);
    }

    protected Query createNativeQuery(String query, Class<?> clazz, Object[] args) {
        if (null == clazz) {
            return setQuery(getEntityManager().createNativeQuery(query), args);
        }

        return setQuery(getEntityManager().createNativeQuery(query, clazz), args);
    }

    protected Class<T> getEntityType() {
        return entityType;
    }
}