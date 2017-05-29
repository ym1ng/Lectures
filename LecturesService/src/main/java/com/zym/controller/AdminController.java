package com.zym.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.zym.domain.Admin;
import com.zym.domain.AdminVo;
import com.zym.domain.Role;
import com.zym.service.AdminService;
import com.zym.utils.ValidateCode;

@Controller
public class AdminController extends BaseController {
	@Resource
	private AdminService adminService;

	/**
	 * 登录
	 * 
	 * @param session
	 */
	@RequestMapping("/adminlogin")
	public @ResponseBody JSONObject login(HttpSession session, String username, String password, String validateCode)
			throws Exception {
		JSONObject jsonObject = new JSONObject();
		AdminVo adminvo;
		// 在Session里保存信息
	    if (!validateCode.trim().equalsIgnoreCase(session.getAttribute("validateCode").toString().trim())) {
			jsonObject.put("code", "1");
			jsonObject.put("msg", "请输入正确的验证码");
		} else if ((adminvo = adminService.checkLogin(username, password)) != null) {
			session.setAttribute("username", username);
			session.setAttribute("rolename", adminvo.getRole().getRolename());
			jsonObject.put("code", "0");
		} else {
			jsonObject.put("code", "1");
			jsonObject.put("msg", "账号或者密码错误");
		}
		return jsonObject;
	}

	/**
	 * 主页面
	 * 
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}

	/**
	 * 登录页
	 * 
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 欢迎页
	 * 
	 */
	@RequestMapping("/welcome")
	public ModelAndView getuser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("Welcome");
		return mav;
	}

	/**
	 * 退出系统
	 * 
	 * @param session
	 *            Session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除Session
		session.invalidate();
		return "redirect:login";
	}

	/**
	 * 生成验证码
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 设置响应头信息
		response.setHeader("Cache-Control", "no-cache");
		// 返回一个新的验证码
		String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_ALL_MIXED, 4, null);
		// 将新的验证码放入到session里面
		request.getSession().setAttribute("validateCode", verifyCode);
		// 设置响应类型
		response.setContentType("image/jpeg");
		// 生成验证码图片
		BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 120, 40, 4, true, Color.white, Color.BLACK,
				null);
		// 渲染页面
		ImageIO.write(bim, "JPEG", response.getOutputStream());
	}

	@RequestMapping(value = "/admin_list")
	public String adminlist(Model model) {
		model.addAttribute("list", adminService.getAdminlist());
		return "admin-list";
	}

	@RequestMapping(value = "/admin_add")
	public String admin_add(Model model) {
		List<Role> rolelist = adminService.getRolelist();
		model.addAttribute("rolelist", rolelist);
		return "admin-add";
	}

	@RequestMapping(value = "/admin_edit")
	public String admin_edit(Model model, @RequestParam("managerid") String managerid) {
		List<Role> rolelist = adminService.getRolelist();
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("admin", adminService.getAdminbymanagerid(Integer.parseInt(managerid)));
		return "admin-add";
	}

	@RequestMapping(value = "/admin_detele")
	public @ResponseBody JSONObject admin_delete(Model model, @RequestParam("managerid") int managerid) {
		JSONObject jsonObject = new JSONObject();
		if (adminService.deleteadmin(managerid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		Admin admin = new Admin();
		admin.setUsername(request.getParameter("adminName"));
		admin.setPassword(request.getParameter("password"));
		admin.setRoleid(Double.parseDouble(request.getParameter("adminRole")));
		admin.setEmail(request.getParameter("email"));
		admin.setMobile(request.getParameter("phone"));
		if ("".equals(request.getParameter("managerid"))) {
			admin.setAddtime(new Date());
			if (adminService.insertadmin(admin)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			admin.setManagerid(Integer.parseInt(request.getParameter("managerid")));
			if (adminService.updateadmin(admin)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;
	}
	@RequestMapping(value = "/admin_select" )
	public String  select(Model model,HttpServletRequest request) {
		logBefore(logger, "AdminSelect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		model.addAttribute("list",adminService.getAdminByDate(map));
		logAfter(logger);
		return "admin-list";
	}
}
