package com.zym.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.github.pagehelper.PageInfo;
import com.zym.domain.User;

public interface UserService {
	List<User> selectUserlist();
	User selectUserbyuserid(Long userid);
	boolean  insertUser(User user);
	boolean  updateUser(User user);
	boolean  deleteUser(Long userid);
	boolean  reset_password(Long userid);
	PageInfo<User> queryByPage(Integer pageNo,Integer pageSize);
	List<User> getUserByDate(Map<String, Object> map);
	 HSSFWorkbook export() ;
	
}