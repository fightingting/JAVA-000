package com.homework.demo.mapper;

import com.homework.demo.entity.SysUser;

import java.util.List;

/**
 * 角色表 数据层
 *
 * @author hengqi
 */
public interface SysUserMapper
{
    List<SysUser> selectUserList();
}
