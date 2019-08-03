/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.telecel.springmvc01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zw.co.telecel.springmvc01.RootClass;

/**
 *
 * @author chiraran
 */
@Configuration
@ComponentScan(basePackageClasses ={RootClass.class} )
public class RootConfiguration {
        //services, dao, data source - global beans
    
}
