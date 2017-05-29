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
import com.zym.domain.Classroom;
import com.zym.service.ClassroomService;


@Controller
@RequestMapping("/classroom")
public class ClassroomController extends BaseController {
	@Resource
	private ClassroomService classroomService;
	@RequestMapping("/list")
	public String classroom_list(Model model) {
		
		model.addAttribute("classroomlist", classroomService.selectClassroomlist());
		return "classroom/classroom-list";
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("classroomid") int classroomid) {
		model.addAttribute("classroom", classroomService.getClassroom(classroomid));
		return "classroom/classroom-add";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "classroom/classroom-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject getShopInJSON(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String lng= request.getParameter("lng");
		String lat=request.getParameter("lat");
		String classroomname=request.getParameter("classroomname");
		String classroomid=request.getParameter("classroomid");
		Classroom classroom = new Classroom();
		classroom.setClassroomname(classroomname);
		if (!lat.equals("")) {
			classroom.setLat(lat);
		}
		if (!lng.equals("")) {
			classroom.setLng(lng);;
		}
		if ("".equals(request.getParameter("classroomid"))) {
			if (classroomService.insertClassroom(classroom)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			classroom.setClassroomid(Integer.parseInt(classroomid));
			if (classroomService.updateClassroom(classroom)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject admin_delete(Model model, @RequestParam("classroomid") int classroomid) {
		JSONObject jsonObject = new JSONObject();
		if (classroomService.deleteClassroom(classroomid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
}
