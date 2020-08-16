package com.cqupt.bookserver.Dao;

import com.cqupt.bookserver.Bean.AdminRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: AdminRoleMenuMapper
 * @Description: AdminRoleMenuMapper
 * @Author: wsz
 * @Date: 2020/3/27 22:41
 * @Version 1.0
 **/
public interface AdminRoleMenuMapper {

    @Select("select * from admin_role_menu where rid=#{rid}")
    List<AdminRoleMenu> getMenuByRid(@Param("rid") int rid);
}
