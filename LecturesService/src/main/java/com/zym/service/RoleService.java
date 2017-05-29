package com.zym.service;

import java.util.List;

import com.zym.domain.Role;


public interface RoleService {
	List<Role> selectRolelist();
	Role selectRolebyroleid(int roleid);
	boolean  insertRole(Role role);
	boolean  updateRole(Role role);
	boolean  deleteRole(int roleid);
}