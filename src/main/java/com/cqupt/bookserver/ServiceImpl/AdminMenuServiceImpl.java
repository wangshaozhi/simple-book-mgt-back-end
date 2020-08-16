package com.cqupt.bookserver.ServiceImpl;


import com.cqupt.bookserver.Bean.AdminMenu;
import com.cqupt.bookserver.Bean.AdminRoleMenu;
import com.cqupt.bookserver.Bean.AdminUserRole;
import com.cqupt.bookserver.Bean.User;
import com.cqupt.bookserver.Dao.AdminMenuMapper;
import com.cqupt.bookserver.Dao.AdminRoleMenuMapper;
import com.cqupt.bookserver.Dao.AdminUserRoleMapper;
import com.cqupt.bookserver.Service.AdminMenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AdminMenuServiceImpl
 * @Description: AdminMEnuServiceImpl
 * @Author: wsz
 * @Date: 2020/3/27 22:55
 * @Version 1.0
 **/
@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AdminMenuMapper adminMenuMapper;

    @Autowired
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Autowired
    AdminUserRoleMapper adminUserRoleMapper;

    @Override
    public List<AdminMenu> getMenuByCurrentUser() {
        if (SecurityUtils.getSubject().getPrincipal() == null) {
            return null;
        }
        //获取当前登录用户的用户名
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        //根据用户名获取当前用户
        User user = userService.getUserByUsername(username);
        //根据用户name字段获取当前用户的角色
        List<AdminUserRole> adminUserRoles = adminUserRoleMapper.getAllRoleByUid(user.getName());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole item : adminUserRoles) {
            //根据角色获取菜单
            List<AdminRoleMenu> roleMenus = adminRoleMenuMapper.getMenuByRid(item.getRid());
            for (AdminRoleMenu menuItem : roleMenus) {
                AdminMenu adminMenu = adminMenuMapper.getMenuById(menuItem.getMid());
                if (!menus.contains(adminMenu)) {
                    menus.add(adminMenu);
                }
            }
        }
        List<AdminMenu> result = handleMenus(menus);
        List<AdminMenu> fin_result = handleChildMenus(result);
        return fin_result;
    }

    @Override
    public List<AdminMenu> handleMenus(List<AdminMenu> menus) {
        for (AdminMenu item : menus) {
            List<AdminMenu> children = getMenuByParentId(item.getId());
            item.setChildren(children);
        }
        //删除所有父节点不为0的菜单
//        menus.removeIf(item -> item.getParentid() != 0);
        return menus;
    }

    @Override
    public List<AdminMenu> handleChildMenus(List<AdminMenu> menus) {
        for (AdminMenu item : menus) {
            //再次遍历二级菜单获取到三级菜单
            for (int i = 0; i < item.getChildren().size(); i++) {
                List<AdminMenu> children = getMenuByParentId(item.getChildren().get(i).getId());
                item.getChildren().get(i).setChildren(children);
            }
        }
        //删除所有父节点不为0的菜单
        menus.removeIf(item -> item.getParentid() != 0);
        return menus;
    }

    @Override
    public List<AdminMenu> getMenuByParentId(int parentId) {
        return adminMenuMapper.findMenuByParentId(parentId);
    }

}
