package com.cqupt.bookserver.Controller;


import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.Bean.User;
import com.cqupt.bookserver.ServiceImpl.AdminUserRoleServiceImpl;
import com.cqupt.bookserver.ServiceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @ClassName: UserController
 * @Description: User控制类
 * @Author: wsz
 * @Date: 2020/3/27 14:38
 * @Version 1.0
 **/
@RestController
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/api/login")
    public Response<String> login(@RequestBody User user) {
        String username = user.getUsername();
        Subject subject = SecurityUtils.getSubject();
        //生成token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return Response.success(usernamePasswordToken);
        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            return Response.fail("账号或密码错误！");
        }

    }

    @GetMapping(value = "/api/logout")
    public Response logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Response.success("登出成功！");
    }

    @PostMapping("/api/register")
    public Response<String> register(@RequestBody User user) {
        boolean exist = userService.isExist(user.getUsername());
        if (exist) {
            return Response.fail("该用户已注册，请更换用户名！");
        }
        return userService.addUser(user) > 0 ? Response.success("注册成功！") : Response.success("注册失败！");
    }


    @GetMapping("/api/getUser")
    public Response<User> getUserByUsername(@RequestParam String username) {
        User user = userService.getUserByUsername(username);
        if (!StringUtils.isEmpty(user.getUsername())) {
            return Response.success(user);
        } else {
            return Response.fail(new User());
        }
    }

    @GetMapping("/api/getUserInfo")
    public Response<User> getUserInfoByUsername(@RequestParam String username) {
        User user = userService.getUserInfoByUsername(username);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.fail("get user info failed");
        }
    }

    @PostMapping("/api/updatePassword")
    public Response<String> updateUserPassword(@RequestBody User user) {
        int line = userService.updatePassword(user.getUsername(), user.getPassword());
        if (line > 0) {
            return Response.success("update user password success");
        } else {
            return Response.fail("update user password fail");
        }
    }

    @GetMapping("/api/getAllUsers")
    public Response<Set<User>> getAllUsers() {
        Set<User> allUsers = userService.getAllUsers();
        if (allUsers != null) {
            return Response.success(allUsers);
        } else {
            return Response.fail("get allUsers failed");
        }
    }

    @PostMapping("/api/deleteUserById")
    public Response<String> deleteUserById(@RequestBody User user) {
        System.out.println(user.getId());
        return userService.deleteUserById(user.getId()) > 0 ? Response.success("删除成功！") : Response.fail("删除失败！");
    }

    @PostMapping("/api/updateUserInfo")
    public Response<String> updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user) > 0 ? Response.success("更新成功！") : Response.fail("更新失败！");
    }
}
