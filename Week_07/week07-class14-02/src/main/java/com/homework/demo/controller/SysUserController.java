package com.homework.demo.controller;

import com.homework.demo.entity.SysUser;
import com.homework.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色信息
 *
 * @author hengqi
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController
{
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list1")
    public List<SysUser> listDB1()
    {
        List<SysUser> list = sysUserService.selectUserList();
        System.out.println(list.get(0));
        return list;
    }

    @GetMapping("/list2")
    public List<SysUser> listDB2()
    {
        List<SysUser> list = sysUserService.selectUserList2();
        System.out.println(list.get(0));
        return list;
    }


}
