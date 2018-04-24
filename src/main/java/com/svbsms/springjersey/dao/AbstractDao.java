package com.svbsms.springjersey.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<PK extends Serializable, T> {

//		private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);
		
		private final Class<T> persistentClass;
//		private Map<PK, T> persistance = new HashMap<PK, T>();

		@SuppressWarnings("unchecked")
		public AbstractDao(){
			this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		}

		/*public T getByKey(PK key) {
			return (T) getSession().get(persistentClass, key);
		}

		public void persist(T entity) {
			LOGGER.info("persist() " + entity);
			getSession().persist(entity);
		}

		public void save(T entity) {
			LOGGER.info("save() " + entity);
			getSession().save(entity);
		}

		public void update(T entity) {
			LOGGER.info("update() " + entity);
			getSession().update(entity);
		}

		public void saveOrUpdate(T entity) {
			LOGGER.info("saveOrUpdate() " + entity);
			getSession().saveOrUpdate(entity);
		}

		public void delete(T entity) {
			LOGGER.info("delete() " + entity);
			getSession().delete(entity);
		}

		public void evict(T entity) {
			LOGGER.info("evict() " + entity);
			// remove from first level cache
			getSession().evict(entity);
		}

		protected Criteria createEntityCriteria(){
			LOGGER.info("createEntityCriteria()");
			return getSession().createCriteria(persistentClass);
		}*/
	
}
