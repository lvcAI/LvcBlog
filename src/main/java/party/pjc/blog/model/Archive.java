package party.pjc.blog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Archive {

	private int id;
	private String archiveName;
	private String url_name;

	private Long count;
	private List<Post> posts = new ArrayList<Post>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getUrl_name() {
		return url_name;
	}
	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}
	
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "Archive [id=" + id + ", archiveName=" + archiveName + ", url_name=" + url_name + ", count=" + count
				+ ", posts=" + posts + "]";
	}
	public Archive() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
