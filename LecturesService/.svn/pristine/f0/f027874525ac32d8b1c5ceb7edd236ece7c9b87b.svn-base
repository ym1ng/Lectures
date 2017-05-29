package com.zym.api;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zym.controller.BaseController;
import com.zym.domain.Collection;
import com.zym.domain.Comment;
import com.zym.domain.Enroll;
import com.zym.domain.Lectures;
import com.zym.domain.User;
import com.zym.service.CollectionService;
import com.zym.service.CommentService;
import com.zym.service.EnrollService;
import com.zym.service.LecturesService;
import com.zym.service.UserService;
import com.zym.service.VideoService;
import com.zym.utils.Base;
import com.zym.utils.ImageUtils;
import com.zym.utils.RenameFileUtils;

@RequestMapping("/api")
@Controller
public class apiController extends BaseController {

	@Resource
	private LecturesService lecturesService;
	@Resource
	private UserService userService;
	@Resource
	private EnrollService enrollService;
	@Resource
	private CommentService commentService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private VideoService videoService;
	@RequestMapping(value = "lecturesQuery", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> getlectureslist(int pageNo, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<Lectures> page = lecturesService.queryByPage(pageNo, pageSize);
		map.put("code", 200);
		map.put("isHasNextPage", page.isHasNextPage());
		map.put("data", page.getList());
		return map;
	}

	@RequestMapping(value = "lecturesQuerylikelecturesname", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> lecturesQuerylikelecturesname(int pageNo, int pageSize, String lecturesname) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<Lectures> page = lecturesService.queryByPagelikename(pageNo, pageSize, lecturesname);
		map.put("code", 200);
		map.put("isHasNextPage", page.isHasNextPage());
		map.put("data", page.getList());
		return map;
	}
	@RequestMapping(value = "getVideolist", method = (RequestMethod.GET))
	@ResponseBody
	public Map<String, Object> getVideolist() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("data", videoService.selectVideolist());
		return map;
	}
	@RequestMapping(value = "lecturesCollectionQuerybyuserid", method = (RequestMethod.GET))
	@ResponseBody
	public Map<String, Object> lecturesQuerybyuserid(int pageNo, int pageSize, long userid) {
		logBefore(logger, "lecturesCollectionQuerybyuserid");
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<Collection> page = collectionService.lecturesQuerylikebyuserid(pageNo, pageSize, userid);
		map.put("code", 200);
		map.put("data", page.getList());
		map.put("isHasNextPage", page.isHasNextPage());
		logger.info(page.getList().get(0).getLectures());
		logAfter(logger);
		return map;
	}

	@RequestMapping(value = "lecturesQuerybyuserid", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> lecturesQuerylikebyuserid(int pageNo, int pageSize, long userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<Enroll> page = enrollService.lecturesQuerylikebyuserid(pageNo, pageSize, userid);
		map.put("code", 200);
		map.put("isHasNextPage", page.isHasNextPage());
		map.put("data", page.getList());
		return map;
	}

	@RequestMapping(value = "querycommentlist", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> querycomment(int pageNo, int pageSize, int lecturesid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		PageInfo<Comment> page = commentService.queryByPage(pageNo, pageSize, lecturesid);
		map.put("isHasNextPage", page.isHasNextPage());
		map.put("data", page.getList());
		return map;
	}

	@RequestMapping(value = "spendlecturesComment", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> spendlecturesComment(long userid, int lecturesid, String commentcontent) {
		Map<String, Object> map = new HashMap<String, Object>();
		Comment comment = new Comment();
		comment.setCommentcontent(commentcontent);
		comment.setLecturesid(lecturesid);
		comment.setUserid(userid);
		comment.setConmmentdate(new Date());
		if (commentService.insertComment(comment)) {
			map.put("code", 200);
			map.put("msg", "添加 成功");
		} else {
			map.put("code", 201);
			map.put("msg", "添加 失败");
		}
		return map;
	}

	@RequestMapping(value = "userenroll", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> userenroll(long userid, int lecturesid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = enrollService.userenroll(userid, lecturesid);
		return map;
	}

	@RequestMapping(value = "usercollection", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> usercollection(long userid, int lecturesid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (collectionService.userCollection(userid, lecturesid)) {
			map.put("code", 200);
			map.put("msg", "收藏成功");
		} else {
			map.put("code", 201);
			map.put("msg", "收藏失败");
		}
		return map;
	}

	@RequestMapping(value = "queryuserenrollBydate", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> queryuserenrollBydate(long userid, String date) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("data", enrollService.queryuserenrollBydate(userid, new Date(date)));
		return map;
	}

	@RequestMapping(value = "lecturesDetailQuery", method = (RequestMethod.POST))
	@ResponseBody
	public Map<String, Object> getlecturesDetail(long userid, int lecturesid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDate = new HashMap<String, Object>();
		Lectures lectures = lecturesService.selectLecturesbylecturesid(lecturesid);
		Lectures lectures1 = new Lectures();
		lectures1.setLecturesid(lecturesid);
		lectures1.setPapeview(lectures.getPapeview() + 1);
		lecturesService.updateLectures(lectures1);
		mapDate.put("enrollcount", enrollService.selectcountenroll(lecturesid));
		Enroll enroll = enrollService.selectEnrollbyuseridLectures(userid, lecturesid);
		if (collectionService.isuserCollection(userid, lecturesid)) {
			mapDate.put("iscollection", true);
		} else {
			mapDate.put("iscollection", false);
		}
		if (enroll != null) {
			mapDate.put("isenroll", true);
		} else {
			mapDate.put("isenroll", false);
		}
		Comment comment = new Comment();
		Map<String, Object> commentmap = new HashMap<String, Object>();
		if ((comment = commentService.selectCommentbylecturesidfirst(lecturesid)) != null) {
			commentmap.put("realname", comment.getUser().getRealname());
			commentmap.put("headpicpath", comment.getUser().getHeadpicpath());
			commentmap.put("conmmentdate", comment.getConmmentdate());
			commentmap.put("conmmenttext", comment.getCommentcontent());
		}
		mapDate.put("comment", commentmap);
		mapDate.put("lectures", lectures);
		map.put("code", 200);
		map.put("data", mapDate);
		return map;
	}

	@RequestMapping(value = "image", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> image(String image, String imagename, long userid) {
		logBefore(logger, "进行头像存储");
		Map<String, Object> map = new HashMap<String, Object>();
		String basePath = "/images/" + RenameFileUtils.renameFileName(imagename + ".png");
		User user = userService.selectUserbyuserid(userid);
		if (!user.getHeadpicpath().isEmpty()) {
			File file = new File(Base.BASE_PIC_PATH + user.getHeadpicpath());
			logger.info("删除原先存储的图片 ：" + file.delete());
		}
		user.setHeadpicpath(basePath);
		userService.updateUser(user);
		String imgPath = Base.BASE_PIC_PATH + basePath;
		logger.info("图片保存的位置为： " + Base.BASE_PIC_PATH + basePath);
		map.put("results", ImageUtils.string2Image(image, imgPath));
		logAfter(logger);
		return map;
	}
}
