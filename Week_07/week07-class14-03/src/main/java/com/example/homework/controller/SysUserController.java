package com.example.homework.controller;

import com.example.homework.entity.SysUser;
import com.example.homework.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SysUserController
{
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list()
    {
        List<SysUser> list = sysUserService.selectList();
        return list;
    }

    @PostMapping("/create")
    public List<SysUser> create(@RequestBody SysUser sysUser)
    {
        List<SysUser> list = sysUserService.create(sysUser);
        return list;
    }


}
