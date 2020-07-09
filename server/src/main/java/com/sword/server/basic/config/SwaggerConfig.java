package com.sword.server.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 返回swaggerAPI文档
     * @return springfox.documentation.spring.web.plugins.Docket
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())// 设置该API基本信息
                .select() // 返回一个ApiSelectorBuilder实例用来设置哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage("com.sword.server.demo.interfaces.api")) // 暴露com.sword.server.demo.interfaces.api下的所有类的方法
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 返回一个API基本信息
     * @return springfox.documentation.service.ApiInfo
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档标题")//标题
                .description("API文档描述")//描述
                .termsOfServiceUrl("http://localhost:8080/demo")//服务条款地址
                .contact(new Contact("sword", "http://localhost:8080/demo" , "wukj1992710@163.com"))//设置联系人名称、网址、电子邮件
                .version("1.0")//文档的版本
                .build();
    }
}
