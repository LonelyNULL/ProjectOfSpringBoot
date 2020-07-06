package com.sword.demo;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * MybatisPlus代码生成器
 * @author sword
 * @date 2020/7/1 11:22
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir"); // 当前项目的根路径
        String sourcePath = projectPath + "/src/main/java"; // 源码路径
        String resourcePath = projectPath + "/src/main/resources"; // 资源路径
        String sourceParentPackage = "com.sword.demo"; // 源码父包
        String voModulePackage = "model"; // 视图对象模块的包名
        String voModuleObjectSuffix = "Vo"; // 视图对象模块的类名的后缀
        String commonModulePackage = "common"; // 视图对象模块的包名
        String configModulePackage = "config"; // 配置对象模块的包名
        String baseConvertName = "BaseConvert"; // 基础转换类的名称
        String convertModulePackage = "convert"; // 转换模块的包名
        String convertModuleObjectSuffix = "Convert"; // 转换模块的类名的后缀
        String xmlModulePackage = "mapper"; // mybatis的xml文件的包名
        String xmlModuleFileSuffix = "Mapper"; // mybatis的xml文件的名称的的后缀

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(sourcePath); // 生成文件的输出目录
        gc.setAuthor("sword"); // 开发人员
        gc.setOpen(false); // 是否打开输出目录
        gc.setEntityName("%sPo"); // 设置持久化对象类以Po结尾
        gc.setServiceName("%sService"); // 设置业务服务接口以Service结尾
        gc.setServiceImplName("%sServiceImpl"); // 设置业务接口实现类以ServiceImpl结尾
        gc.setSwagger2(true); // 启用Swagger2 注解
        mpg.setGlobalConfig(gc); // 设置全局配置

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8"); // 设置驱动连接的URL
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver"); // 设置驱动名称
        dsc.setUsername("root"); // 设置数据库连接用户名
        dsc.setPassword("root"); // 设置数据库数据库连接密码
        mpg.setDataSource(dsc); // 设置数据源配置

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 模块就是在父包名下再加一级模块目录，然后再创建controller、entity、mapper、service等目录
//        pc.setModuleName(scanner("模块名")); // 设置模块名
        pc.setParent(sourceParentPackage); // 设置父包名
        mpg.setPackageInfo(pc); // 设置包配置

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // 自定义的参数，在模板文件中使用时为${cfg.key}，如${cfg.datetime}就是替换为当前日期时间
                Map<String, Object> map = new HashMap<>();
                map.put("datetime", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())); // 当前日期时间
                this.setMap(map); // 设置自定义参数
            }

            @Override
            public Map<String, Object> prepareObjectMap(Map<String, Object> objectMap) {
                TableInfo tableInfo = (TableInfo) objectMap.get("table"); // 当前表相关信息

                String entityName = getEntityName(tableInfo); // 实体类名称

                // 如果需要controller类上的mapping的路径由驼峰转连字符，则将实体类名称由驼峰转连字符
                if ((Boolean) objectMap.getOrDefault("controllerMappingHyphenStyle", false)) {

                    objectMap.put("controllerMappingHyphen", StringUtils.camelToHyphen(entityName));
                }

                // 循环当前的表的所有字段筛选出主键字段
                tableInfo.getFields().stream().filter(TableField::isKeyFlag).findFirst().ifPresent(tableField -> {
                    objectMap.put("keyType", tableField.getPropertyType()); // 主键类型
                    objectMap.put("keyName", tableField.getPropertyName()); // 主键名称,首字母小写
                    objectMap.put("keyCapitalName", tableField.getCapitalName()); // 主键名称,首字母大写
                });


                // 实体类名称
                objectMap.put("entityName", entityName);

                // 持久化对象类实例名
                objectMap.put("poInstName", StringUtils.firstToLowerCase(tableInfo.getEntityName()));

                // 实现类实例名
                objectMap.put("serviceInstName", StringUtils.firstToLowerCase(tableInfo.getServiceName()));

                // 视图对象类所在的包
                objectMap.put("voPackage", pc.getParent() + "." + voModulePackage);
                // 视图对象类名称
                objectMap.put("voName", entityName + voModuleObjectSuffix);
                // 视图对象类实例名称
                objectMap.put("voInstName", StringUtils.firstToLowerCase(entityName) + voModuleObjectSuffix);

                // 基础转换类所在的包
                objectMap.put("baseConvertPackage", sourceParentPackage + "." + commonModulePackage);
                // 基础转换类名称
                objectMap.put("baseConvertName", baseConvertName);

                // 转换类所在的包
                objectMap.put("convertPackage", pc.getParent() + "." + convertModulePackage);
                // 转换类名称
                objectMap.put("convertName", entityName + convertModuleObjectSuffix);
                // 转换类实例名称
                objectMap.put("convertInstName", StringUtils.firstToLowerCase(entityName) + convertModuleObjectSuffix);

                // 配置类所在的包
                objectMap.put("configPackage", sourceParentPackage + "." + configModulePackage);

                // 源码父包
                objectMap.put("sourceParentPackage", sourceParentPackage);

                return objectMap;
            }
        };

        /*
         * 自定义输出文件配置和自定义模板配置如果针对同一类型的模板做了配置则可能会产生冲突，
         * 所以最好只设置一个，如下针对"/templates/MyMapper.xml.vm"做了自定义输出文件配置
         * 那自定义模板配置则设置为null
         */

        // 自定义输出文件配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 修改#Mapper.xml的输出文件配置
        focList.add(new FileOutConfig("/templates/MyMapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return resourcePath + "/" + xmlModulePackage + "/" + pc.getModuleName() + "/" + getEntityName(tableInfo)
                        + xmlModuleFileSuffix + StringPool.DOT_XML;
            }
        });
        // 添加#Vo.java的输出文件配置
        focList.add(new FileOutConfig("/templates/MyVo.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sourcePath + "/" + pc.getParent().replace(".", "/") + "/" + voModulePackage
                        + "/" + getEntityName(tableInfo) + voModuleObjectSuffix + StringPool.DOT_JAVA;
            }
        });
        // 添加BaseConvert.java的输出文件配置
        focList.add(new FileOutConfig("/templates/MyBaseConvert.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sourcePath + "/" + sourceParentPackage.replace(".", "/") + "/"
                        + commonModulePackage + "/" + baseConvertName + StringPool.DOT_JAVA;
            }
        });
        // 添加#Convert.java的输出文件配置
        focList.add(new FileOutConfig("/templates/MyConvert.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sourcePath + "/" + pc.getParent().replace(".", "/") + "/" + convertModulePackage
                        + "/" + getEntityName(tableInfo) + convertModuleObjectSuffix + StringPool.DOT_JAVA;
            }
        });
        // 添加MybatisPlusConfig.java的输出文件配置
        focList.add(new FileOutConfig("/templates/MybatisPlusConfig.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sourcePath + "/" + sourceParentPackage.replace(".", "/") + "/"
                        + configModulePackage + "/MybatisPlusConfig" + StringPool.DOT_JAVA;
            }
        });
        // 添加SwaggerConfig.java的输出文件配置
        focList.add(new FileOutConfig("/templates/SwaggerConfig.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return sourcePath + "/" + sourceParentPackage.replace(".", "/") + "/"
                        + configModulePackage + "/SwaggerConfig" + StringPool.DOT_JAVA;
            }
        });
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
////                checkDir(filePath);
////                if (fileType == FileType.MAPPER) {
////                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
////                    return !new File(filePath).exists();
////                }
////                // 允许生成模板文件
////                return true;
//                return false;
//            }
//        });
        cfg.setFileOutConfigList(focList); // 设置自定义输出配置
        mpg.setCfg(cfg); // 设置自定义配置

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController("templates/MyController.java");
        templateConfig.setService("templates/MyService.java");
        templateConfig.setServiceImpl("templates/MyServiceImpl.java");
        templateConfig.setMapper("templates/MyMapper.java");
        templateConfig.setXml(null); // 设置为null，不与自定义输出文件配置冲突
        templateConfig.setEntity("templates/MyPo.java");
        mpg.setTemplate(templateConfig); // 设置配置模板

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略，下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略，下划线转驼峰
        strategy.setEntityLombokModel(true); // 实体为lombok模型
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); // 需要生成对应代码的表
        strategy.setInclude("user");
        strategy.setControllerMappingHyphenStyle(true); // controller类上的mapping的路径由驼峰转连字符
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setLogicDeleteFieldName("deleted"); // 逻辑删除字段
        mpg.setStrategy(strategy); // 设置配置策略
        mpg.execute(); // 生成代码
    }

    /**
     * 获取当前表的实体类名，去掉结尾的Po
     * @param tableInfo 表信息
     * @author sword
     * @date 2020/7/6 9:35
     */
    public static String getEntityName(TableInfo tableInfo) {
        String entityName = tableInfo.getEntityName(); // 实体类名称
        // 实体类名称如果是Po结尾则去掉
        if (entityName.endsWith("Po")) {
            entityName = entityName.substring(0, entityName.length() - 2);
        }

        return entityName;
    }
}
