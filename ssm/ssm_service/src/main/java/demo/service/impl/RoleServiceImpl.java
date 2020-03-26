package demo.service.impl;

import demo.dao.IRoleDao;
import demo.domain.Permission;
import demo.domain.Role;
import demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {


    @Autowired
    private IRoleDao roleDao;


    //根据roleId查询role，并查询出可以添加的权限 1
    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    //根据roleId查询role，并查询出可以添加的权限 2
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    //角色删除操作
    @Override
    public void deleteRoleById(String roleId) {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    //角色详情查询
    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }


    //保存角色
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }


    //查询角色表
    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }
}
