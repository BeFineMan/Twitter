package stu.wl.twitter.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	T get(Serializable id);
	T load(Serializable id);
	List<T> loadAll();
	void save(T entity);
	void remove(T entity);
	void removeAll(String tableName);
	void update(T entity);
	List find(String hql);
	List find(String hql,Object...params);
}
 