package com.accp.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.BizDao;
import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsUser;
import com.accp.service.BizService;
@Service("bs")
public class BizServiceImpl implements BizService{
	@Autowired
	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public List<SmbmsUser> validateUser(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(map);
	}

	public List<SmbmsBill> getAllBill() {
		// TODO Auto-generated method stub
		return bizDao.getAllBill();
	}

	

}
