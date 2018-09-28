package com.fifthmonth.himalya.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.fifthmonth.himalya.properties.DruidPrimaryDataSourceConfigProperties;

@Configuration
public class DruidPrimaryDataSourceConfig {

    @Autowired
    private DruidPrimaryDataSourceConfigProperties druidPrimaryDataSourceConfigProperties;

    @Bean(name="primaryDataSource")
    public DataSource primaryDataSource (){
        DruidDataSource datasource = new DruidDataSource();
        /* 基础配置 */
        datasource.setUrl(this.druidPrimaryDataSourceConfigProperties.getUrl());
        datasource.setUsername(this.druidPrimaryDataSourceConfigProperties.getUsername());
        datasource.setPassword(this.druidPrimaryDataSourceConfigProperties.getPassword());
        datasource.setDriverClassName(this.druidPrimaryDataSourceConfigProperties.getDriverClassName());

        /* 其他配置 */
        datasource.setInitialSize(this.druidPrimaryDataSourceConfigProperties.getInitialSize());
        datasource.setMinIdle(this.druidPrimaryDataSourceConfigProperties.getMinIdle());
        datasource.setMaxActive(this.druidPrimaryDataSourceConfigProperties.getMaxActive());
        datasource.setMaxWait(this.druidPrimaryDataSourceConfigProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(this.druidPrimaryDataSourceConfigProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(this.druidPrimaryDataSourceConfigProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(this.druidPrimaryDataSourceConfigProperties.getValidationQuery());
        datasource.setTestWhileIdle(this.druidPrimaryDataSourceConfigProperties.getTestWhileIdle());
        datasource.setTestOnBorrow(this.druidPrimaryDataSourceConfigProperties.getTestOnBorrow());
        datasource.setTestOnReturn(this.druidPrimaryDataSourceConfigProperties.getTestOnReturn());

        return datasource;
    }

}