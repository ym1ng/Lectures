package com.zym.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.dao.UserMapper;
import com.zym.domain.User;

@Service  
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserMapper userMapper;

	public List<User> selectUserlist() {
		return userMapper.selectUserList();
	}

	public User selectUserbyuserid(Long userid) {

		return userMapper.selectByPrimaryKey(userid);
	}

	public boolean insertUser(User user) {
		if (userMapper.selectUserbyUsername(user.getUsername())==null) {
			int result = userMapper.insertSelective(user);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean updateUser(User user) {
		int result=userMapper.updateByPrimaryKeySelective(user);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean deleteUser(Long userid) {
		int result=userMapper.deleteByPrimaryKey(userid);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean reset_password(Long userid) {
		User user=new User();
		user.setUserid(userid);
		user.setPassword("123456");
		if (userMapper.updateByPrimaryKeySelective(user)==1) {
			return true;
		}
		return false;
	}

	public PageInfo<User> queryByPage(Integer pageNo, Integer pageSize) {
		 pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<User> list = userMapper.selectUserList();
		    //用PageInfo对结果进行包装
		    PageInfo<User> page = new PageInfo<User>(list);
		    //测试PageInfo全部属性
//		    System.out.println(page.getPageNum());
//		    System.out.println(page.getPageSize());
//		    System.out.println(page.getStartRow());
//		    System.out.println(page.getEndRow());
//		    System.out.println(page.getTotal());
//		    System.out.println(page.getPages());
//		    System.out.println(page.getFirstPage());
//		    System.out.println(page.getLastPage());
//		    System.out.println(page.isHasPreviousPage());
//		    System.out.println(page.isHasNextPage());
		    return page;
	}

	public List<User> getUserByDate(Map<String, Object> map) {
		return userMapper.getUserByDate(map);
	}

	public HSSFWorkbook export() {
		  
	    String[] excelHeader = { "用户编号", "用户名称", "用户邮箱","手机","院系","地址","注册时间"};  
	     List<User> list =userMapper.selectUserList();
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        HSSFSheet sheet = wb.createSheet("User");  
	        HSSFRow row = sheet.createRow((int) 0);  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	        for (int i = 0; i < excelHeader.length; i++) {  
	            HSSFCell cell = row.createCell(i);  
	            cell.setCellValue(excelHeader[i]);  
	            cell.setCellStyle(style);  
//	            sheet.autoSizeColumn(i); 
	          sheet.setColumnWidth(i, 50 *100);  
	        }  
	        sheet.autoSizeColumn(1, true);
	        for (int i = 0; i < list.size(); i++) {  
	            row = sheet.createRow(i + 1);  
	            User user = list.get(i);  
	            row.createCell(0).setCellValue(user.getUserid());  
	            row.createCell(1).setCellValue(user.getRealname());  
	            row.createCell(2).setCellValue(user.getEmail());  
	            row.createCell(3).setCellValue(user.getPhone());  
	            row.createCell(4).setCellValue(user.getColleges().getCollegesname());  
	            row.createCell(5).setCellValue(user.getAddress());
	            row.createCell(6).setCellValue(user.getAddtime()); 
	            
	        }  
	        return wb;  
	    
	}  

   
}