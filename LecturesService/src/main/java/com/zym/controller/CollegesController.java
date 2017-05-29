package com.zym.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zym.domain.Colleges;
import com.zym.service.CollegesService;


@Controller
@RequestMapping("/colleges")
public class CollegesController extends BaseController {
	@Resource
	private CollegesService collegesService;
	@RequestMapping("/list")
	public String colleges_list(Model model) {		
		model.addAttribute("collegeslist", collegesService.selectCollegeslist());
		return "colleges/colleges-list";
	}
	@RequestMapping(value = "/edit")
	public String colleges_edit(Model model, @RequestParam("collegesid") int collegesid) {
		model.addAttribute("colleges", collegesService.getColleges(collegesid));
		return "colleges/colleges-add";
	}
	@RequestMapping("/add")
	public String add_colleges(Model model) {
		return "colleges/colleges-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject getcollegesInJSON(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();

		String collegesname=request.getParameter("collegesname");
		String collegesid=request.getParameter("collegesid");
		Colleges colleges = new Colleges();
		colleges.setCollegesname(collegesname);

		if ("".equals(request.getParameter("collegesid"))) {
			if (collegesService.insertColleges(colleges)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			colleges.setCollegesid(Integer.parseInt(collegesid));
			if (collegesService.updateColleges(colleges)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject colleges_delete(Model model, @RequestParam("collegesid") int collegesid) {
		JSONObject jsonObject = new JSONObject();
		if (collegesService.deleteColleges(collegesid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
}
