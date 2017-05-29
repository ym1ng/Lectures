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
import com.zym.domain.Enroll;
import com.zym.service.EnrollService;

@Controller
@RequestMapping("/enroll")
public class EnrollController extends BaseController{
	@Resource
	private EnrollService enrollService;
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("enrolllist", enrollService.selectEnrolllist());
		return "enroll/enroll-list";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "enroll/enroll-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		System.out.println("lecturesType-save");
		JSONObject jsonObject = new JSONObject();
		String lecturesid= request.getParameter("lecturesid");
		String userid=request.getParameter("userid");
		String enrollid=request.getParameter("enrollid");
		Enroll enroll = new Enroll();
		enroll.setLecturesid(Integer.parseInt(lecturesid));
		enroll.setUserid(Long.parseLong(userid));
		if ("".equals(enrollid)) {
			enroll.setEnrolltime(new Date());
			if (enrollService.insertEnroll(enroll)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			 enroll.setEnrollid(Long.parseLong(enrollid));
			if (enrollService.updateEnroll(enroll)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject delete(Model model, @RequestParam("enrollid") long enrollid) {
		JSONObject jsonObject = new JSONObject();
		if (enrollService.deleteEnroll(enrollid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("enrollid") long enrollid) {
		model.addAttribute("enroll", enrollService.selectEnrollbyenrollid(enrollid));
		return "enroll/enroll-add";
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Enrollselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime",request.getParameter("datemin"));
		map.put("endTime",request.getParameter("datemax"));
		logger.info("获得的数据"+ enrollService.getEnrollByDate(map));
		logAfter(logger);
		model.addAttribute("enrolllist", enrollService.getEnrollByDate(map));
		return "enroll/enroll-list";
	}
}
