package main.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class UserDto {

	private String userId;
	private String username;
	private String password;
	private String email;
	private Date birthDate;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public UserDto() {}
	
	public UserDto(String userId, String username, String password, String email, Date birthDate, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	};

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	};
	
}
