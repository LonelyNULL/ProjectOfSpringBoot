# SpringBoot+MybatisPlus+MYSQL项目后端开发

## 准备工作

### jdk8安装和环境配置

### maven环境搭建

### IDEA插件安装

* Lombok
* Spring Boot

## 快速搭建项目

* IDEA创建项目
![IDEA创建项目](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA1.png)

* 初始化一个Spring项目
![初始化一个Spring项目](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA2.png)

* 设置项目的maven坐标和包
![设置项目的maven坐标和包](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA3.png)

* 添加必须的依赖包
  1. Spring Boot DevTools （热部署）
  2. Lombok （代码简化）
  3. Spring Web （快速Web应用开发）
  4. MySQL Driver （MySQL驱动）

    ![添加必须的依赖包](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA4.png)

    ![Spring Boot DevTools和Lombok](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA5.png)

    ![Spring Web](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA6.png)

    ![MySQL Driver](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA7.png)

* 设置项目名称和路径
![设置项目名称和路径](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA8.png)

* 项目创建成功，如果右下角出现“Maven projects need to be imported”提示框则点击“Enable Auto-Import”选项，自动下载导入依赖包
![项目创建成功](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA8.5.png)
![自动下载导入依赖包](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA9.png)

* 启动应用，点击ServerApplication类的类名左边的三角图标使用运行或调试的模式来启动应用
![启动应用1](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA10.png)
![启动应用2](https://raw.githubusercontent.com/LonelyNULL/ProjectOfSpringBoot/master/image/1.%E9%A1%B9%E7%9B%AE%E5%88%9B%E5%BB%BA11.png)

    ```log
    2020-06-23 09:47:58.998  INFO 1160 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2020-06-23 09:47:58.999  INFO 1160 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
    2020-06-23 09:47:59.105  INFO 1160 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2020-06-23 09:47:59.105  INFO 1160 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1174 ms
    2020-06-23 09:47:59.286  INFO 1160 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2020-06-23 09:47:59.416  INFO 1160 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    2020-06-23 09:47:59.449  INFO 1160 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2020-06-23 09:47:59.459  INFO 1160 --- [  restartedMain] com.sword.demo.DemoApplication           : Started DemoApplication in 2.017 seconds (JVM running for 3.754)
    ```

## 添加额外依赖的jar包

* 在pom.xml的properties标签下添加额外依赖的jar包的版本信息

    ```xml
    <properties>
        <java.version>1.8</java.version>
        <mapstruct.version>1.3.0.Final</mapstruct.version>
        <swagger.version>2.9.2</swagger.version>
        <guava.version>27.1-jre</guava.version>
        <mybatisplus.version>3.3.2</mybatisplus.version>
        <velocity.version>2.2</velocity.version>
        <commons-lang3.version>3.10</commons-lang3.version>
    </properties>
    ```

* 在pom.xml的dependencies添加额外依赖的jar包的坐标信息

    ```xml
    <!-- java.lang.*相关的工具 -->
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>${commons-lang3.version}</version>
    </dependency>

    <!-- mybatis-plus -->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>${mybatisplus.version}</version>
    </dependency>

    <!-- mybatis-plus代码生成器 -->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-generator</artifactId>
        <version>${mybatisplus.version}</version>
    </dependency>

    <!-- velocity模板 -->
    <dependency>
        <groupId>org.apache.velocity</groupId>
        <artifactId>velocity-engine-core</artifactId>
        <version>${velocity.version}</version>
    </dependency>

    <!-- 类型转换器 -->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${mapstruct.version}</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${mapstruct.version}</version>
        <scope>provided</scope>
    </dependency>

    <!-- swagger2 -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>${swagger.version}</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>${swagger.version}</version>
    </dependency>
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>${guava.version}</version>
    </dependency>
    ```

## MYSQL建表

* 新建mysql连接

    使用Navicat新建mysql连接
    ![使用Navicat新建mysql连接](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A81-%E6%96%B0%E5%BB%BA%E8%BF%9E%E6%8E%A5.png?raw=true)

    输入连接名、主机名或IP地址、端口、用户名和密码
    ![输入连接名、主机名或IP地址、端口、用户名和密码](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A82-%E6%96%B0%E5%BB%BA%E8%BF%9E%E6%8E%A5.png?raw=true)

    生成mysql连接
    ![生成mysql连接](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A83-%E6%96%B0%E5%BB%BA%E8%BF%9E%E6%8E%A5.png?raw=true)

* 新建数据库

    双击打开连接
    ![双击打开连接](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A84-%E6%96%B0%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png?raw=true)

    然后右键新建数据库
    ![右键新建数据库](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A85-%E6%96%B0%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png?raw=true)

    输入数据库名和字符集
    ![输入数据库名和字符集](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A86-%E6%96%B0%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png?raw=true)

    生成数据库
    ![生成数据库](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A87-%E6%96%B0%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png?raw=true)

* 建表

    在新建的数据库中点击新建查询
    ![新建查询](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A88-%E5%BB%BA%E8%A1%A8.png?raw=true)

    输入如下建表语句并点击运行按钮执行SQL

    ```SQL
    # 如果用户表存在则删除
    DROP TABLE IF EXISTS demo.user;

    # 创建用户表
    CREATE TABLE demo.user(
        id int UNSIGNED AUTO_INCREMENT COMMENT'主键id', # UNSIGNED-无符号即非负数因为还是4字节所以范围就从(-2 147 483 648，2 147 483 647)变到了(0，4 294 967 295)，AUTO_INCREMENT-自增序列
        `name` VARCHAR(100) COMMENT'用户名称',
        phone VARCHAR(20) COMMENT'用户手机',
        proc_inst_id VARCHAR(50) COMMENT'流程实例id',
        deleted CHAR(1) DEFAULT '0' COMMENT'逻辑删除标志，1-删除，0-未删除',
        PRIMARY KEY (id), # 设置主键
        INDEX index_user_id (id) # 创建主键id的索引
    )
    ENGINE=INNODB # ENGINE-设置存储引擎
    CHARSET=utf8 # CHARSET-设置编码
    COMMENT'用户'; # 表注释
    ```

    ![点击运行按钮执行SQL](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A89-%E5%BB%BA%E8%A1%A8.png?raw=true)

    右键新建的表点击“表设计”按钮可查看表结构
    ![点击“表设计”按钮](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A810-%E5%BB%BA%E8%A1%A8.png?raw=true)

    ![表结构](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/3.MYSQL%E5%BB%BA%E8%A1%A811-%E5%BB%BA%E8%A1%A8.png?raw=true)

## YAML配置

* 修改参数文件后缀，改为yml

    ![修改参数文件后缀1](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/2.YAML%E9%85%8D%E7%BD%AE1.png?raw=true)

    ![修改参数文件后缀2](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/2.YAML%E9%85%8D%E7%BD%AE2.png?raw=true)

    ![修改参数文件后缀3](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/2.YAML%E9%85%8D%E7%BD%AE3.png?raw=true)

* 参数配置

    ```yaml
    server:
      port: 8080 # 应用端口
      servlet:
        context-path: /demo # 应用根路径

    ---
    # 开发环境
    spring:
      profiles: dev
      # 热部署
      devtools:
        restart:
          enabled: true # 开启热部署
      # 数据源，设置成上面新建的数据库的参数
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/demo?characterEncoding=utf-8&serverTimezone=GMT%2B8
        username: root
        password: root

    ```

* 在IDEA的“运行/调式 配置”窗口添加`spring.profiles.active=dev`的环境变量激活开发环境的参数

    ![激活开发环境参数1](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/2.YAML%E9%85%8D%E7%BD%AE4.png?raw=true)

    ![激活开发环境参数2](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/2.YAML%E9%85%8D%E7%BD%AE5.png?raw=true)

* 重启应用，日志显示MybatisPlus的图案且没有报错则说明数据源配置成功可以正常使用

    ```log
     _ _   |_  _ _|_. ___ _ |    _
    | | |\/|_)(_| | |_\  |_)||_|_\
         /               |
                            3.3.2
    ```

## 基于MybatisPlus代码自动生成

* 将[https://github.com/LonelyNULL/ProjectOfSpringBoot/tree/master/code](https://github.com/LonelyNULL/ProjectOfSpringBoot/tree/master/code)下的`CodeGenerator.java`放到源码包`com.sword.server`下，同时将templates目录下模板文件放到资源目录`resources`下的`templates`目录下

    ![代码自动生成的代码拉取1](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%901.png?raw=true)

    ![代码自动生成的代码拉取2](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%902.png?raw=true)

* 修改`CodeGenerator.java`中的数据源配置，设置成上面新建的数据库的参数

    ![修改数据源配置](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%906.png?raw=true)

* 执行`CodeGenerator.java`中的`main`方法，在控制台中输入需要生成代码的表名，回车自动生成对应的代码

    ![执行代码生成](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%903.png?raw=true)

    ![输入表名](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%904.png?raw=true)

    成功日志

    ```log
    19:57:09.612 [main] DEBUG com.baomidou.mybatisplus.generator.AutoGenerator - ==========================准备生成文件...==========================
    Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
    19:57:09.963 [main] WARN org.apache.velocity.deprecation - configuration key 'file.resource.loader.unicode' has been deprecated in favor of 'resource.loader.file.unicode'
    19:57:09.964 [main] WARN org.apache.velocity.deprecation - configuration key 'file.resource.loader.class' has been deprecated in favor of 'resource.loader.file.class'
    19:57:09.970 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 创建目录： [E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\repository\entity]
    19:57:09.973 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 创建目录： [E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\interfaces\api]
    19:57:09.973 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 创建目录： [E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\repository\mapper]
    19:57:09.976 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 创建目录： [E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\service\impl]
    19:57:09.981 [main] DEBUG org.apache.velocity - Initializing Velocity, Calling init()...
    19:57:09.981 [main] DEBUG org.apache.velocity - Starting Apache Velocity v2.2
    19:57:09.983 [main] DEBUG org.apache.velocity - Default Properties resource: org/apache/velocity/runtime/defaults/velocity.properties
    19:57:09.992 [main] DEBUG org.apache.velocity - ResourceLoader instantiated: org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:09.994 [main] DEBUG org.apache.velocity - initialized (class org.apache.velocity.runtime.resource.ResourceCacheImpl) with class java.util.Collections$SynchronizedMap cache map.
    19:57:09.995 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Stop
    19:57:09.995 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Define
    19:57:09.996 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Break
    19:57:09.996 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Evaluate
    19:57:09.997 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Macro
    19:57:09.997 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Parse
    19:57:09.998 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Include
    19:57:09.999 [main] DEBUG org.apache.velocity - Loaded System Directive: org.apache.velocity.runtime.directive.Foreach
    19:57:10.017 [main] DEBUG org.apache.velocity.parser - Created '20' parsers.
    19:57:10.033 [main] DEBUG org.apache.velocity.macro - "velocimacro.library.path" is not set. Trying default library: velocimacros.vtl
    19:57:10.034 [main] DEBUG org.apache.velocity.loader.file - Could not load resource 'velocimacros.vtl' from ResourceLoader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - Default library velocimacros.vtl not found. Trying old default library: VM_global_library.vm
    19:57:10.034 [main] DEBUG org.apache.velocity.loader.file - Could not load resource 'VM_global_library.vm' from ResourceLoader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - Old default library VM_global_library.vm not found.
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - allowInline = true: VMs can be defined inline in templates
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - allowInlineToOverride = false: VMs defined inline may NOT replace previous VM definitions
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - allowInlineLocal = false: VMs defined inline will be global in scope if allowed.
    19:57:10.034 [main] DEBUG org.apache.velocity.macro - autoload off: VM system will not automatically reload global library macros
    19:57:10.049 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/MyMapper.xml.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.057 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/MyMapper.xml.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/resources/mapper/demo/UserMapper.xml
    19:57:10.071 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/Vo.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.075 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/Vo.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java/com/sword/server/demo/interfaces/model/UserVo.java
    19:57:10.079 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/Convert.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.080 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/Convert.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java/com/sword/server/demo/convert/UserConvert.java
    19:57:10.087 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/Po.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.090 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/Po.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\repository\entity\UserPo.java
    19:57:10.091 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/MyMapper.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.092 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/MyMapper.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\repository\mapper\UserMapper.java
    19:57:10.093 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/MyService.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.094 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/MyService.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\service\UserService.java
    19:57:10.095 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/MyServiceImpl.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.096 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/MyServiceImpl.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\service\impl\UserServiceImpl.java
    19:57:10.101 [main] DEBUG org.apache.velocity.loader - ResourceManager: found /templates/MyController.java.vm with loader org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
    19:57:10.102 [main] DEBUG com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine - 模板:/templates/MyController.java.vm;  文件:E:\workspace\Git\ProjectOfSpringBoot\server/src/main/java\com\sword\server\demo\interfaces\api\UserApi.java
    19:57:10.102 [main] DEBUG com.baomidou.mybatisplus.generator.AutoGenerator - ==========================文件生成完成！！！==========================
    ```

    ![生成的代码](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/4.%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%905.png?raw=true)


## MybatisPlus配置

* 创建MybatisPlus配置类`com.sword.server.basic.config.MybatisPlusConfig`，配置`MapperScan`注解用以扫描持久化接口`#Mapper.java`

    ```java
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
    ```

* 参数配置，在`application.yml`中的公共配置部分添加MybatisPlus配置

    ```yaml
    # mybatis-plus配置
    mybatis-plus:
      mapper-locations: classpath*:mapper/*Mapper.xml # xml映射文件路径
      # 全局配置
      global-config:
        # 数据库配置
        db-config:
          id-type: auto # 全局默认主键类型：数据库ID自增
          insert-strategy: not_empty # 字符串非空判断，其他类型非NULL判断，即有值才进行insert
          update-strategy: not_empty # 字符串非空判断，其他类型非NULL判断，即有值才进行update
          # 逻辑删除字段
          # 插入: 不作限制
          # 查找: 追加where条件过滤掉已删除数据,且使用 wrapper.entity 生成的where条件会忽略该字段
          # 更新: 追加where条件防止更新到已删除数据,且使用 wrapper.entity 生成的where条件会忽略该字段
          # 删除: 转变为 更新
          logic-delete-field: deleted
          logic-delete-value: 1
          logic-not-delete-value: 0
    ```

## Swagger2

* 创建Swagger2配置类`com.sword.server.basic.config.SwaggerConfig`，暴露对外接口生成Api文档

    ```java
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
    ```

* 重启应用在浏览器中输入[http://127.0.0.1:8080/demo/swagger-ui.html](http://127.0.0.1:8080/demo/swagger-ui.html)，进入Api文档页面，可以在该页面直接请求后端接口

    ![Api文档页面](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/6.swagger1.png?raw=true)

## 日志配置

* 参数配置，在`application.yml`中的开发环境配置部分添加一些日志配置

    ```yaml
    logging:
      file:
        path: ./log # 日志文件路径
      level: # 日志等级
        com.sword: debug
    ```

* 配置完日志参数后重启应用，此时再去调用查询接口则控制台会输出具体的执行SQL的日志且会生成一个日志文件在指定录下下

    ```log
    2020-07-08 12:20:12.335 DEBUG 23176 --- [nio-8080-exec-1] c.s.s.d.r.mapper.UserMapper.selectById   : ==>  Preparing: SELECT id,name,phone,proc_inst_id,deleted FROM user WHERE id=? AND deleted='0'
    2020-07-08 12:20:12.357 DEBUG 23176 --- [nio-8080-exec-1] c.s.s.d.r.mapper.UserMapper.selectById   : ==> Parameters: 1(Integer)
    2020-07-08 12:20:12.375 DEBUG 23176 --- [nio-8080-exec-1] c.s.s.d.r.mapper.UserMapper.selectById   : <==      Total: 0
    ```

    ![日志](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/5.%E6%97%A5%E5%BF%97%E9%85%8D%E7%BD%AE1.png?raw=true)

## 对外接口响应结果统一包装

* 对对外接口的响应结果统一进行包装，统一返回3个字段：code、msg、data。

  1. code - 响应码，00000：成功，其他：失败
  2. msg - 响应内容，成功或失败的提示内容
  3. data - 响应数据

* 创建公共响应类`com.sword.server.basic.interfaces.response.Result`

    ```java
    import lombok.Builder;
    import lombok.Data;

    /**
     * 公共响应
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    @Data
    @Builder
    public class Result<T> {

        /**
         * 响应码
         */
        private String code;

        /**
         * 响应内容
         */
        private String msg;

        /**
         * 响应数据
         */
        private T data;
    }
    ```

* 创建对外接口响应结果统一包装类`com.sword.server.basic.interfaces.advice.ApiResponseAdvice`

    ```java
    import com.sword.server.basic.interfaces.response.Result;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.core.MethodParameter;
    import org.springframework.http.MediaType;
    import org.springframework.http.server.ServerHttpRequest;
    import org.springframework.http.server.ServerHttpResponse;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

    /**
     * 对外接口响应结果统一包装
     * ControllerAdvice如果不指定具体的包可能会导致Swagger-ui.html页面无法打开，报“Unable to infer base url....”错误
     */
    @ControllerAdvice("com.sword.server.demo.interfaces.api")
    @Slf4j
    public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {
        /**
         * 响应成功结果是否统一处理
         * @param returnType
         * @param converterType
         * @return
         */
        @Override
        public boolean supports(MethodParameter returnType, Class converterType) {
            return true;
        }

        /**
         * 响应成功结果统一处理
         * @param body
         * @param returnType
         * @param selectedContentType
         * @param selectedConverterType
         * @param request
         * @param response
         * @return
         */
        @Override
        public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
            return body instanceof Result ? body : Result.builder().code("000000").msg("调用成功").data(body).build();
        }

        /**
         * 如果发生Exception异常则统一返回响应失败结果
         * @param e 异常
         * @return 响应失败结果
         */
        @ExceptionHandler({Exception.class})
        @ResponseBody
        public Result apiExceptionHandle(Exception e) {
            Result result = Result.builder().code("999999").msg(e.getMessage()).build();
            log.info("----------------http响应异常----------------");
            log.info("response = {}", result.toString()); // 响应数据
            log.info("--------------------------------------------");
            return result;
        }
    }
    ```

* 重启应用再次请求接口查看返回结果如下：

    ```json
    {
      "code": "000000",
      "msg": "调用成功",
      "data": {
        "id": 2,
        "name": "3",
        "phone": "3",
        "procInstId": "3"
      }
    }
    ```

## 分页查询

* 在`com.sword.server.basic.config.MybatisPlusConfig`中注册MybatisPlus提供的分页拦截器，如下：

    ```java
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
    ```

* 创建一个分页请求类`com.sword.server.basic.interfaces.request.PageRequest`，用以接收分页参数，如下：

    ```java
    import com.baomidou.mybatisplus.core.metadata.IPage;
    import com.baomidou.mybatisplus.core.metadata.OrderItem;
    import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import org.apache.commons.lang3.StringUtils;

    import java.util.Objects;
    import java.util.stream.Stream;

    /**
     * 分页请求
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    @Data
    @ApiModel(value="PageRequest", description="分页请求")
    public class PageRequest {
        /**
         * 当前页
         */
        @ApiModelProperty(value = "当前页", example = "1", position = 990)
        private Integer curPage;

        /**
         * 每页显示条数
         */
        @ApiModelProperty(value = "每页显示条数", example = "10", position = 991)
        private Integer pageSize;

        /**
         * 排序："id desc,name asc"
         */
        @ApiModelProperty(value = "排序：\"id desc,name asc\"", position = 992)
        private String orderBy;

        /**
         * 获取分页对象
         * @return com.baomidou.mybatisplus.core.metadata.IPage<T> 分页对象
         * @author sword
         * @date 2020-07-07 11:13:57
         */
        public <T> IPage<T> buildPage() {
            // 根据当前页和每页显示条数初始化分页对象
            Page<T> listPage = new Page<>(curPage, pageSize);

            // 如果排序不为空则添加排序内容
            if (StringUtils.isNotEmpty(orderBy)) {
                Stream.of(orderBy.split(",")) // 使用“,”将排序分隔为多个列排序
                        .filter(StringUtils::isNotEmpty) // 筛选出非空的列排序
                        .map(orderByStr -> {
                            // 使用“ ”将列排序分隔为排序列名和排序类型
                            String[] order = orderByStr.split(" ");

                            // 如果只有一个元素且不为空说明只有排序列名没有排序类型则默认排序类型为升序
                            if (order.length == 1 && StringUtils.isNotEmpty(order[0])) {
                                return OrderItem.asc(order[0]); // 生成指定列名的升序
                            }
                            // 如果只有两个元素且第一个元素不为空说明有排序列名和排序类型，继续判断
                            else if (order.length == 2 && StringUtils.isNotEmpty(order[0])) {
                                // 如果排序类型为降序则生成指定列名的降序，否则就是生成升序
                                if ("desc".equals(order[1])) {
                                    return OrderItem.desc(order[0]);
                                }
                                else {
                                    return OrderItem.asc(order[0]);
                                }
                            }
                            else {
                                return null;
                            }
                        })
                        .filter(Objects::nonNull) // 筛选出非空有效的排序对象
                        .forEach(listPage::addOrder);
            }

            return listPage;
        }
    }
    ```

* 在`com.sword.server.demo.interfaces.api.UserApi`中去掉查询多个用户的接口，添加分页查询用户的接口，如下：

    ```java
    /**
     * 分页查询用户
     * @param userVo 查询条件
     * @param page 分页请求
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.sword.server.demo.interfaces.model.UserVo> 用户分页查询结果
     * @author sword
     * @date 2020/7/9 18:54
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("分页查询用户")
    public IPage<UserVo> listUser(UserVo userVo, PageRequest page) {

        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>(userConvert.convertFrom(userVo));

        return userService.page(page.buildPage(), queryWrapper).convert(userConvert::convertTo);
    }
    ```

## 事务

* 给方法添加`Transactional`注解即为该方法开启事务，如下：

    ```java
    @Transactional
    public UserVo insertUser(@RequestBody UserVo userVo) {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userService.save(userPo); // 添加用户表
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }
    ```

* 默认对Error异常和RuntimeException异常以及其子类进行事务回滚，且必须抛出异常，如果在方法中使用try-catch捕获了异常则无法进行事务回滚

* 自定义需要回滚的异常，如下：

    ```java
    @Transactional(rollbackFor = Exception.class)
    public UserVo insertUser(@RequestBody UserVo userVo) throws Exception {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userService.save(userPo); // 添加用户

        if (userPo != null) {
            throw new Exception("添加用户异常");
        }
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }
    ```

* 在本类别的方法调用带事务的方法，则事务不生效，因为`Transactional`注解是通过代理的方式开启事务的，如果在本类别的方法调用带事务的方法是不会去调用代理后的方法而是直接调用原有的方法，所以此时事务不生效。

## 异步

* 创建异步配置类`com.sword.server.basic.config.AsyncConfig`，开启异步功能，如下：

    ```java
    import org.springframework.context.annotation.Configuration;
    import org.springframework.scheduling.annotation.EnableAsync;

    /**
    * 异步配置类
    * @author sword
    * @date 2020-07-07 11:13:57
    */
    @Configuration
    @EnableAsync
    public class AsyncConfig {
    }
    ```

* 给方法添加`Async`注解即调用该方法时为异步调用，如给`com.sword.server.demo.service.UserService`接口添加一个默认实现方法并添加`Async`注解：

    ```java
    @Async
    public default void sleep() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("睡了3秒");
    }
    ```

* 在`com.sword.server.demo.interfaces.api.UserApi#getUser`方法中进行调用，如下：

    ```java
    public UserVo getUser(@PathVariable("id") Integer id) throws Exception {
        userService.sleep();
        UserPo userPo = userService.getById(id); // 查询单个用户表


        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }
    ```

* 注意事项

    1. 异步方法的返回值为void或者Future
    2. 异步方法和调用方法不得在同一个类

## 打包运行

* 在IDEA的maven窗口运行`package`进行打包

    ![打包](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/7.%E6%89%93%E5%8C%85%E8%BF%90%E8%A1%8C1.png?raw=true)

* 打包成功可以在项目根目录下的`target`文件夹下找到打出来的jar包

    ![找到打出来的jar包](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/7.%E6%89%93%E5%8C%85%E8%BF%90%E8%A1%8C2.png?raw=true)

* 在命令行窗口执行`java -jar -Dspring.profiles.active=dev ${jar包绝对路径}`即可运行应用

    ![运行应用](https://github.com/LonelyNULL/ProjectOfSpringBoot/blob/master/image/7.%E6%89%93%E5%8C%85%E8%BF%90%E8%A1%8C3.png?raw=true)

## 问题

* 启用应用失败，控制台输出如下内容：

    ```log
    2020-06-22 18:42:34.230  INFO 20280 --- [   restartedMain]   ConditionEvaluationReportLoggingListener :
    Error starting ApplicationContext. To display the   conditions report re-run your application with    'debug' enabled.
    2020-06-22 18:42:34.257 ERROR 20280 --- [   restartedMain] o.s.b.d.  LoggingFailureAnalysisReporter   :

    ***************************
    APPLICATION FAILED TO START
    ***************************

    Description:

    Web server failed to start. Port 8080 was already   in use.

    Action:

    Identify and stop the process that's listening on   port 8080 or configure this application to listen     on another port.

    Disconnected from the target VM, address: '127.0.0. 1:0', transport: 'socket'

    Process finished with exit code 0

    ```

    原因：SpringBoot项目内置的Web应用服务器（Tomcat）的端口默认就是8080，日志显示8080端口已经被占用了，所以启动失败。

    解决1：

    1. 使用cmd命令 ```netstat -ano | findstr 8080``` 查看占用8080端口服务的pid

        ```shell
        C:\Users\wukongjian>netstat -ano | findstr   8080
        TCP    0.0.0.0:8080           0.0.0.  0:0              LISTENING       23720
        TCP    [::]:8080              [::]  :0                 LISTENING       23720
        ```

    2. 使用cmd命令 ```tasklist | findstr 23720``` 查看pid为23720是什么进程

        ```shell
        C:\Users\wukongjian>tasklist | findstr 23720
        java.exe                     23720 Console                    9    424,012 K
        ```

    3. 使用cmd命令 ```taskkill /pid 23720 -t -f``` 杀死pid为23720的进程，-f 为强制执行的意思

        ```shell
        C:\Users\wukongjian>taskkill /pid 23720 -t -f
        成功: 已终止 PID 15744 (属于 PID 23720 子进程)的进程。
        成功: 已终止 PID 23720 (属于 PID 19164 子进程)的进程。
        ```

    4. 杀死进程后再启动应用则成功

        ```log
        2020-06-23 09:47:58.998  INFO 1160 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
        2020-06-23 09:47:58.999  INFO 1160 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
        2020-06-23 09:47:59.105  INFO 1160 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
        2020-06-23 09:47:59.105  INFO 1160 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1174 ms
        2020-06-23 09:47:59.286  INFO 1160 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
        2020-06-23 09:47:59.416  INFO 1160 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
        2020-06-23 09:47:59.449  INFO 1160 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
        2020-06-23 09:47:59.459  INFO 1160 --- [  restartedMain] com.sword.demo.DemoApplication           : Started DemoApplication in 2.017 seconds (JVM running for 3.754)
        ```

    解决2：修改默认端口，详见[YAML配置](##YAML配置)

* 打开Swageer-ui.html控制台报`java.lang.NumberFormatException: For input string: ""`错误

    原因：swagger的bug
    解决：在配置中的logging.level下添加配置，如下：

    ```yaml
    logging:
      level:
        io.swagger.models.parameters.AbstractSerializableParameter: error
    ```