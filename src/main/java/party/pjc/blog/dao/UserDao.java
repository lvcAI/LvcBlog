package party.pjc.blog.dao;

import java.util.Set;

import party.pjc.blog.model.User;


public interface UserDao {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User loginUser(User user);
	/** 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String userName);
}
