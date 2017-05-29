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
import com.zym.domain.Comment;
import com.zym.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController{
	@Resource
	private CommentService commentService;
	@RequestMapping("/list")
	public String role_list(Model model) {
		model.addAttribute("commentlist", commentService.selectCommentlist());
		return "comment/comment-list";
	}
	@RequestMapping("/add")
	public String add_role(Model model) {
		return "comment/comment-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String lecturesid= request.getParameter("lecturesid");
		String userid=request.getParameter("userid");
		String commentcontent=request.getParameter("commentcontent");
		String commentid=request.getParameter("commentid");
		Comment comment = new Comment();
		comment.setLecturesid(Integer.parseInt(lecturesid));
		comment.setUserid(Long.parseLong(userid));
		comment.setCommentcontent(commentcontent);
		if ("".equals(commentid)) {
			comment.setConmmentdate(new Date());
			if (commentService.insertComment(comment)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			comment.setCommentid(Integer.parseInt(commentid));
			if (commentService.updateComment(comment)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject delete(Model model, @RequestParam("commentid") int commentid) {
		JSONObject jsonObject = new JSONObject();
		if (commentService.deleteComment(commentid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String admin_edit(Model model, @RequestParam("commentid") int commentid) {
		model.addAttribute("comment", commentService.selectCommentbyCommentid(commentid));
		return "comment/comment-add";
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Collectionselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		model.addAttribute("commentlist",commentService.getCommentByDate(map));
		logAfter(logger);
		return "comment/comment-list";
	}
}
