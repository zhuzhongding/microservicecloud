package com.accp.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsUser;
@Repository("bizDao")
public interface BizDao {
	List<SmbmsUser> validateUser(HashMap<String, String> map);
	
	List<SmbmsBill> getAllBill();
}
