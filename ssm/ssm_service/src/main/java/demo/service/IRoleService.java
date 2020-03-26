package demo.service;

import demo.domain.Permission;
import demo.domain.Role;

import java.util.List;

public interface IRoleService {

    //查询角色表
    public List<Role> findAll() throws Exception;
    //保存角色
    void save(Role role) throws Exception;
    //角色详情查询
    Role findById(String roleId) throws  Exception;
    //角色删除操作
    void deleteRoleById(String roleId) throws Exception;
    //根据roleId查询role，并查询出可以添加的权限 1
    List<Permission> findOtherPermissions(String roleId) throws Exception;
    //根据roleId查询role，并查询出可以添加的权限 2
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

}
