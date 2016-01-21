package com.tfs.register.preregister.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfs.register.preregister.mapper.UserMainMapper;
import com.tfs.register.preregister.model.Company;

@Service
public class ShowPreregisters {

	@Autowired
	UserMainMapper userMainMapper;
	
	
	public List<Company> showPreregisters() {
		List<Company> companys = userMainMapper.selectPreregisters();
		
		for(int i=0; i<companys.size(); i++) {
			Company company = new Company();
			company = companys.get(i);
			System.out.println("companyName:" + company.getCompanyName() + ", companyNameLocal: " + company.getCompanyNameLocal() 
				+ ", companyAddress:" + company.getCompanyAddress()
				+ ", txtEmail:" + company.getTxtEmail()
				+ ", telephone:" + company.getTelephone()
				+ ", contactPerson:" + company.getContactPerson());
		}
		
		return companys;
	}
}
