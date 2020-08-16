package com.cqupt.bookserver.Controller;


import com.cqupt.bookserver.Bean.AdminMenu;
import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.ServiceImpl.AdminMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: AdminMenuController
 * @Description: AdminMenuController
 * @Author: wsz
 * @Date: 2020/3/27 23:27
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class AdminMenuController {

    @Autowired
    AdminMenuServiceImpl adminMenuService;

    @GetMapping("/api/getMenu")
    public Response<List<AdminMenu>> getMenus() {
        List<AdminMenu> result = adminMenuService.getMenuByCurrentUser();
        if (result == null) {
            return Response.fail("用户未登录，请先登录！");
        }
        return Response.success(adminMenuService.getMenuByCurrentUser());
    }

}
