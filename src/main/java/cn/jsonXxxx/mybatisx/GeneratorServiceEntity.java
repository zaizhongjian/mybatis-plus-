package cn.jsonXxxx.mybatisx;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "cn.jsonXxxx.mybatisx";
        boolean serviceNameStartWithI = true;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName);
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://10.10.90.165:3306/renhtml";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)//下划线转成驼峰式命名
                .setInclude(new String[]{"sys_user"});//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("jsonXxxx")
                .setOutputDir("E:\\Workspaces\\myEclipse\\mybatisxTest\\src\\main\\java")//修改成自己的目录
                .setFileOverride(true)
                .setEnableCache(false);//xml关闭二级缓存
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity.Do")

                ).execute();
    }
}
