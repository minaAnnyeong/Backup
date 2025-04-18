package a02_toNforDB;

public class InfoVO {
	private String name;
	private String rsv_time;
	private String user_phone;
	private String menu_list;
	
	public InfoVO() {}
	
	public InfoVO(String name, String rsv_time, String menu_list, String user_phone) {
		//인자있는 생성자
		super();
		this.name = name;
		this.rsv_time = rsv_time;
		this.menu_list = menu_list;
		this.user_phone = user_phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRsv_time() {
		return rsv_time;
	}

	public void setRsv_time(String rsv_time) {
		this.rsv_time = rsv_time;
	}
	
	public String getMenu_list() {
		return menu_list;
	}

	public void setMenu_list(String menu_list) {
		this.menu_list = menu_list;
	}
	
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
}
