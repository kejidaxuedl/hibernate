package crud.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.User;
import crud.IUserDao;
import util.HibernateUtils;

public class UserDao implements IUserDao{

	@Override
	public void save(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			session.save(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public void update(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			session.update(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public User findById(Serializable id) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			return (User) session.get(User.class, 1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<User> getAll() {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			return session.createQuery("from User").list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<User> getAll(String UserName) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			Query q = session.createQuery("from User where userName = ?");
			q.setParameter(0, UserName);
			//执行查询
			return q.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public List<User> getAll(int index, int count) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			//主键查询
			Query q = session.createQuery("from User ");
			//设置分页参数
			q.setFirstResult(index);
			q.setMaxResults(count);
			List<User> list = q.list();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}

	@Override
	public void delete(Serializable id) {
		Session session = null;
		Transaction tx = null;
		try {
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tx = session.beginTransaction();
			Object obj = session.get(User.class, id);
			if(obj != null){
				session.delete(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			tx.commit();
			session.close();
		}
	}
	
}
