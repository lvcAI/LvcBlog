package party.pjc.blog.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class Post {

	private int id;
	private String title;
	private String html;
	private String markdown;
	private Timestamp createDate = new Timestamp(new Date().getTime());
	private Timestamp lastEditDate = new Timestamp(new Date().getTime());
	public Post(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	private int state;
	private long rate;
	
	private User user;
	private Archive archive;
	
	private Categories categories;
	private List<Tags> tags;
	
	
	public int getId() {
		return id;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getMarkdown() {
		return markdown;
	}
	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Archive getArchive() {
		return archive;
	}
	public void setArchive(Archive archive) {
		this.archive = archive;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", html=" + html + ", markdown=" + markdown + ", createDate="
				+ createDate + ", lastEditDate=" + lastEditDate + ", state=" + state + ", rate=" + rate + ", user="
				+ user + ", archive=" + archive + ", categories=" + categories + ", tags=" + tags + "]";
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int id, String title, String html, String markdown, Timestamp createDate, Timestamp lastEditDate,
			int state, long rate, User user, Archive archive) {
		super();
		this.id = id;
		this.title = title;
		this.html = html;
		this.markdown = markdown;
		this.createDate = createDate;
		this.lastEditDate = lastEditDate;
		this.state = state;
		this.rate = rate;
		this.user = user;
		this.archive = archive;
	}
	public Post(int id, String title, String html, String markdown, Timestamp createDate, Timestamp lastEditDate,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.html = html;
		this.markdown = markdown;
		this.createDate = createDate;
		this.lastEditDate = lastEditDate;
		this.user = user;
	}
	
	public static void main(String[] args) {
		System.out.println(new Post().getCreateDate());
	}
	
}
