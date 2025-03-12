package logreg;



public class Adminandstudentmodel {
	
	private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String role; // "STUDENT" or "ADMIN"

    public int getId() {
		return id;
    	
    }
    
    public void setId(int id) {
    	this.id=id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
    	
    	if(name == null || name.isEmpty()) {
    		throw new IllegalArgumentException("name cannot be null");
    	}
        this.name = name;
    }

    public String getEmail() {
    	
        return email;
    }

    public void setEmail(String email) {
    	
    	if(email == null || email.isEmpty()) {
    		throw new IllegalArgumentException("email cannot be null");
    	}
    	
        this.email = email;
    }

    public String getPhone() {
    	
        return phone;
    }

    public void setPhone(String phone) {
    	
    	if(phone == null || phone.isEmpty()) {
    		throw new IllegalArgumentException("phone cannot be null");
    	}
    	
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    	
    	if(username == null || username.isEmpty()) {
    		throw new IllegalArgumentException("username cannot be null");
    	}
    	
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	
    	if(password == null || password.isEmpty()) {
    		throw new IllegalArgumentException("password cannot be null");
    	}
        this.password = password;
    }

    public String getRole() {
    	
        return role;
    }

    public void setRole(String role) {
    	
    	if(role == null || role.isEmpty()) {
    		throw new IllegalArgumentException("role cannot be null");
    	}
    	
        this.role = role;
    }
}

