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
import com.zym.domain.Role;
import com.zym.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	@Resource
	private RoleService roleService;
	@RequestMapping("/list")
	public String role_list(Model model) {
		model.addAttribute("rolelist", roleService.selectRolelist());
		return "role/role-list";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "role/role-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String rolename= request.getParameter("rolename");
		String remake=request.getParameter("remake");
		String roleid=request.getParameter("roleid");
		Role role = new Role();
		if (!rolename.equals("")) {
			role.setRolename(rolename);
		}
		if (!remake.equals("")) {
			role.setRemake(remake);
		}
		if ("".equals(request.getParameter("roleid"))) {
			if (roleService.insertRole(role)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			role.setRoleid(Integer.parseInt(roleid));
			if (roleService.updateRole(role)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject admin_delete(Model model, @RequestParam("roleid") int roleid) {
		JSONObject jsonObject = new JSONObject();
		if (roleService.deleteRole(roleid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("roleid") int roleid) {
		model.addAttribute("role", roleService.selectRolebyroleid(roleid));
		return "role/role-add";
	}

}
