package party.pjc.blog.model.vo;

public class EmailResult {

	
	private String toEmail;
	private String subject;
	private String context;
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
	public EmailResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailResult(String toEmail, String subject, String context) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.context = context;
	}
	
}
