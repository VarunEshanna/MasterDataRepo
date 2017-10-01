package com.adobe.assistance.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.adobe.assistance.beans.MongoDbData;
import com.adobe.assistance.beans.SFDCConnectorData;
import com.adobe.assistance.beans.UserData;


@Document(collection="MasterData")
public class MasterDataCollection {
	
	public MasterDataCollection(){
		super();
	}
	
	public MasterDataCollection(String userId, UserData userDetails, MongoDbData mongoDbDetails, String luisUrl,
			SFDCConnectorData sfdcConnector, Boolean chatEnabled, Boolean voiceEnabled) {
		super();
		this.userId = userId;
		this.userDetails = userDetails;
		this.mongoDbDetails = mongoDbDetails;
		this.luisUrl = luisUrl;
		this.sfdcConnector = sfdcConnector;
		this.chatEnabled = chatEnabled;
		this.voiceEnabled = voiceEnabled;
	}
	@Id
	private String userId;
	@Field("USERDATA")
	private UserData userDetails;
	@Field("MONGODBDATA")
	private MongoDbData mongoDbDetails;
	@Field("LUISURL")
	private String luisUrl;
	@Field("SFDCCONNECTOR")
	private SFDCConnectorData sfdcConnector;
	@Field("CHATENABLED")
	private Boolean chatEnabled;
	@Field("VOICEENABLED")
	private Boolean voiceEnabled;
	
	public UserData getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserData userDetails) {
		this.userDetails = userDetails;
	}
	public MongoDbData getMongoDbDetails() {
		return mongoDbDetails;
	}
	public void setMongoDbDetails(MongoDbData mongoDbDetails) {
		this.mongoDbDetails = mongoDbDetails;
	}
	public String getLuisUrl() {
		return luisUrl;
	}
	public void setLuisUrl(String luisUrl) {
		this.luisUrl = luisUrl;
	}
	public SFDCConnectorData getSfdcConnector() {
		return sfdcConnector;
	}
	public void setSfdcConnector(SFDCConnectorData sfdcConnector) {
		this.sfdcConnector = sfdcConnector;
	}
	public Boolean getChatEnabled() {
		return chatEnabled;
	}
	public void setChatEnabled(Boolean chatEnabled) {
		this.chatEnabled = chatEnabled;
	}
	public Boolean getVoiceEnabled() {
		return voiceEnabled;
	}
	public void setVoiceEnabled(Boolean voiceEnabled) {
		this.voiceEnabled = voiceEnabled;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MasterDataCollection [userId=" + userId + ", userDetails=" + userDetails + ", mongoDbDetails="
				+ mongoDbDetails + ", luisUrl=" + luisUrl + ", sfdcConnector=" + sfdcConnector + ", chatEnabled="
				+ chatEnabled + ", voiceEnabled=" + voiceEnabled + "]";
	}

}
