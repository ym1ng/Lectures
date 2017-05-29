package com.zym.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zym.baseTest.SpringTestCase;
import com.zym.dao.AdminMapperVo;
import com.zym.dao.UserMapper;
import com.zym.domain.AdminVo;
import com.zym.domain.User;
import com.zym.service.UserService;

public class UserServiceTest extends SpringTestCase {
	private static Logger logger = Logger.getLogger(UserServiceTest.class);
	@Autowired
	private UserService userService;

	@Test
	public void selectUserByIdTest() {
		// User user = userService.selectUserById(1);
		// System.out.println(user.getUserName() + ":" +
		// user.getUserPassword());
//		AdminVo book = userService.selectAdmin("admin");

		// selectByPrimaryKey
		// List<book> book= userService.selectall();
		// book ab=userService.selectByPrimaryKey(20152674);
		   PageInfo<User> page =  userService.queryByPage(2,10);
	        System.out.println("***"+page.getList().toString());
	}
}