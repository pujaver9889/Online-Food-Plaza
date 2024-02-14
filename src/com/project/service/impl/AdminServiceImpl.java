package com.project.service.impl;

import com.projec.dao.AdminDao;
import com.project.dao.impl.AdminDoImplUsingJdbc;
import com.project.dto.AdminDTO;
import com.project.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	AdminDao adminDao=new AdminDoImplUsingJdbc();
	
	

	@Override
	public boolean isAdminSave(AdminDTO admin) {
		// TODO Auto-generated method stub
		return adminDao.isAdminSave(admin);
		
	}

	@Override
	public boolean isAdminDeleted(String username) {
		// TODO Auto-generated method stub
		return adminDao.isAdminDeleted(username);
	}
	

}
