package com.cqupt.bookserver.Dao;

import com.cqupt.bookserver.Bean.AdminMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: AdminMenuMapper
 * @Description: AdminMenuMapper
 * @Author: wsz
 * @Date: 2020/3/27 22:35
 * @Version 1.0
 **/
public interface AdminMenuMapper {

    @Select("select * from admin_menu where id=#{id}")
    AdminMenu getMenuById(@Param("id") int id);

    @Select("select * from admin_menu where parentid=#{id}")
    List<AdminMenu> findMenuByParentId(@Param("id") int id);
}
