package com.sword.server;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;

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
        CustomProperty customProperty = new CustomProperty();
//        customProperty.setModuleName(scanner("模块名"));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(customProperty.getSourcePath()); // 生成文件的输出目录
        gc.setAuthor("sword"); // 开发人员
        gc.setOpen(false); // 是否打开输出目录
        gc.setEntityName("%sPo"); // 设置持久化对象类以Po结尾
        gc.setServiceName("%sService"); // 设置服务接口以Service结尾
        gc.setServiceImplName("%sServiceImpl"); // 设置服务接口实现类以ServiceImpl结尾
        gc.setControllerName("%sApi"); // 设置对外接口类以Api结尾
        gc.setSwagger2(true); // 启用Swagger2注解
        mpg.setGlobalConfig(gc); // 设置全局配置

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?characterEncoding=utf-8&serverTimezone=GMT%2B8"); // 设置驱动连接的URL
        dsc.setDriverName("com.mysql.jdbc.Driver"); // 设置驱动名称
        dsc.setUsername("root"); // 设置数据库连接用户名
        dsc.setPassword("root"); // 设置数据库数据库连接密码
        mpg.setDataSource(dsc); // 设置数据源配置

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 模块就是在父包名下再加一级模块目录，然后再创建controller、entity、mapper、service等目录
        pc.setModuleName(customProperty.getModuleName()); // 设置模块名
        pc.setParent(customProperty.getSourceParentPackage()); // 设置父包名
        pc.setController(customProperty.getInterfacesParentPackage() + ".api"); // 设置对外接口包名
        pc.setEntity(customProperty.getRepositoryParentPackage() + ".entity"); // 设置实体类包名
        pc.setMapper(customProperty.getRepositoryParentPackage() + ".mapper"); // 设置mapper包名
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
                objectMap.put("voPackage", customProperty.getVoModulePackage());
                // 视图对象类名称
                objectMap.put("voName", entityName + customProperty.getVoModuleObjectSuffix());
                // 视图对象类实例名称
                objectMap.put("voInstName", StringUtils.firstToLowerCase(entityName) + customProperty.getVoModuleObjectSuffix());

                // 基础转换类所在的包
                objectMap.put("baseConvertPackage", customProperty.getCommonModulePackage());

                // 转换类所在的包
                objectMap.put("convertPackage", customProperty.getConvertModulePackage());
                // 转换类名称
                objectMap.put("convertName", entityName + customProperty.getConvertModuleObjectSuffix());
                // 转换类实例名称
                objectMap.put("convertInstName", StringUtils.firstToLowerCase(entityName) + customProperty.getConvertModuleObjectSuffix());

                // 源码父包
                objectMap.put("sourceParentPackage", customProperty.getSourceParentPackage());

                // 对外接口统一返回结果类的包名
                objectMap.put("resultPackage", customProperty.getResultPackage());

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
                return customProperty.getXmlModulePath() + "/" + getEntityName(tableInfo)
                        + customProperty.getXmlModuleFileSuffix() + StringPool.DOT_XML;
            }
        });
        // 添加#Vo.java的输出文件配置
        focList.add(new FileOutConfig("/templates/Vo.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return customProperty.getVoModulePath()
                        + "/" + getEntityName(tableInfo) + customProperty.getVoModuleObjectSuffix() + StringPool.DOT_JAVA;
            }
        });
        // 添加#Convert.java的输出文件配置
        focList.add(new FileOutConfig("/templates/Convert.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return customProperty.getConvertModulePath()
                        + "/" + getEntityName(tableInfo) + customProperty.getConvertModuleObjectSuffix() + StringPool.DOT_JAVA;
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
        templateConfig.setController("/templates/MyController.java");
        templateConfig.setService("/templates/MyService.java");
        templateConfig.setServiceImpl("/templates/MyServiceImpl.java");
        templateConfig.setMapper("/templates/MyMapper.java");
        templateConfig.setXml(null); // 设置为null，不与自定义输出文件配置冲突
        templateConfig.setEntity("/templates/Po.java");
        mpg.setTemplate(templateConfig); // 设置配置模板

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略，下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略，下划线转驼峰
        strategy.setEntityLombokModel(true); // 实体为lombok模型
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); // 需要生成对应代码的表
        strategy.setControllerMappingHyphenStyle(true); // controller类上的mapping的路径由驼峰转连字符
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

/**
 * 自定义参数
 */
@Data
class CustomProperty {
    /**
     * 当前项目的根路径
     */
    String projectPath = System.getProperty("user.dir");

    /**
     * 源码路径
     */
    String sourcePath = "/src/main/java";
    /**
     * 资源路径
     */
    String resourcePath = "/src/main/resources";
    /**
     * 源码父包
     */
    String sourceParentPackage = CodeGenerator.class.getPackage().getName();

    /**
     * 模块名
     */
    String moduleName = "demo";

    /**
     * 表示层父包
     */
    String interfacesParentPackage = "interfaces";
    /**
     * 持久层父包
     */
    String repositoryParentPackage = "repository";
    /**
     * 视图对象模块的包名
     */
    String voModulePackage = "model";
    /**
     * 视图对象模块的包名
     */
    String commonModulePackage = "common";
    /**
     * 配置对象模块的包名
     */
    String configModulePackage = "config";
    /**
     * 转换模块的包名
     */
    String convertModulePackage = "convert";
    /**
     * mybatis的xml文件的包名
     */
    String xmlModulePackage = "mapper";
    /**
     * 转换模块的类名的后缀
     */
    String convertModuleObjectSuffix = "Convert";
    /**
     * mybatis的xml文件的名称的的后缀
     */
    String xmlModuleFileSuffix = "Mapper";
    /**
     * 对外接口统一返回结果类的包名
     */
    String resultPackage = "response";
    /**
     * 视图对象模块的类名的后缀
     */
    String voModuleObjectSuffix = "Vo";
    /**
     * advice包名
     */
    String advicePackage = "advice";

    public String getSourcePath() {
        return getProjectPath() + this.sourcePath;
    }

    public String getResourcePath() {
        return getProjectPath() + this.resourcePath;
    }

    public String getModulePackage() {
        if (StringUtils.isBlank(moduleName)) {
            return getSourceParentPackage();
        }
        else {
            return getSourceParentPackage() + "." + moduleName;
        }
    }

    public String getInterfacesPackage() {
        if (StringUtils.isBlank(interfacesParentPackage)) {
            return getModulePackage();
        }
        else {
            return getModulePackage() + "." + interfacesParentPackage;
        }
    }

    public String getRepositoryPackage() {
        if (StringUtils.isBlank(repositoryParentPackage)) {
            return getModulePackage();
        }
        else {
            return getModulePackage() + "." + repositoryParentPackage;
        }
    }

    public String getVoModulePackage() {
        if (StringUtils.isBlank(voModulePackage)) {
            return getInterfacesPackage();
        }
        else {
            return getInterfacesPackage() + "." + voModulePackage;
        }
    }

    public String getVoModulePath() {
        return getSourcePath() + "/" + getVoModulePackage().replace(".", "/");
    }

    public String getCommonModulePackage() {
        if (StringUtils.isBlank(commonModulePackage)) {
            return getSourceParentPackage();
        }
        else {
            return getSourceParentPackage() + "." + commonModulePackage;
        }
    }

    public String getCommonModulePath() {
        return getSourcePath() + "/" + getCommonModulePackage().replace(".", "/");
    }

    public String getConfigModulePackage() {
        if (StringUtils.isBlank(configModulePackage)) {
            return getSourceParentPackage();
        }
        else {
            return getSourceParentPackage() + "." + configModulePackage;
        }
    }

    public String getConfigModulePath() {
        return getSourcePath() + "/" + getConfigModulePackage().replace(".", "/");
    }

    public String getConvertModulePackage() {
        if (StringUtils.isBlank(convertModulePackage)) {
            return getModulePackage();
        }
        else {
            return getModulePackage() + "." + convertModulePackage;
        }
    }

    public String getConvertModulePath() {
        return getSourcePath() + "/" + getConvertModulePackage().replace(".", "/");
    }

    public String getXmlModulePath() {
        return getResourcePath() + "/" + xmlModulePackage + "/" + moduleName;
    }

    public String getResultPackage() {
        if (StringUtils.isBlank(resultPackage)) {
            return getInterfacesPackage();
        }
        else {
            return getInterfacesPackage() + "." + resultPackage;
        }
    }

    public String getResultPath() {
        return getSourcePath() + "/" + getResultPackage().replace(".", "/");
    }

    public String getAdvicePackage() {
        if (StringUtils.isBlank(advicePackage)) {
            return getInterfacesPackage();
        }
        else {
            return getInterfacesPackage() + "." + advicePackage;
        }
    }

    public String getAdvicePath() {
        return getSourcePath() + "/" + getAdvicePackage().replace(".", "/");
    }
}
