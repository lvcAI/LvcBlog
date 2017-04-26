package party.pjc.blog.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import party.pjc.blog.dao.UserDao;
import party.pjc.blog.model.User;
import party.pjc.blog.service.UserService;
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return this.userDao.loginUser(user);
	}

	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getByUserName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getRoles(userName);
	}

	@Override
	public Set<String> getPermissions(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getPermissions(userName);
	}

	
}
