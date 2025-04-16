package login_admin;

public class LoginAdminVO {
	// 운영자 로그인 속성 : id, pw
	private String id;
	private String pw;
	
	public LoginAdminVO() { }
	
	public LoginAdminVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
