package com.cqupt.bookserver.Service;

import com.cqupt.bookserver.Bean.AdminMenu;

import java.util.List;

/**
 * @ClassName: AdminMenuService
 * @Description: AdminMenuService
 * @Author: wsz
 * @Date: 2020/3/27 22:54
 * @Version 1.0
 **/
public interface AdminMenuService {

    List<AdminMenu> getMenuByCurrentUser();

    List<AdminMenu> getMenuByParentId(int id);

    List<AdminMenu> handleMenus(List<AdminMenu> menus);

    List<AdminMenu> handleChildMenus(List<AdminMenu> menus);
}
