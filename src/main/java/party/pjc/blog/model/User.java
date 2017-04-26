package party.pjc.blog.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String userName;
	private String password;
	private String realName ;
	private String email;
	private String phone;
	private String bio;
	private String birthday;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", email=" + email + ", phone=" + phone + ", bio=" + bio + ", birthday=" + birthday + "]";
	}
	public User(int id, String userName, String passoword, String realName, String email, String phone, String bio,
			String birthday) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = passoword;
		this.realName = realName;
		this.email = email;
		this.phone = phone;
		this.bio = bio;
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String passoword) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = passoword;
	}
	
	 
	
	
}
