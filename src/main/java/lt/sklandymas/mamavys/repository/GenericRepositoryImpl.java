package lt.sklandymas.mamavys.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public T save(T entity) {
		getEntityManager().persist(entity);
		return getEntityManager().merge(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String gql = String.format("SELECT FROM %s o", getEntityClass().getSimpleName());
		Query q = getEntityManager().createQuery(gql);
		return q.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	};
}
