package com.sda.spring.filter.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(3)
@Component
public class RedirectFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(RedirectFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init redirect filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // step one redirect to step two
        if (request.getRequestURI().endsWith("/step-one")) {

            // add custom header
            response.addHeader("custom", "redirected");
            response.sendRedirect("/step-two");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
