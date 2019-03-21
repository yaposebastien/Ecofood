package tech.attecoube.ecofood.dao;

import tech.attecoube.ecofood.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
