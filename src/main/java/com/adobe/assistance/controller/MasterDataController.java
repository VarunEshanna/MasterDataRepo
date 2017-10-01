package com.adobe.assistance.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.assistance.beans.MongoDbData;
import com.adobe.assistance.beans.SFDCConnectorData;
import com.adobe.assistance.beans.UserData;
import com.adobe.assistance.collections.MasterDataCollection;
import com.adobe.assistance.repository.MasterDataRepository;

@RestController
public class MasterDataController {
	
	@Autowired
	public MasterDataRepository masterDataRepository;
	
	@CrossOrigin	
	@RequestMapping(value = "/saveConnectorData", method = RequestMethod.POST)
	public String saveConnectorData(@RequestBody SFDCConnectorData sfdcConnectorData, @CookieValue(value = "userId", defaultValue = "hello") String userIdCookie, HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies){
            	System.out.println(cookie.getName());
            }
        }
		
		
		MasterDataCollection masterDataCollection = null;
		masterDataCollection = masterDataRepository.findByUserId(userIdCookie);
		if(masterDataCollection == null){
			masterDataCollection = new MasterDataCollection();
		}
		System.out.println(masterDataCollection);
		masterDataCollection.setSfdcConnector(sfdcConnectorData);
		masterDataCollection.setUserId(userIdCookie);
		System.out.println(masterDataCollection);
		masterDataRepository.save(masterDataCollection);
		return "Success";
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/saveLUISData", method = RequestMethod.POST)
	public String saveLuisUrlData(@RequestBody String luisUrl, @CookieValue(value = "userId", defaultValue = "hello") String userIdCookie){
		MasterDataCollection masterDataCollection = null;
		masterDataCollection = masterDataRepository.findByUserId(userIdCookie);
		if(masterDataCollection == null){
			masterDataCollection = new MasterDataCollection();
		}
		masterDataCollection.setLuisUrl(luisUrl);
		masterDataCollection.setUserId(userIdCookie);
		System.out.println(masterDataCollection);
		masterDataRepository.save(masterDataCollection);
		return "Success";
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public String saveUserData(@RequestBody UserData userData, @CookieValue(value = "userId", defaultValue = "hello") String userIdCookie){
		MasterDataCollection masterDataCollection = null;
		masterDataCollection = masterDataRepository.findByUserId(userIdCookie);
		if(masterDataCollection == null){
			masterDataCollection = new MasterDataCollection();
		}
		masterDataCollection.setUserDetails(userData);
		masterDataCollection.setUserId(userIdCookie);
		System.out.println(masterDataCollection);
		masterDataRepository.save(masterDataCollection);
		return "Success";
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/saveResponseData", method = RequestMethod.POST)
	public String saveResponseTypes(@RequestBody Boolean isChatEnabled, @RequestBody Boolean isVoiceEnabled, @CookieValue(value = "userId", defaultValue = "hello") String userIdCookie){
		MasterDataCollection masterDataCollection = null;
		masterDataCollection = masterDataRepository.findByUserId(userIdCookie);
		if(masterDataCollection == null){
			masterDataCollection = new MasterDataCollection();
		}
		masterDataCollection.setChatEnabled(Boolean.valueOf(isChatEnabled));
		masterDataCollection.setVoiceEnabled(Boolean.valueOf(isVoiceEnabled));
		masterDataCollection.setUserId(userIdCookie);
		System.out.println(masterDataCollection);
		masterDataRepository.save(masterDataCollection);
		return "Success";
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/saveMongoData", method = RequestMethod.POST)
	public String saveMongoData(@RequestBody MongoDbData mongoDbData, @CookieValue(value = "userId", defaultValue = "hello") String userIdCookie){
		MasterDataCollection masterDataCollection = null;
		masterDataCollection = masterDataRepository.findByUserId(userIdCookie);
		if(masterDataCollection == null){
			masterDataCollection = new MasterDataCollection();
		}
		masterDataCollection.setMongoDbDetails(mongoDbData);
		masterDataCollection.setUserId(userIdCookie);
		System.out.println(masterDataCollection);
		masterDataRepository.save(masterDataCollection);
		return "Success";
	}
	
	@CrossOrigin	
	@RequestMapping(value = "/getTempMasterData", method = RequestMethod.GET)
	public MasterDataCollection getData(String userName){
		MasterDataCollection masterDataCollection = new MasterDataCollection();
		masterDataCollection.setUserId("varun1804");
		
		UserData userDetails = new UserData();
		userDetails.setUsername("Varun");
		userDetails.setPassword("123456");
		userDetails.setEmail("eshanna@adobe.com");
		masterDataCollection.setUserDetails(userDetails);
		
		MongoDbData mongoDbDetails = new MongoDbData();
		mongoDbDetails.setUsername("eshanna");
		mongoDbDetails.setPassword("123456");
		mongoDbDetails.setHost("mlab.com");
		mongoDbDetails.setPort(12345);
		mongoDbDetails.setDatabase("va");
		masterDataCollection.setMongoDbDetails(mongoDbDetails);
		
		masterDataCollection.setLuisUrl("google.com");
		
		SFDCConnectorData sfdcConnectorData = new SFDCConnectorData();
		sfdcConnectorData.setUserName("eshannadev");
		sfdcConnectorData.setPassword("123455");
		sfdcConnectorData.setSecurityToken("asdfg");
		sfdcConnectorData.setLoginUrl("test.salesforce.com");
		sfdcConnectorData.setClientId("ABC");
		sfdcConnectorData.setClientSecret("DEF");
		masterDataCollection.setSfdcConnector(sfdcConnectorData);
		
		masterDataCollection.setChatEnabled(true);
		masterDataCollection.setVoiceEnabled(false);
		return masterDataCollection;
	}

}
