package com.example.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangtingting
 * @date 2020-11-18 19:20
 * -------------------------------------------------------------------------
 * 配置 Hikari 连接池，改进上述操作
 * -------------------------------------------------------------------------
 */
@RestController
public class HikariDemoController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "id", required = true) Integer id) {
        String name = getNameById(id);
        return (name == null) ? "Hello World" : ("Hello " + name);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) Integer id) {
        deleteById(id);
        return "success";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@RequestParam(value = "id", required = true) Integer id,@RequestParam(value = "name", required = true) String name) {
        String sql = "insert into sys_role(id,name ) values(?,?) ";
        jdbcTemplate.update(sql, new Object[] {id,name});
        return "success";
    }

    private void deleteById(Integer id) {
        String sql = "delete from sys_role where id = ? ";
        jdbcTemplate.update(sql, new Object[] {id});
    }

    public String getNameById(Integer id) {
        String sql = "select name from sys_role where id = ? ";
        List<String> list = jdbcTemplate.queryForList(sql, new Object[] {id}, String.class);
        return list.isEmpty() ? null : list.get(0);
    }
}
