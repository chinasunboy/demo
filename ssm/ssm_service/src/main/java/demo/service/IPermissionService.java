package demo.service;

import demo.domain.Permission;

import java.util.List;

public interface IPermissionService {

    //查询权限表
    public List<Permission> findAll() throws Exception;
    //保存权限信息
    void save(Permission permission) throws Exception;
    //权限的详情
    Permission findById(String id) throws Exception;
    //删除权限操作
    void deleteById(String id) throws Exception;
}
