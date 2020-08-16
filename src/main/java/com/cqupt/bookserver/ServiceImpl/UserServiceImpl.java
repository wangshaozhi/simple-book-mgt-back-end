package com.cqupt.bookserver.ServiceImpl;


import com.cqupt.bookserver.Bean.AdminUserRole;
import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.Bean.User;
import com.cqupt.bookserver.Dao.AdminUserRoleMapper;
import com.cqupt.bookserver.Dao.UserMapper;
import com.cqupt.bookserver.Service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户service实现层
 * @Author: wsz
 * @Date: 2020/3/27 14:35
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminUserRoleMapper userRoleMapper;

    @Override
    public Set<User> getAllUsers() {
        Set allUsers = userMapper.getAllUsers();
        if (null != allUsers) {
            return allUsers;
        }
        return null;
    }

    @Override
    public User getUserInfoByUsername(String username) {
        User user = userMapper.getUserInfoByUsername(username);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public int updatePassword(String uname, String pwd) {
        String salt = "", new_pwd = "";
        System.out.println(pwd + uname);
        //根据用户名获取用户的信息
        User oldUser = getUserByUsername(uname);
        salt = oldUser.getSalt();
        //获取原有的盐值，并将新密码进行加密
        new_pwd = new SimpleHash("md5", pwd, salt, 2).toString();
        return userMapper.updatePassword(new_pwd, uname);
    }

    @Override
    public User findByUserId(Long id) {
        User user = userMapper.findUserById(id);
        if (user != null) {
            return user;
        }
        return new User();
    }

    @Override
    public int addUser(User user) {
        String username = user.getUsername(), password = user.getPassword();
        //生成盐，默认长度是16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //hash算法迭代次数
        int times = 2;
        //hash之后的密码
        String encodeedPwd = new SimpleHash("md5", password, salt, times).toString();
        //注册的用户
        User reg_user = new User();
        reg_user.setUsername(username);
        reg_user.setSalt(salt);
        reg_user.setPassword(encodeedPwd);
        reg_user.setEmail(user.getEmail());
        reg_user.setName(user.getName());
        reg_user.setPhone(user.getPhone());
        reg_user.setEnabled(user.isEnabled());
        int user_type = user.getName().equals("普通用户") ? 2 : 1;
        if (userRoleMapper.addUserRole(user.getUsername(), user_type) > 0 && userMapper.addUser(reg_user) > 0) {
            return 1;
        }
        return -1;
    }

    @Override
    public int deleteUserById(long id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public boolean isExist(String username) {
        String result = userMapper.isExist(username);
        if (!StringUtils.isEmpty(result)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }
}
