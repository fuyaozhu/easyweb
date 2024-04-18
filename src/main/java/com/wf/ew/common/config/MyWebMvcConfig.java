package com.wf.ew.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 解决springboot2.0静态资源无法直接访问问题
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        String os = System.getProperty("os.name");
        System.out.println(os);
       /* if(os.toLowerCase().startsWith("win")){
            //--------------------------------------windows下保存路径-------------------------------------------------------------
            //项目图片访问路径
            registry.addResourceHandler("/pictureUpload/project/**").addResourceLocations("file:D:/pictureUpload/project/");
        }else{
            //--------------------------------------linux下保存路径---------------------------------------------------------------------------------
            //项目图片访问路径
            registry.addResourceHandler("/pictureUpload/project/**").addResourceLocations("file:/root/pictureUpload/project/");
       }*/
        //--------------------------------------windows下保存路径-------------------------------------------------------------
        //项目图片访问路径
        registry.addResourceHandler("/img/**").addResourceLocations("file:C:\\image\\");
        super.addResourceHandlers(registry);
    }
}
