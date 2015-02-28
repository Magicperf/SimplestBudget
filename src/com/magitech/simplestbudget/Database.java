package com.magitech.simplestbudget;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class Database {
	public User LoadUserData(){
		User user = new User();
		
		return user;
	}
	public void SaveUserData(User user){
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try{
        	icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("http://www.magicTech.com/XMLUser","Accounts");
            doc.appendChild(mainRootElement);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
