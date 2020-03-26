package demo.service.impl;

import demo.dao.IUserDao;
import demo.domain.Role;
import demo.domain.UserInfo;
import demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    //调用dao层
    @Autowired
    private IUserDao userDao;

    //调用SpringSecurity的加密类，在Security的配置文件中实例化这个bean
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //给用户添加角色
    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

    //2.根据用户id查询可以添加的角色
    @Override
    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }

    //查询指定id的用户
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    //用户添加
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    //查询用户表信息
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }


    //当点击登陆时就是执行/login.do路径时，自动到userService下找到UserDetails loadUserByUsername方法进行验证
    //调用SpringSecurity框架实现用户登陆逻辑
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //User为UserDetails中的方法
        //处理自己的用户对象封装成UserDetails相当于将查询到的用户信息封装到里面
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        //之后的四个参数，第一个为账户是否可用0为false，后面一般设置为true
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    //roles可以通过userDao查询返回的Role集合中获取
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
