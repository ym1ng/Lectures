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
import com.zym.domain.Collection;
import com.zym.service.CollectionService;


@Controller
@RequestMapping("/collection")
public class CollectionController extends BaseController{
	@Resource
	private CollectionService collectionService;

	@RequestMapping("/list")
	public String collection_list(Model model) {
		model.addAttribute("collectionlist", collectionService.selectCollectionlist());
		return "collection/collection-list";
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Collectionselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		model.addAttribute("collectionlist",collectionService.getCollectionByDate(map));
		logAfter(logger);
		return "collection/collection-list";
	}
	@RequestMapping("/add")
	public String add_collection(Model model) {
		return "collection/collection-add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String lecturesid= request.getParameter("lecturesid");
		String userid=request.getParameter("userid");
		String collectionid=request.getParameter("collectionid");
		Collection collection = new Collection();
		collection.setLecturesid(Integer.parseInt(lecturesid));
		collection.setUserid(Long.parseLong(userid));
		if ("".equals(collectionid)) {
			collection.setCollectiontime(new Date());
			if (collectionService.insertCollection(collection)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		} else {
			collection.setCollectionid(Integer.parseInt(collectionid));
			if (collectionService.updateCollection(collection)) {
				jsonObject.put("msg", "true");
			} else {
				jsonObject.put("msg", "false");
			}
		}

		return jsonObject;

	}
	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject delete(Model model, @RequestParam("collectionid") int collectionid) {
		JSONObject jsonObject = new JSONObject();
		if (collectionService.deleteCollection(collectionid)) {
			jsonObject.put("msg", "true");
		} else {
			jsonObject.put("msg", "false");
		}
		return jsonObject;
	}
	@RequestMapping(value = "/edit")
	public String collection_edit(Model model, @RequestParam("collectionid") int collectionid) {
		model.addAttribute("collection", collectionService.selectCollectionbyCollectionid(collectionid));
		return "collection/collection-add";
	}

}
