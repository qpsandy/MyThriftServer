package com.tfs.register.preregister;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfs.register.preregister.common.Json2Model;
import com.tfs.register.preregister.mapper.UserMainMapper;
import com.tfs.register.preregister.model.Company;
import com.tfs.register.preregister.model.UserMain;
import com.tfs.register.preregister.service.CreateUser;

@Component
public class MyThriftImpl implements MyThriftService.Iface {

	@Autowired
	private UserMainMapper userMainMapper;
	
	@Autowired
	CreateUser createUser;
	
	public MyThriftImpl(){
	}
		
	@Override
	public String sayHello(String username) throws TException {		
		
		//createUser.createUserMain(username);
		
		Json2Model json2Model = new Json2Model();
		UserMain userMain = new UserMain();
		
		userMain = json2Model.json2UserMain(username);
		
		System.out.println(username);
		System.out.println("companyName: " + userMain.getCompanyNmEn());
		System.out.println("companyNameLocal: " + userMain.getCompanyNmLocal());
		System.out.println("companyAddress: " + userMain.getBizAddr());
		System.out.println("txtEmail: " + userMain.getEmail());
		System.out.println("telephone: " + userMain.getTelephone());
		System.out.println("contactPerson: " + userMain.getContact());
		
		
		if(createUser==null)
			System.out.println("createUser is null pointer!!!!");
		else
			System.out.println("createUser:"+createUser.getClass());
		
		
		if(userMainMapper==null){
			System.out.println("userMainMapper is null pointer!!!!");
		}
		else
			System.out.println("userMainMapper:"+userMainMapper.getClass());
		userMainMapper.insert(userMain);
		
		return userMain.getCompanyNmEn();  
	}
	
	@Override
	public List<Company> showCompanys() {

		return userMainMapper.selectPreregisters();
	}
}
