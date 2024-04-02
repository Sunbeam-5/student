package com.example.service;

import com.example.entity.Admin;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;
    /**
     * 登录
     */
    public Admin login(Admin admin) {
        Admin dbAdmin = adminMapper.selectByUserName(admin.getUsername());
        if (dbAdmin == null) {
            // 用户不存在
            throw new CustomException("账号或密码错误");
        }
        if (!admin.getPassword().equals(dbAdmin.getPassword())) {
            // 密码错误
            throw new CustomException("账号或密码错误");
        }
        // 登录成功
        return dbAdmin;
    }

}
