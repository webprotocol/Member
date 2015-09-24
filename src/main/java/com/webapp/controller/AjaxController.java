package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webapp.dao.MemberDao;
import com.webapp.dao.MybatisMemberDao;
import com.webapp.dao.SpringMemberDao;
import com.webapp.model.Member;
import com.webapp.service.AuthService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Autowired
	MybatisMemberDao dao;
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public void getMembers(HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		List<Member> members = dao.selectAll();
		
		writer.println(gson.toJson(members));
	}
	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String getView() {
		
		return "ajax/view";
	}

	@RequestMapping(value="/array", method=RequestMethod.GET)
	public void getArray() {
	}
}
