package telinfoVO;

import java.util.Date;

public class TelInfoVO {
	private int id;
	private String name;
	private String tel;
	private Date d;
	
	public TelInfoVO() { }
	
	public TelInfoVO(int id, String name, String tel, Date d){
		super();
		this.setId(id);
		this.setName(name);
		this.setTel(tel);
		this.setD(d);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public Date getD() {
		return d;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setD(Date d) {
		this.d = d;
	}
	
	
}
