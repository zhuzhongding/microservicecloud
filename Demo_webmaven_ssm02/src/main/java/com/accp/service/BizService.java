package com.accp.service;

import java.util.HashMap;
import java.util.List;

import com.accp.dao.BizDao;
import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsUser;

public interface BizService extends BizDao{
	
	public List<SmbmsUser> validateUser(HashMap<String, String> map);
	
	public List<SmbmsBill> getAllBill();
	
}
