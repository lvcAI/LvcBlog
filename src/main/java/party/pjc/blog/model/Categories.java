package party.pjc.blog.model;

import java.util.List;

public class Categories {

	private int id;
	private String categoriesName;
	private List<Post> posts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoriesName() {
		return categoriesName;
	}
	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Categories(int id, String categoriesName) {
		super();
		this.id = id;
		this.categoriesName = categoriesName;
	}
	public Categories(String categoriesName) {
		super();
		this.categoriesName = categoriesName;
	}
	public Categories(int id, String categoriesName, List<Post> posts) {
		super();
		this.id = id;
		this.categoriesName = categoriesName;
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoriesName=" + categoriesName + ", posts=" + posts + "]";
	}
	

	
	
}
