package lt.sklandymas.mamavys.repository;

import java.util.List;

import com.google.appengine.api.datastore.Key;

public interface GenericRepository<T> {
	Class<T> getEntityClass();

	T save(T entity);
	
	List<T> findAll();
	
	T getByKey(Key key);
	
	T getByKey(String keyString);
}
