//package com.pyy.helloWorld.configuration;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MybatisConfiguration {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.pyy.helloWorld.domian");
//
//
//        //表和实体类的映射，驼峰设置
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        sqlSessionFactoryBean.setConfiguration(configuration);
//
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:muybatis/mapper/*.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }
//}
