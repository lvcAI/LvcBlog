package party.pjc.blog.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Tags implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String tagName;
	
	private List<Post> posts;
	

	public int getId() {
		return id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	

	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tags(String tagName) {
		super();
		this.tagName = tagName;
	}
	
	@Override
	public String toString() {
		return "Tags [id=" + id + ", tagName=" + tagName + ", posts=" + posts + "]";
	}
	public Tags(int id, String tagName) {
		super();
		this.id = id;
		this.tagName = tagName;
	}
	
	
}
