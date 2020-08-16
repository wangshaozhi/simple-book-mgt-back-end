package com.cqupt.bookserver.Service;


import com.cqupt.bookserver.Bean.User;

import java.util.Set;

/**
 * @ClassName: UserService
 * @Description: 用户Service层
 * @Author: wsz
 * @Date: 2020/3/27 14:34
 * @Version 1.0
 **/
public interface UserService {

    User findByUserId(Long id);

    int addUser(User user);

    boolean isExist(String username);

    User getUserByUsername(String username);

    User getUserInfoByUsername(String username);

    int updatePassword(String pwd, String uname);

    Set<User> getAllUsers();

    int deleteUserById(long id);

    int updateUserInfo(User user);
}
