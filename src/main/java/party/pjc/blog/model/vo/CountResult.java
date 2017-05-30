package party.pjc.blog.model.vo;

/**
 * 查询 记录数的 通用类，查询
 * @author lvc
 *
 */
public class CountResult {

	private String typeName;	//类型名字
	private int typeId;			// 类型 Id
	private int count;			// 记录数
	
	
	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public CountResult(String typeName, int typeId, int count) {
		super();
		this.typeName = typeName;
		this.typeId = typeId;
		this.count = count;
	}


	public CountResult() {
		super();
	}


	@Override
	public String toString() {
		return "CountResult [typeName=" + typeName + ", typeId=" + typeId + ", count=" + count + "]";
	}
	
	
	
}
