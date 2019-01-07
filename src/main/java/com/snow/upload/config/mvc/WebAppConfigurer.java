package com.snow.upload.config.mvc;


import com.snow.upload.common.bean.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import java.nio.file.Paths;



@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Autowired
    private Config config;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/"+config.getFileUrl()+"/**").addResourceLocations("file:"+ Paths.get(config.getFilePath())+"/");

    }




}

