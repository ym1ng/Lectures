package com.zym.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.AdminMapper;
import com.zym.dao.AdminMapperVo;
import com.zym.dao.RoleMapper;
import com.zym.domain.Admin;
import com.zym.domain.AdminVo;
import com.zym.domain.Role;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapperVo adminMapperVo;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private RoleMapper roleMapper;
	public AdminVo checkLogin(String username, String password) {
		AdminVo adminVo = adminMapperVo.selectAdmin(username);
		
		   if (adminVo != null && adminVo.getPassword().equals(password)) {
	            return adminVo;
	        }
		return null;
	}

	public List<AdminVo> getAdminlist() {
		return 	adminMapperVo.selectAdminList();
	}

	public List<Role> getRolelist() {
	  
		return roleMapper.selectRoleList();
	}

	public boolean insertadmin(Admin admin) {
		
		if (adminMapperVo.selectAdmin(admin.getUsername())==null) {
			int result= adminMapper.insertSelective(admin);
		    if (result==1) {
				return true;
			}
		}
		return false;
	}

	public Admin getAdminbymanagerid(int managerid) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(managerid);
	}

	public boolean deleteadmin(int managerid) {
		int result=adminMapper.deleteByPrimaryKey(managerid);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean updateadmin(Admin admin) {
		int result=adminMapper.updateByPrimaryKeySelective(admin);
		if (result==1) {
			return true;
		}
		return false;
	}

	public List<AdminVo> getAdminByDate(Map<String, Object> map) {
		return adminMapperVo.getAdminByDate(map);

	}

}
