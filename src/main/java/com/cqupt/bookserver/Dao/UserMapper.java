package com.cqupt.bookserver.Dao;

import com.cqupt.bookserver.Bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @ClassName: UserMapper
 * @Description: UserMapper类
 * @Author: wsz
 * @Date: 2020/3/27 14:22
 * @Version 1.0
 **/
@Repository
public interface UserMapper {

    /**
     * 根据用户id查找用户
     *
     * @param id 用户id
     * @return 用户实体
     */
    @Select("select * from user where id=#{id}")
    User findUserById(@Param("id") Long id);

    /**
     * 向user表中插入新用户
     *
     * @param user 新用户信息
     * @return 受影响行数
     */
    @Insert("insert into user(username,password,salt,name,phone,email,enabled) values(#{username},#{password}," +
            "#{salt},#{name},#{phone},#{email},#{enabled})")
    int addUser(User user);


    /**
     * 根据用户姓名查找用户信息
     *
     * @param username 用户姓名
     * @return 用户信息
     */
    @Select("select * from user where username=#{username}")
    User getUserByUsername(@Param("username") String username);


    /**
     * 查找用户是否存在
     *
     * @param username 用户姓名
     * @return 字符串用户名
     */
    @Select("select username from user where username=#{username}")
    String isExist(@Param("username") String username);

    @Select("select username,name,phone,email from user where username=#{username}")
    User getUserInfoByUsername(@Param("username") String username);

    @Update("update user set password = #{password} where username=#{username}")
    int updatePassword(@Param("password") String pwd, @Param("username") String uname);

    /**
     * 查找所有的用户信息
     *
     * @return 所有的用户信息
     */
    @Select(value = "select * from user")
    Set<User> getAllUsers();

    @Delete("delete from user where id=#{id}")
    int deleteUserById(@Param("id") long id);

    @Update("update user set username=#{username},name =#{name},phone=#{phone},email=#{email},enabled=#{enabled} " +
            "where id=#{id}")
    int updateUserInfo(User user);
}
