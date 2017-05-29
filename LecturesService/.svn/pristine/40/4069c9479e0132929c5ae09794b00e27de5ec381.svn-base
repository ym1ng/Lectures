package com.zym.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zym.domain.Video;
import com.zym.service.VideoService;
import com.zym.utils.Base;
import com.zym.utils.RenameFileUtils;
import com.zym.utils.VideoUtils;

@RequestMapping("/video")
@Controller
public class VideoController extends BaseController {

	@Resource
	private VideoService videoService;

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("videolist", videoService.selectVideolist());
		return "video/video-list";
	}

	@RequestMapping("/add")
	public String add(Model model) {

		return "video/video-add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JSONObject save(MultipartFile file, HttpServletRequest request) {
		logBefore(logger, "video-save");
		JSONObject jsonObject = new JSONObject();
		Video video = new Video();
		String videoname = request.getParameter("videoname");
		String videocontent = request.getParameter("videocontent");
		video.setVideoname(videoname);
		video.setVideocontent(videocontent);
		logger.info("获取表单的数据video为" + video);
		String videoid = request.getParameter("videoid");
		// if (!"".equals(videoid)) {
		// video.setVideoid(Integer.parseInt(videoid));
		// }else {
		// video.setAddtime(new Date());
		// }

		if ("".equals(videoid)) { // 判断ID是否为空，如果为空就是为第一次，创建一个时间为添加时间
			video.setAddtime(new Date());
			if (file != null) {
				// user.setHeadpicpath(savepic(file, 0));
				String path = savevideo(file, 0);
				video.setVideourl(path);
				video.setVideopic(VideoUtils.processImg(path, "D:/ffmpeg.exe"));
			}
			if (!videoService.insertVideo(video)) {
				jsonObject.put("msg", "false");
				return jsonObject;
			}
		} else {
			video.setVideoid(Integer.parseInt(videoid));
			if (file != null) {
				// user.setHeadpicpath(savepic(file, Long.parseLong(userid)));
				String path = savevideo(file, video.getVideoid());
				video.setVideourl(path);
				video.setVideopic(VideoUtils.processImg(path, "D:/ffmpeg.exe"));
			}
			if (!videoService.updateVideo(video)) {
				jsonObject.put("msg", "false");
				return jsonObject;
			}
		}
		jsonObject.put("msg", "true");
		return jsonObject;
	}

	@RequestMapping(value = "/detele")
	public @ResponseBody JSONObject detele(Model model, @RequestParam("videoid") int videoid) {
		JSONObject jsonObject = new JSONObject();
		 if (videoService.deleteVideo(videoid)) {
		 jsonObject.put("msg", "true");
		 } else {
		 jsonObject.put("msg", "false");
		 }
		return jsonObject;
	}

	@RequestMapping(value = "/edit")
	public String edit(Model model, @RequestParam("videoid") int videoid) {
		model.addAttribute("video", videoService.selectVideobyVideoid(videoid));
		// model.addAttribute("collegeslist",
		// collegesService.selectCollegeslist());
		return "video/video-add";
	}

	@RequestMapping(value = "/show")
	public String show(Model model, @RequestParam("videoid") int videoid) {
		model.addAttribute("video", videoService.selectVideobyVideoid(videoid));
		return "video/video-show";
	}

	String savevideo(MultipartFile file, int videoid) {
		if (file != null) {
			String path = "/video/" + RenameFileUtils.renameFileName(file.getOriginalFilename());// 路径需要修改
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
			if (videoid == 0) {

			} else {
				Video video = videoService.selectVideobyVideoid(videoid);
				if (video.getVideourl() != null) {
					File file1 = new File(Base.BASE_PIC_PATH + video.getVideourl());
					file1.delete();
				}
			}
			return path;
		}
		return null;
	}
	@RequestMapping("/select")
	public String select(Model model,HttpServletRequest request) {
		logBefore(logger, "Videoselect");
		logger.info(request.getParameter("datemin"));
		logger.info(request.getParameter("datemax"));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", request.getParameter("datemin"));
		map.put("endTime", request.getParameter("datemax"));
		model.addAttribute("videolist", videoService.getVideoByDate(map));
		logAfter(logger);
		return "video/video-list";
	}
}