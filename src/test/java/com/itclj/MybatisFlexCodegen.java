package com.itclj;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MybatisFlexCodegen {
    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/itclj?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.setBasePackage("com.itclj");

        //设置表前缀和只生成哪些表
        globalConfig.setTablePrefix("");
        globalConfig.setGenerateTable("user", "tags");


        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);
        //设置项目的JDK版本，项目的JDK为14及以上时建议设置该项，小于14则可以不设置
        globalConfig.setEntityJdkVersion(17);

        //设置生成 mapper
        globalConfig.setMapperGenerateEnable(true);

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
//        globalConfig.setColumnConfig("tb_account", columnConfig);
        globalConfig.setColumnConfig(columnConfig);

        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.itclj");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("")
                .setGenerateTable("user", "tags");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(17);

        //设置生成 mapper
        globalConfig.enableMapper();

        //设置表定义辅助类 TableDef
        globalConfig.enableTableDef();

        //设置生成 service
        globalConfig.enableService();

        //设置生成 serviceimple
        globalConfig.enableServiceImpl();

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
//        globalConfig.getStrategyConfig()
//                .setColumnConfig("tb_account", columnConfig);
        globalConfig.setColumnConfig(columnConfig);

        return globalConfig;
    }
}
