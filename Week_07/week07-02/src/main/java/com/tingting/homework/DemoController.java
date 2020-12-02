package com.tingting.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtingting
 * @date 2020-12-02 21:14
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@RestController
public class DemoController {

    @Autowired
    JdbcTemplate jdbcTemplate;

	//一条一条查，很慢，需要四分多钟
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public void test1() {
        long before = System.currentTimeMillis();
        String sql = "insert into t_order(order_no,user_id,product_id,quality,amount,status,create_by) values(?,?,?,?,?,?,?) ";
        for (int i = 0; i <100000 ; i++) {
            jdbcTemplate.update(sql, new Object[] {"QW32323","29271","1",2,13,0,"29271"});
        }
        long after = System.currentTimeMillis();

        System.out.println("执行时间："+(after-before));
    }

	//批量插入很快，只需要几秒
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public void test2() {
        long before = System.currentTimeMillis();
        StringBuilder sql = new StringBuilder("insert into t_order(order_no,user_id,product_id,quality,amount,status,create_by) values ");
        for (int i = 0; i <100000 ; i++) {
            if(i==99999){
                sql.append(" ('QW32323','29271',1,2,13,0,'29271');");
            }else{
                sql.append(" ('QW32323','29271',1,2,13,0,'29271'),");
            }
        }
        jdbcTemplate.update(sql.toString());
        long after = System.currentTimeMillis();
        System.out.println("执行时间："+(after-before));
    }
}
