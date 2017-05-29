package com.zym.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zym.domain.User;
import com.zym.service.CollegesService;
import com.zym.service.UserService;
import com.zym.utils.Base;
import com.zym.utils.RenameFileUtils;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

	@Resource
	private UserService userService;
	@Resource
	private CollegesService collegesService;

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userlist", userService.selectUserlist());
		return "user/user-list";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("collegeslist", collegesService.selectCollegeslist());
		return "user/user-add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(MultipartFile file, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String collegesid = request.getParameter("colleges");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String userid = request.getParameter("userid");
		user.setPhone(phone);
		user.setRealname(realname);
		user.setEmail(email);
		user.setSex(sex);
		user.setCollegesid(Integer.parseInt(collegesid));
		if (!"".equals(address)) {
			user.setAddress(address);
		}
		if ("".equals(userid)) {// 判断ID是否为空，如果为空就是为第一次，创建一个时间为添加时间
			user.setAddtime(new Date());
			user.setUsername(username);
			user.setPassword(password);
			if (file!=null) {
				user.setHeadpicpath(savepic(file, 0));
			}
			if (userService.insertUser(user)) {

			} else {
				jsonObject.put("msg", "false");
				return jsonObject;
			}
		} else {
			user.setUserid(Long.parseLong(userid));
			if (file!=null) {
				user.setHeadpicpath(savepic(file, Long.parseLong(userid)));
			}
			if (userService.updateUser(user)) {
			} else {
				jsonObject.put("msg", "false");
				return jsonObject;
			}
		}
		jsonObject.put("msg", "true");
		return jsonObject;

	}

	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject detele(Model model, @RequestParam("userid") long userid) {
		JSONObject jsonObject = new JSONObject();
		if (userService.deleteUser(userid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}

	@RequestMapping(value = "/reset_password")
	public @ResponseBody JSONObject reset_password(Model model, @RequestParam("userid") long userid) {
		JSONObject jsonObject = new JSONObject();
		if (userService.reset_password(userid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}

	@RequestMapping(value = "/edit")
	public String edit(Model model, @RequestParam("userid") long userid) {
		model.addAttribute("user", userService.selectUserbyuserid(userid));
		model.addAttribute("collegeslist", collegesService.selectCollegeslist());
		return "user/user-add";
	}

	@RequestMapping(value = "/show")
	public String show(Model model, @RequestParam("userid") long userid) {
		model.addAttribute("user", userService.selectUserbyuserid(userid));
		return "user/user-show";
	}

	String savepic(MultipartFile file, long userid) {
		if (file!=null) {
			String path = "/images/" + RenameFileUtils.renameFileName(file.getOriginalFilename());// 路径需要修改
			File dir = new File(Base.BASE_PIC_PATH + path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			try {
				file.transferTo(dir);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (userid == 0) {

			} else {
				User user1 = userService.selectUserbyuserid(userid);
				if (user1.getHeadpicpath()!=null) {
					File file1 = new File(Base.BASE_PIC_PATH + user1.getHeadpicpath());
					file1.delete();
				}
			}
			return path;
		}
		return null;
	}
	@RequestMapping(value = "/excel/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HSSFWorkbook wb = userService.export();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + RenameFileUtils.renameFileName("user.xls"));
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Userselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		logger.info("获得的数据"+userService.getUserByDate(map));
		logAfter(logger);
		model.addAttribute("userlist", userService.getUserByDate(map));
		return "user/user-list";
	}
}