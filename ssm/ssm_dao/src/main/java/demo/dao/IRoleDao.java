package demo.dao;

import demo.domain.Permission;
import demo.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //用户详情页的信息
    //根据用户id查询出所有对应的角色
    //Security的登陆验证操作所需的信息
    //通过中间表查询permissions
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "demo.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    //查询角色表
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //保存角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    //角色详情查询，关联查询，将权限信息查询出来
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "demo.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);



    //角色删除操作
    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);
    //角色删除操作
    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);
    //角色删除操作
    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(String roleId);



    //根据roleId查询role，并查询出可以添加的权限 1
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);
    //根据roleId查询role，并查询出可以添加的权限 2
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
