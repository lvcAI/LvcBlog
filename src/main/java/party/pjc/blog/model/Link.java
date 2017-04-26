package party.pjc.blog.model;

/**
 * 链接实体类
 * 
 * @author lvc
 *
 */
public class Link {
	
	public static final int LINK_STATE_FIREND = 0;
	public static final int LINK_STATE_QUESION = 1;
	public static final int LINK_STATE_DELETE = 2;
	public static final int LINK_STATE_ME = 3;
	
    private Integer id;

    private String urlname;

    private String url;

    private Integer ordernum;

    private Integer state;	//0 : 友情链接；1：问题与解决. 2 : 回收 不显示在前台和后台;3:我的链接

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname == null ? null : urlname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getordernum() {
        return ordernum;
    }

    public void setordernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Link(Integer id, String urlname, String url, Integer ordernum, Integer state) {
		super();
		this.id = id;
		this.urlname = urlname;
		this.url = url;
		this.ordernum = ordernum;
		this.state = state;
	}

	public Link(Integer id, String urlname, Integer state) {
		super();
		this.id = id;
		this.urlname = urlname;
		this.state = state;
	}

	public Link(String urlname, Integer ordernum, Integer state) {
		super();
		this.urlname = urlname;
		this.ordernum = ordernum;
		this.state = state;
	}

	public Link(Integer state) {
		super();
		this.state = state;
	}

	
	public Link(String urlname, Integer state) {
		super();
		this.urlname = urlname;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", urlname=" + urlname + ", url=" + url + ", ordernum=" + ordernum + ", state="
				+ state + "]";
	}
    
    
}