package com.sx.sports.service;
import com.sx.sports.entity.Role;
import java.util.List;

public interface RoleService {
    /**
     * 查询全部角色
     */
    public List<Role> findRoleList();
    /**
     * 根据角色code查找角色信息
     */
    public Role findRoleByCode(String userName);
    /**
     * 添加角色
     */
    public int insertRole(Role role);
    /**
     * 修改角色信息
     */
    public int updateRole(Role role);
    /**
     * 删除角色
     */
    public int deleteRole(int roleId);
}