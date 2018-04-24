package com.svbsms.springjersey.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * For Spring configuration, like configuring the infrastructure of the application.
 * All the persistance related configurations come here
 *
 */
@Configuration
//@EnableTransactionManagement include this if we need to use Transaction management with @Transaction
@ComponentScan(basePackages = {"com.svbsms.springjersey.rest", "com.svbsms.springjersey.dao"})
public class ApplicationConfiguration {

}
