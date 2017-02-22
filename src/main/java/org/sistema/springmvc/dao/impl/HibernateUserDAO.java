package org.sistema.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.sistema.springmvc.dao.UserDAO;
import org.sistema.springmvc.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hibernate implementation for a UserDAO.
 * 
 * @author Eugenia Pérez Martínez.
 *
 */

public class HibernateUserDAO implements UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * gives hibernate3 Session
	 * 
	 * @return current hibernate Session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Transactional
	public int insert(User user) {
		int id = (Integer) getSession().save(user);
		user.setId(id);

		return id;
	}
	

	@Transactional(readOnly = true)
	public User selectById(Integer id) {
		User user = (User) getSession().get(User.class, id);

		return user;
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> selectAll() {
		List<User> users = null;
		users = getSession().createQuery("from User").list();
		return users;
	}
	

	@Transactional
	public void delete(Integer id) {
		User user = (User) getSession().load(User.class, id);
		getSession().delete(user);
	}
	
	@Transactional
	public void deleteAll(){
		Query query = getSession().createQuery("DELETE from User c");
		query.executeUpdate();
	}
	
	@SuppressWarnings("Unchecked")
	@Transactional
	public List<User> AllOrdered(String ord){
		List<User> users = null;
		Criteria c = getSession().createCriteria(User.class);
		c.addOrder(Order.asc(ord));
		users = c.list();
		return users;
	}
	

	@Transactional(readOnly = true)
	public List<User> searchUsers(String login) {
		Query query = getSession().createQuery("FROM User c WHERE c.login LIKE :login");
		query.setParameter("login", "%" + login + "%");
		return query.list();
	}

	
	@Transactional
	public void update(User user) {
		getSession().merge(user);
	}


	
	
	
}
