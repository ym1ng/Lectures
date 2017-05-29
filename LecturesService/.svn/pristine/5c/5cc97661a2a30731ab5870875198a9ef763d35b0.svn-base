package com.zym.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.zym.baseTest.SpringTestCase;
import com.zym.dao.VideoMapper;
import com.zym.domain.User;
import com.zym.domain.Video;
import com.zym.service.UserService;

public class VideoServiceTest extends SpringTestCase{
	private static Logger logger = Logger.getLogger(VideoServiceTest.class);

	@Autowired
	private VideoMapper videoMapper;

	@Test
	public void test() {
	logger.info(videoMapper.selectVideoList());
	}
	
	
}
