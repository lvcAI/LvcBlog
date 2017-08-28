package party.pjc.blog.model;

import java.sql.Timestamp;
import java.util.Date;

public class Comment {
    private Integer id;

    private Integer postId;

    private Timestamp createdate;

    private Integer state;

    private Integer commentId;

    private String email;

    private String context;

    private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

 

  
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Comment(Integer id, Integer postId, Timestamp createdate, Integer state, Integer commentId, String email,
			String context) {
		super();
		this.id = id;
		this.postId = postId;
		this.createdate = createdate;
		this.state = state;
		this.commentId = commentId;
		this.email = email;
		this.context = context;
	}
	
	

	public Comment(  String context, String name,String email,Integer state) {
		//super();
		this.state = state;
		this.email = email;
		this.context = context;
		this.name = name;
	}

	public Comment(Integer state, String context) {
		super();
		this.state = state;
		this.context = context;
	}

	public Comment(Integer postId, Integer state, String context) {
		super();
		this.postId = postId;
		this.state = state;
		this.context = context;
	}

	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", createdate=" + createdate + ", state=" + state
				+ ", commentId=" + commentId + ", email=" + email + ", context=" + context + ", name=" + name + "]";
	}

	
    
    public static void main(String[] args) {
    	System.out.println(new Comment().getCreatedate());
	}
    
}