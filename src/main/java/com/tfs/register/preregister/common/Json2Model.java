package com.tfs.register.preregister.common;

import org.springframework.stereotype.Repository;

import com.tfs.register.preregister.model.Company;
import com.tfs.register.preregister.model.UserMain;

import net.sf.json.JSONObject;

public class Json2Model {
	
	public Company json2Company(String jsonStr){
		
		Company company = new Company();
		
		JSONObject json = JSONObject.fromObject(jsonStr);  
		for(Object k : json.keySet()){
            String v = json.getString(k.toString());
			if(k.toString().equals("companyName")){
				company.setCompanyName(v);
			} else if(k.toString().equals("companyNameLocal")){
				company.setCompanyNameLocal(v);
			} else if(k.toString().equals("companyAddress")){
				company.setCompanyAddress(v);
			} else if(k.toString().equals("txtEmail")){
				company.setTxtEmail(v);
			} else if(k.toString().equals("telephone")){
				company.setTelephone(v);
			} else if(k.toString().equals("contactPerson")){
				company.setContactPerson(v);
			}
        }
		return company;
	}
	
public UserMain json2UserMain(String jsonStr){
		
	UserMain userMain = new UserMain();
		
		JSONObject json = JSONObject.fromObject(jsonStr);  
		for(Object k : json.keySet()){
            String v = json.getString(k.toString());
			if(k.toString().equals("companyName")){
				userMain.setCompanyNmEn(v);
			} else if(k.toString().equals("companyNameLocal")){
				userMain.setCompanyNmLocal(v);
			} else if(k.toString().equals("companyAddress")){
				userMain.setBizAddr(v);
			} else if(k.toString().equals("txtEmail")){
				userMain.setEmail(v);
			} else if(k.toString().equals("telephone")){
				userMain.setTelephone(v);
			} else if(k.toString().equals("contactPerson")){
				userMain.setContact(v);
			}
        }
		return userMain;
	}
}
