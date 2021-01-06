package com.example.homework.service;

import com.example.homework.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author tingting
 */
@Service
@Slf4j
public class SysUserService  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SysUser> selectList() {
        String sql = "select * from sys_user ";
        List<SysUser> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SysUser>(SysUser.class));
        return list;
    }

    public List<SysUser> create(SysUser sysUser) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into sys_user(user_id, username,mobile,status)");
        sb.append(" values (");
        sb.append(sysUser.getUserId()).append(",'");
        sb.append(sysUser.getUsername()).append("','");
        sb.append(sysUser.getMobile()).append("',");
        sb.append(sysUser.getStatus());
        sb.append(")");
        jdbcTemplate.update(sb.toString());
        //强制从主库查询
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        String sql = "select * from sys_user ";
        List<SysUser> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SysUser>(SysUser.class));
        hintManager.close();


        return list;
    }
}
