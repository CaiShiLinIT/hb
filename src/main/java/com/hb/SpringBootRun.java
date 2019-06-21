package com.hb;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.hb.mapper") //创建包扫描,用于扫描Mapper(Dao)层的接口
public class SpringBootRun {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRun.class, args);
	}
	@Bean
	public MultipartConfigElement multipartConfigElement(@Value("${multipart.maxFileSize}")String maxFileSize, @Value("${multipart.maxRequestSize}") String maxRequestSize) {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    factory.setMaxFileSize(maxFileSize);
	    factory.setMaxRequestSize(maxRequestSize);
	    return factory.createMultipartConfig();
	}
}
