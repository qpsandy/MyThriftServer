package com.tfs.register.preregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfs.register.preregister.common.Json2Model;
//import com.tfs.register.preregister.mapper.CompanyMapper;
import com.tfs.register.preregister.mapper.UserMainMapper;
import com.tfs.register.preregister.model.Company;
import com.tfs.register.preregister.model.UserMain;

@Service
public class CreateUser {
	
	//@Autowired
	//CompanyMapper companyMapper;
	
	@Autowired
	UserMainMapper userMainMapper;
	
	public void create(String jsonStr) {
		
		Json2Model json2Model = new Json2Model();
		Company company = new Company();
		
		company = json2Model.json2Company(jsonStr);
		
		System.out.println(jsonStr);
		System.out.println("companyName: " + company.getCompanyName());
		System.out.println("companyNameLocal: " + company.getCompanyNameLocal());
		System.out.println("companyAddress: " + company.getCompanyAddress());
		System.out.println("txtEmail: " + company.getTxtEmail());
		System.out.println("telephone: " + company.getTelephone());
		System.out.println("contactPerson: " + company.getContactPerson());
		
		//companyMapper.insertCompany(company);
	}
	
	public void createUserMain(String jsonStr) {
		
		Json2Model json2Model = new Json2Model();
		UserMain userMain = new UserMain();
		
		userMain = json2Model.json2UserMain(jsonStr);
		
		System.out.println(jsonStr);
		System.out.println("companyName: " + userMain.getCompanyNmEn());
		System.out.println("companyNameLocal: " + userMain.getCompanyNmLocal());
		System.out.println("companyAddress: " + userMain.getBizAddr());
		System.out.println("txtEmail: " + userMain.getEmail());
		System.out.println("telephone: " + userMain.getTelephone());
		System.out.println("contactPerson: " + userMain.getContact());
		
		userMainMapper.insert(userMain);
	}
	
	public void test(String jsonStr){
		System.out.println(jsonStr);
	}
}
