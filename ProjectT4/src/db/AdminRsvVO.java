package db;

public class AdminRsvVO {
	private int adminRsvId;
	private int userRsvId; // Sequence from TABLE user_rsv
	private String adminId;// FK from TABLE admin_acc
	
	public AdminRsvVO() { }
	
	public AdminRsvVO(int adminRsvId, int userRsvId, String adminId) {
		super();
		this.adminRsvId = adminRsvId;
		this.userRsvId = userRsvId;
		this.adminId = adminId;
	}

	public int getAdminRsvId() {
		return adminRsvId;
	}

	public void setAdminRsvId(int adminRsvId) {
		this.adminRsvId = adminRsvId;
	}

	public int getUserRsvId() {
		return userRsvId;
	}

	public void setUserRsvId(int userRsvId) {
		this.userRsvId = userRsvId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	
} 
