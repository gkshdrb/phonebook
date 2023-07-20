package vo;

public class PhonebookVO {

	private int idx;
	private String hp;
	private String name;
	private String memo;
	
	public PhonebookVO() {
		// TODO Auto-generated constructor stub
	}

	public PhonebookVO(int idx, String hp, String name, String memo) {
		this.idx = idx;
		this.hp = hp;
		this.name = name;
		this.memo = memo;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhonebookVO [idx=" + idx + ", hp=" + hp + ", name=" + name + ", memo=" + memo + "]";
	}
	
	
}
