package party.pjc.blog.model;

public class Post_Tags {

	private int post_id;
	private int tag_id;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public Post_Tags(int post_id, int tag_id) {
		super();
		this.post_id = post_id;
		this.tag_id = tag_id;
	}
	public Post_Tags() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
