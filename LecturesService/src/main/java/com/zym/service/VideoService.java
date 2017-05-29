package com.zym.service;

import java.util.List;
import java.util.Map;

import com.zym.domain.Video;

public interface VideoService {
	List<Video> selectVideolist();
	Video selectVideobyVideoid(int	 videoid);
	boolean  insertVideo(Video video);
	boolean  updateVideo(Video video);
	boolean  deleteVideo(int videoid);
//	PageInfo<User> queryByPage(Integer pageNo,Integer pageSize);
	List<Video> getVideoByDate(Map<String, Object> map);

	
}