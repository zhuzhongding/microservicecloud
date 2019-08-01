package com.accp.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsUser;
import com.accp.service.BizService;

@Controller
public class BizAction {
	@Autowired
	private BizService bs;
	
	
	
	public BizService getBs() {
		return bs;
	}



	public void setBs(BizService bs) {
		this.bs = bs;
	}


	@RequestMapping("/login.action")
	public String login(@RequestParam(value="userCode") String userCode,
			@RequestParam(value="userPassword") String userPassword,
			HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		System.out.println("用户名："+userCode+"\t密码："+userPassword);
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("name", userCode);
		map.put("pwd", userPassword);
		List<SmbmsUser> list= bs.validateUser(map);
		if(list.size()>0){
			return "jsp/frame.jsp";
		}else{
			return "redirect:error.jsp";//重定向
		}
		
	}
	@RequestMapping("/bill.action")
	public String bill(Model model){
		List<SmbmsBill> listbill= bs.getAllBill();
		model.addAttribute("listbill", listbill);
		return "jsp/billlist.jsp";
	}
	
	
}
