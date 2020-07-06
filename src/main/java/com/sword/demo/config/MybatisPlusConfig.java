package com.sword.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置类
 * @author sword
 * @date 2020-07-06 19:39:35
 */
@Configuration
@MapperScan({"com.sword.demo.mapper", "com.sword.demo.*.mapper"})
public class MybatisPlusConfig {

}
