package com.tfs.register.preregister.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tfs.register.preregister.service.CreateUser;



//@RunWith(SpringJUnit4ClassRunner.class)
public class testCreateUser {

	@Autowired
	private CreateUser createUser;
	//CreateUser createUser = new CreateUser();
	
	@Test
	public void testCreate(){
		
		String jsonStr = "{'companyName':'Lejia', 'companyNameLocal':'Lejia', 'companyAddress':'Guangdong', 'txtEmail':'qpsandy@126.com', 'telephone':'17721217320', 'contactPerson':'Molly'}";
		createUser.createUserMain(jsonStr);
		
	}
}
