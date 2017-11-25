package text;

import java.io.Serializable;

import bean.User;
import crud.impl.UserDao;

/**
 * @author 张睿璇
 * text
 */
public class Text{
	public static void main(String[] args) {
		Text text = new Text();
		//text.findById(1);
		//text.getAll();
		//参数从0开始，很坑
		//text.getAll("jack");
		//text.getAll(0, 2);
		//text.save(new User());
		/*User user =new User();
		user.setId(3);
		user.setUserName("xutao");
		text.update(user);*/
		text.delete(3);
	}
	UserDao dao = new UserDao();

	public void save(User user) {
		dao.save(user);
	}

	public void update(User user) {
		dao.update(user);
	}

	public void findById(Serializable id) {
		System.out.println(dao.findById(id));
	}

	public void getAll() {
		System.out.println(dao.getAll());
	}

	public void getAll(String UserName) {
		System.out.println(dao.getAll(UserName));
	}

	public void getAll(int index, int count) {
		System.out.println(dao.getAll(index, count));
	}

	public void delete(Serializable id) {
		dao.delete(id);
	}
	
}
