package com.adobe.assistance.beans;

public class SFDCConnectorData {
	
	private String userName;
	private String password;
	private String securityToken;
	private String clientId;
	private String clientSecret;
	private String loginUrl;
	
	public SFDCConnectorData(){
		super();
	}

	public SFDCConnectorData(String userName, String password, String securityToken, String clientId,
			String clientSecret, String loginUrl) {
		super();
		this.userName = userName;
		this.password = password;
		this.securityToken = securityToken;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.loginUrl = loginUrl;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityToken() {
		return securityToken;
	}
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	@Override
	public String toString() {
		return "SFDCConnectorData [userName=" + userName + ", password=" + password + ", securityToken=" + securityToken
				+ ", clientId=" + clientId + ", clientSecret=" + clientSecret + ", loginUrl=" + loginUrl + "]";
	}
	
}
