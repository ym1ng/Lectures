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
import com.zym.domain.LecturesType;
import com.zym.service.LecturesTypeService;

@Controller
@RequestMapping("/lecturesType")
public class LectuesTypeController extends BaseController{
	@Resource
	private LecturesTypeService lecturesTypeService;
	@RequestMapping("/list")
	public String role_list(Model model) {
		model.addAttribute("lecturesTypelist", lecturesTypeService.selectLecturesTypelist());
		return "lecturesType/lecturesType-list";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "lecturesType/lecturesType-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		System.out.println("lecturesType-save");
		JSONObject jsonObject = new JSONObject();
		String lecturestypename= request.getParameter("lecturestypename");
		String description=request.getParameter("description");
		String lecturestypeid=request.getParameter("lecturestypeid");
		LecturesType lecturesType = new LecturesType();
		lecturesType.setLecturestypename(lecturestypename);
		if (!description.equals("")) {
			lecturesType.setDescription(description);
		}
		if ("".equals(request.getParameter("lecturestypeid"))) {
			if (lecturesTypeService.insertLecturesType(lecturesType)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			lecturesType.setLecturestypeid(Integer.parseInt(lecturestypeid));
			if (lecturesTypeService.updateLecturesType(lecturesType)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject delete(Model model, @RequestParam("lecturestypeid") int lecturestypeid) {
		JSONObject jsonObject = new JSONObject();
		if (lecturesTypeService.deleteLecturesType(lecturestypeid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("lecturestypeid") int lecturestypeid) {
		model.addAttribute("lecturestype", lecturesTypeService.selectLecturesTypebyLecturesTypeid(lecturestypeid));
		return "lecturesType/lecturesType-add";
	}

}
