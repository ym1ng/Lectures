package com.zym.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.VideoMapper;
import com.zym.domain.Video;

@Service  
public class VideoServiceImpl implements VideoService {

    @Autowired  
    private VideoMapper videoMapper;

	public List<Video> selectVideolist() {
		return videoMapper.selectVideoList();
	}

	public boolean insertVideo(Video video) {
		int result = videoMapper.insertSelective(video);
			if (result == 1) {
				return true;
			}
		return false;
	}

	public boolean updateVideo(Video video) {
		int result=videoMapper.updateByPrimaryKeySelective(video);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean deleteVideo(int videoid) {
		int result=videoMapper.deleteByPrimaryKey(videoid);
		if (result==1) {
			return true;
		}
		return false;
	}

	public Video selectVideobyVideoid(int videoid) {
		return videoMapper.selectByPrimaryKey(videoid);
	}

	public List<Video> getVideoByDate(Map<String, Object> map) {
		return videoMapper.getVideoByDate(map);
	}



   
}