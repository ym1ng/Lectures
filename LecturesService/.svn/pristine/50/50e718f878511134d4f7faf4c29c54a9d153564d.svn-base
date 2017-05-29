package com.zym.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zym.dao.RoleMapper;
import com.zym.domain.Role;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	public List<Role> selectRolelist() {

		return roleMapper.selectRoleList();
	}

	public boolean insertRole(Role role) {
		
		if (roleMapper.selectRolebyRolename(role.getRolename())==null) {
			int result = roleMapper.insertSelective(role);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean updateRole(Role role) {
		int result=roleMapper.updateByPrimaryKeySelective(role);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean deleteRole(int roleid) {
		int result=roleMapper.deleteByPrimaryKey(roleid);
		if (result==1) {
			return true;
		}
		return false;
	}

	public Role selectRolebyroleid(int roleid) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleid);
	}

}