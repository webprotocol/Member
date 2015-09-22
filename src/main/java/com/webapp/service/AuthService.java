package com.webapp.service;

import org.springframework.dao.EmptyResultDataAccessException;

import com.webapp.dao.MemberDao;
import com.webapp.exception.IdPassswordNotMatchException;
import com.webapp.model.AuthInfo;
import com.webapp.model.Member;
import com.webapp.util.Password;

public class AuthService {
	MemberDao dao;
	
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public AuthInfo authenticate(String email, String password) {

		AuthInfo info = new AuthInfo();
		
		try {
			Member m = dao.selectByEmail(email);
			if (!m.getPassword().equals(Password.encode(password))) {
				throw new IdPassswordNotMatchException();
			}
			info.setEmail(m.getEmail());
			info.setName(m.getName());
			
		} catch (EmptyResultDataAccessException e) {
			throw new IdPassswordNotMatchException(e);
		}
		
		return info;
	}

}
