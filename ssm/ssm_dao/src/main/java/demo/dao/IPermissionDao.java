package demo.dao;

import demo.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    //用户详情页的信息
    //Security的登陆验证操作所需的信息
    //通过中间表查询permissions
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    //查询权限表
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;
    //保存权限信息
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
    //权限的详情
    @Select("select * from permission where id=#{id}")
    Permission findById(String id) throws Exception;
    //删除权限操作1
    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id) throws Exception;
    //删除权限操作2
    @Delete("delete from permission where id=#{id}")
    void deleteById(String id) throws Exception ;
}
