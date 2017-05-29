package com.zym.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.zym.baseTest.SpringTestCase;
import com.zym.dao.ClassroomMapper;

public class ClassroomServiceTest extends SpringTestCase {
	private static Logger logger = Logger.getLogger(AdminServiceTest.class);
	@Autowired
	private ClassroomMapper roleService;
	@Test
	public void selectUserByIdTest() {
		// User user = userService.selectUserById(1);
		// System.out.println(user.getUserName() + ":" +
		// user.getUserPassword());
		

		// selectByPrimaryKey
		// List<book> book= userService.selectall();
		// book ab=userService.selectByPrimaryKey(20152674);
		logger.info(JSON.toJSONString(roleService.selectByPrimaryKey(1)));

	}
}
