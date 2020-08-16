package com.cqupt.bookserver.ServiceImpl;

import com.cqupt.bookserver.Bean.AdminUserRole;
import com.cqupt.bookserver.Dao.AdminUserRoleMapper;
import com.cqupt.bookserver.Service.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {

    @Autowired
    AdminUserRoleMapper userRoleMapper;

    @Override
    public int addUserRole(String userType, int rid) {
        return userRoleMapper.addUserRole(userType, rid);
    }
}
