package com.pyy.helloWorld.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 将数据源注入到对应的Mapper
 */
@Configuration
//4、最后将上面创建的SqlSessionTemplate注入到对应的 Mapper 包路径下，这样这个包下面的 Mapper 都会使用第一个数据源来进行数据库操作
@MapperScan(basePackages = "com.pyy.helloWorld.dao.one",sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class OneSourceConfig {
    /**
     * 1、创建一个sqlSessionFactory，将第一个数据源注入到其中
     */
    @Bean(name = "oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceOne") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 2、将数据源添加到事务中
     */
    @Bean(name = "oneTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSourceOne") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 3、将上面创建的SqlSessionFactory注入，创建在 Mapper 中需要使用的SqlSessionTemplate
     */
    @Bean(name = "oneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
