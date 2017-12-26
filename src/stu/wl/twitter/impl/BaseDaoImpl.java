package stu.wl.twitter.impl;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

import stu.wl.twitter.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	private Class<T> entityClass;

	public BaseDaoImpl(){
		//返回表示此类的实体的超类的Type(就是extends后面的那个类，那时会显示泛型)
		Type type = this.getClass().getGenericSuperclass();
		//获取泛型数组
		Type[] params = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}
	@Override
	@Transactional
	public T get(Serializable id) {
		return hibernateTemplate.get(entityClass, id);
	}

	@Override
	public T load(Serializable id) {
		return hibernateTemplate.load(entityClass, id);
	}

	@Override
	public List<T> loadAll() {
		return hibernateTemplate.loadAll(entityClass);
	}

	@Override
	@Transactional
	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	@Override
	public void remove(T entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void removeAll(String tableName) {
		
	}

	@Override
	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	@Transactional
	public List find(String hql) {
		return hibernateTemplate.find(hql);
	}
	
	@Override
	public List find(String hql, Object... params) {
		return hibernateTemplate.find(hql, params);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Session getSession(){
		Session session=hibernateTemplate.getSessionFactory().openSession();
		return session;
	}
	
}
