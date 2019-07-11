package com.pyy.helloWorld.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 加载多个不同的数据源
 */
@Configuration
public class MultiDataSourceConfig {

    @Primary
    @Bean(name = "dataSourceOne")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

}
