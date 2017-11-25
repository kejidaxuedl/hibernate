package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 张睿璇
 * util
 */
public class HibernateUtils {
	private static SessionFactory sf;
	static {
		//加载主配置文件，并创建工厂
		sf = new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession(){
		return sf.openSession();
	}
}
