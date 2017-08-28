package party.pjc.blog.model;

import java.sql.Timestamp;
import java.util.Date;

public class Notice {
	
    private Integer id;

    private String title;

    private Timestamp addTime;

    private String ip;

    private String bookname;

    private Integer type;

    public Notice(Integer id, String title, Timestamp addTime, String ip, String bookname, Integer type) {
        this.id = id;
        this.title = title;
        this.addTime = addTime;
        this.ip = ip;
        this.bookname = bookname;
        this.type = type;
    }

    public Notice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    
    
	public Notice(int type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", addTime=" + addTime + ", ip=" + ip + ", bookname="
				+ bookname + ", type=" + type + "]";
	}
    
    
}