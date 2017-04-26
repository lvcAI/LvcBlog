package party.pjc.blog.model.vo;

public class Result {
	public static final Integer SUCCESS = 0;
	public static final Integer FAIL = 1;
	
	private Integer code = SUCCESS;
	private String  message = "";
	private String  remark  = null;
	private String  data    = null;
	private Integer resultCode =SUCCESS;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	
	
}
