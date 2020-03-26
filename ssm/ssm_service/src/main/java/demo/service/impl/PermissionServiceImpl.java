package demo.service.impl;

import demo.dao.IPermissionDao;
import demo.domain.Permission;
import demo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService{

    @Autowired
    private IPermissionDao permissionDao;

    //删除权限操作
    @Override
    public void deleteById(String id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }
    //权限的详情
    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }

    //保存权限信息
    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    //查询权限表
    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }
}
