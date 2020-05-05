package com.udemy.currencyexchangeservice.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter("/greeting")
public class CustomFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);
    private ServletRequest servletRequest;
    private ServletResponse servletResponse;
    private FilterChain filterChain;

    public CustomFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Custom filter ##########");
        Enumeration<?> e = filterConfig.getInitParameterNames();
        while (e.hasMoreElements()){
            String s = (String) e.nextElement();
            LOGGER.info(s);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        LOGGER.info("Logging Request  {} : {}", request.getMethod(), request.getRequestURI());
        filterChain.doFilter(request, response);
        LOGGER.info("Logging Response :{}", response.getContentType());
    }

    @Override
    public void destroy() {

    }

}
