package com.zym.service;


import java.util.List;
import java.util.Map;

import com.zym.domain.Admin;
import com.zym.domain.AdminVo;
import com.zym.domain.Role;

public interface AdminService {
	  public AdminVo checkLogin(String username, String password);
	  public List<AdminVo> getAdminlist();
	  public List<Role>  getRolelist();
	  public boolean  insertadmin(Admin admin);
	  public Admin  getAdminbymanagerid(int managerid);
	  public  boolean  deleteadmin(int managerid);
	  public  boolean updateadmin(Admin admin);
	  List<AdminVo> getAdminByDate(Map<String, Object> map);

}
