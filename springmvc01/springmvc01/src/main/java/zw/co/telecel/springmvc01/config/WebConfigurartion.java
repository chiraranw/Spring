/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.telecel.springmvc01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import zw.co.telecel.springmvc01.RootClass;

/**
 *
 * @author chiraran
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses ={RootClass.class}  )
public class WebConfigurartion implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry rhr) {
        //for static content
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }

}
