/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.telecel.springthymeleaf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zw.co.telecel.springthymeleaf.ComponentScanConfigClass;

/**
 *
 * @author chiraran
 */
@Configuration
@ComponentScan(basePackageClasses = {ComponentScanConfigClass.class})
public class AppRootConfig {

}
