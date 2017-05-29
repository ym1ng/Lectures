package com.zym.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zym.baseTest.SpringTestCase;
import com.zym.dao.AdminMapper;
import com.zym.dao.AdminMapperVo;
import com.zym.dao.CollectionMapper;
import com.zym.dao.RoleMapper;
import com.zym.domain.Admin;

public class AdminServiceTest extends SpringTestCase {
	private static Logger logger = Logger.getLogger(AdminServiceTest.class);
	@Autowired
	private AdminMapperVo AdminMapperVo;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private AdminMapper AdminMapper;
	@Autowired
	private CollectionMapper collectionMapper;

	// @Autowired
	// private AdminMapper AdminMapper;
//	@Test
//	public void selectadminlist() {
//		Admin admin = new Admin();
//		admin.setManagerid(2015229);
//		admin.setUsername("zhangsan");
//		admin.setPassword("123456");
//		admin.setRoleid(1d);
//		admin.setEmail("357471735@qq.com");
//		int a = AdminMapper.updateByPrimaryKeySelective(admin);
//		System.out.println(a);
//		// logger.info(JSON.toJSONString( roleMapper.selectRoleList()));
//	}
	@Test
	public void select(){
		logger.info(collectionMapper.selectCollectionByUseridAndLecturesid(201526740131L, 10003));	
	
	}
}