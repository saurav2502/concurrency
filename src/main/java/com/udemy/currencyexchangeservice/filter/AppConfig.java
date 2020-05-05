package com.udemy.currencyexchangeservice.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public FilterRegistrationBean<CustomFilter> filterRegistrationBean()  {

        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean();
        CustomFilter customFilter = new CustomFilter();
        registrationBean.setFilter(customFilter);
        registrationBean.addUrlPatterns("/currency-exchange/*");
        LOGGER.info("taking the url: {}" + registrationBean.getUrlPatterns().toString());
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
