package po;

public class User {
	private String username;
	private String password;
	
	public User() {
		super();
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "userName="+username+",userPassword="+password;
	}
	
	

}
