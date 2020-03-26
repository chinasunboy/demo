package demo.service;

import demo.domain.Role;
import demo.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
//使用springSecurity是接口必须继承UserDetailsService
public interface IUserService extends UserDetailsService {

    //查询用户信息
    List<UserInfo> findAll() throws Exception;
    //用户添加
    void save(UserInfo userInfo) throws Exception;
    //查询指定id的用户
    UserInfo findById(String id) throws Exception;
    //根据用户id查询可以添加的角色1
    List<Role> findOtherRoles(String userId) throws Exception;
    //给用户添加角色2
    void addRoleToUser(String userId, String[] roleIds);
}
