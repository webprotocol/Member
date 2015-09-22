package com.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.webapp.command.Hobby;
import com.webapp.command.MemberCommand;
import com.webapp.exception.AlreadyExistingMemberException;
import com.webapp.model.Member;
import com.webapp.service.MemberRegisterService;
import com.webapp.validator.MemberCommandValidator;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

	static Log log = LogFactory.getLog(MemberRegisterController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MemberRegisterService service;
	
	@Autowired
	MemberCommandValidator validator;

	@ModelAttribute("gender")
	public Map<String, String> getGender(HttpSession session) {
		
		Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.class.getName() + ".LOCALE");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("male", messageSource.getMessage("member.regist.gender.male", null, locale));
		map.put("female", messageSource.getMessage("member.regist.gender.female", null, locale));
		return map;
	}
	
	@ModelAttribute("hobby")
	public List<Hobby> getHobby(HttpSession session) {
		
		Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.class.getName() + ".LOCALE");
		
		List<Hobby> hobbys = new ArrayList<Hobby>();
		hobbys.add(new Hobby("swimming",    messageSource.getMessage("member.regist.hobby.swimming", null, locale)));
		hobbys.add(new Hobby("programming", messageSource.getMessage("member.regist.hobby.programming", null, locale)));
		hobbys.add(new Hobby("reading",     messageSource.getMessage("member.regist.hobby.reading", null, locale)));
		hobbys.add(new Hobby("watching",    messageSource.getMessage("member.regist.hobby.watching", null, locale)));
		
		return hobbys;
	}
	
	@ModelAttribute("member")
	public MemberCommand getMemberCommand() {
		MemberCommand member = new MemberCommand();
//		member.setGender("male");
		return member;
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registForm() {
		
		return "member/registForm";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute("member") MemberCommand command, Errors errors) {
		/*
		 * Validation
		 */
		log.info("command = " + command);

		validator.validate(command, errors);
		
		if (errors.hasErrors()) {
			command.setPassword("");
			return "member/registForm";
		}
		
		/*
		 * DB 등록
		 */
		try {
			service.register(command.getMember());
		} catch (AlreadyExistingMemberException e) {
			log.error("Member Existing...", e);
			errors.reject("duplicate");
			return "member/registForm";
		}
		
		return "member/registSuccess";
	}
	
}
