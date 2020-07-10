package com.sword.server.basic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置类
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@Configuration
@MapperScan({"com.sword.server.*.repository.mapper"})
public class MybatisPlusConfig {

}