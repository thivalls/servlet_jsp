package models;

public class Login {
	private String user;
	private String password;
	
	private final String USER = "admin";
	private final String PASS = "123";
	
	public Login() {
		
	}

	public Login(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean login() {
		if (user.equals(USER) && password.equals(PASS)) {
			return true;
		}
		return false;
	}
}
