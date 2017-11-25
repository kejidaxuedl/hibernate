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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
			Query q = session.createQuery("from User where userName = ?");
			q.setParameter(0, UserName);
			//ִ�в�ѯ
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tx = session.beginTransaction();
			//������ѯ
			Query q = session.createQuery("from User ");
			//���÷�ҳ����
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
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
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
