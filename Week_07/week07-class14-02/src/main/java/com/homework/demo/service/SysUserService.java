package com.homework.demo.service;

import com.homework.demo.config.CurDataSource;
import com.homework.demo.entity.SysUser;
import com.homework.demo.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 业务层处理
 *
 * @author hengqi
 */
@Service
@Slf4j
public class SysUserService  {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> selectUserList() {
        return sysUserMapper.selectUserList();
    }

    @CurDataSource(name="second")
    public List<SysUser> selectUserList2() {
        return sysUserMapper.selectUserList();
    }
}
