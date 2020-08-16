package com.cqupt.bookserver.Dao;


import com.cqupt.bookserver.Bean.AdminUserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: AdminUserRoleMapper
 * @Description: AdminUserRoleMapper
 * @Author: wsz
 * @Date: 2020/3/27 22:47
 * @Version 1.0
 **/
public interface AdminUserRoleMapper {

    @Select("select * from admin_user_role where usertype=#{usertype}")
    List<AdminUserRole> getAllRoleByUid(@Param("usertype") String usertype);

    @Insert("insert into admin_user_role(usertype,rid) VALUES(#{usertype},#{rid})")
    int addUserRole(@Param("usertype") String usertype, @Param("rid") int rid);
}
