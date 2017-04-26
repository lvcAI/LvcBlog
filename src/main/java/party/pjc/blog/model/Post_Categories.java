package party.pjc.blog.model;

public class Post_Categories {

	private int post_id;
	private int categories_id;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	public Post_Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post_Categories(int post_id, int categories_id) {
		super();
		this.post_id = post_id;
		this.categories_id = categories_id;
	}
	@Override
	public String toString() {
		return "Post_Categories [post_id=" + post_id + ", categories_id=" + categories_id + "]";
	}
	
	
	
}
