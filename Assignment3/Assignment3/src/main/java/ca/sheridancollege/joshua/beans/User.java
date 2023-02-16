package ca.sheridancollege.joshua.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	//Type Long translates to BIGINT in sql
	private Long userId;
	private String userName;
	private String encryptedPassword;
	public Long getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	
}
