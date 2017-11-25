package crud;

import java.io.Serializable;
import java.util.List;

import bean.User;

public interface IUserDao {
	void save(User user);
	void update(User user);
	User findById(Serializable id);
	List<User> getAll();
	List<User> getAll(String UserName);
	List<User> getAll(int index, int count);
	void delete(Serializable id);
}
