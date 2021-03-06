package com.zym.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.SignInMapper;
import com.zym.domain.Enroll;
import com.zym.domain.SignIn;

@Service
public class SigninServiceImpl implements SigninService {

	@Autowired
	private SignInMapper signInMapper;



	public List<SignIn> selectSignInlist() {
		return signInMapper.selectsigninList();
	}

	public SignIn selectSignInbySignInid(int signinid) {
	
		return signInMapper.selectByPrimaryKey(signinid);
	}

	public boolean insertSignIn(SignIn signin) {
		int result = signInMapper.insertSelective(signin);
		if (result == 1) {
			return true;
		}

		return false;
	}

	public boolean updateSignIn(SignIn signin) {
		int result = signInMapper.updateByPrimaryKeySelective(signin);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteSignIn(int signinid) {
		int result = signInMapper.deleteByPrimaryKey(signinid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public List<SignIn> getSignInByDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return signInMapper.getSignInByDate(map);
	}

	public List<SignIn> queryuserenrollBylecturesid(int lecturesid) {
		// TODO Auto-generated method stub
		return signInMapper.queryuserenrollBylecturesid(lecturesid);
	}

	public SignIn queryuserenrollBylecturesidanduserid(int lecturesid, long userid) {
		// TODO Auto-generated method stub
		return signInMapper.queryuserenrollBylecturesidanduserid(lecturesid, userid);
	}



}