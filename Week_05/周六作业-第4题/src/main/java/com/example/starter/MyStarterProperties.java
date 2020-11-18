package com.example.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangtingting
 * @date 2020-11-18 16:36
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@Data
@ConfigurationProperties(prefix = "my.starter")
public class MyStarterProperties {

    private String studentName;
    private int studentId;

}
