package lt.sklandymas.mamavys.repository;

import java.util.List;

public interface GenericRepository<T> {
	Class<T> getEntityClass();

	T save(T entity);
	
	List<T> findAll();
}
