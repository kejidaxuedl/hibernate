package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ����
 * util
 */
public class HibernateUtils {
	private static SessionFactory sf;
	static {
		//�����������ļ�������������
		sf = new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession(){
		return sf.openSession();
	}
}
