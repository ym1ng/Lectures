package com.zym.test;

import java.awt.List;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zym.dao.EnrollMapper;
import com.zym.dao.LecturesMapper;

public class lecturesTest {
	private static Logger logger = Logger.getLogger(EnrollTest.class);
	@Autowired
	private LecturesMapper enrollMapper;
	
	@Test
	public void selectUserByIdTest() {
		System.out.println();
	}
}
