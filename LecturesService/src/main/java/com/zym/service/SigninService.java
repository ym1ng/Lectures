package com.zym.service;

import java.util.List;
import java.util.Map;

import com.zym.domain.SignIn;


public interface SigninService {
	List<SignIn> selectSignInlist();
	SignIn selectSignInbySignInid(int signinid);
	boolean  insertSignIn(SignIn signin);
	boolean  updateSignIn(SignIn signin);
	boolean  deleteSignIn(int signinid);
	List<SignIn> getSignInByDate(Map<String, Object> map);
	List<SignIn> queryuserenrollBylecturesid(int lecturesid);
	SignIn queryuserenrollBylecturesidanduserid(int lecturesid ,long userid);

}