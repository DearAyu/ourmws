package com.mws.ourmws.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.mws.ourmws.DAO")
@Configuration
public class MybatisConfig {

}
