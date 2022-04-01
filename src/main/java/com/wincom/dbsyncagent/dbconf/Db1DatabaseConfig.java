package com.wincom.dbsyncagent.dbconf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
 
@Configuration
@MapperScan(value="com.wincom.dbsyncagent.tasks.dao1", sqlSessionFactoryRef="db1SqlSessionFactory")
@EnableTransactionManagement
public class Db1DatabaseConfig {
	
	@Bean(name = "db1Hikari")
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }
 
    @Bean(name = "db1DataSource")
    //@Primary
    //@ConfigurationProperties(prefix = "spring.db1.datasource")
    public DataSource db1DataSource() {
        //return DataSourceBuilder.create().build();
    	return new HikariDataSource(hikariConfig());
    }
 
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource db1DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(db1DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sqlmap/dao1/Db1_SQL.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:sqlmap/dao1/sql-mapper-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory) throws Exception {
 
        return new SqlSessionTemplate(db1SqlSessionFactory);
    }
}
