package com.zym.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zym.domain.SignIn;
import com.zym.service.SigninService;

@Controller
@RequestMapping("/signin")
public class SigninController extends BaseController{
	@Resource
	private SigninService signinService;
	@RequestMapping("/list")
	public String role_list(Model model) {
		model.addAttribute("signinlist", signinService.selectSignInlist());
		return "signin/signin-list";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "signin/signin-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String lecturesid= request.getParameter("lecturesid");
		String userid=request.getParameter("userid");
		String signinid=request.getParameter("signinid");
		SignIn signIn = new SignIn();
		signIn.setLecturesid(Integer.parseInt(lecturesid));
		signIn.setUserid(Long.parseLong(userid));
		if ("".equals(signinid)) {
			signIn.setSignintime(new Date());
			if (signinService.insertSignIn(signIn)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			signIn.setSigninid(Integer.parseInt(signinid));
			if (signinService.updateSignIn(signIn)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject delete(Model model, @RequestParam("signinlid") int signinid) {
		JSONObject jsonObject = new JSONObject();
		if (signinService.deleteSignIn(signinid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("signinid") int signinid) {
		model.addAttribute("signin", signinService.selectSignInbySignInid(signinid));
		return "signin/signin-add";
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Signinselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		//logger.info("获得的数据"+userService.getUserByDate(map));
		logAfter(logger);
		model.addAttribute("signinlist", signinService.getSignInByDate(map));
		return "signin/signin-list";
	}
}
