package com.example.config;
import com.example.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor); // Registers the LoggingInterceptor for all paths
        // Can specify specific paths for the interceptor to apply to:
        // registry.addInterceptor(loggingInterceptor).addPathPatterns("/api/**");
        // registry.addInterceptor(loggingInterceptor).excludePathPatterns("/admin/**");
    }
}
/**
 * @Configuration: indicates that this class provides Spring configuration.
WebMvcConfigurer: Implementing this interface allows to customize Spring MVC configuration.
addInterceptors(): This method is used to register your interceptors. autowire the LoggingInterceptor and add it to the registry.
addPathPatterns(): You can use this to specify the URL patterns that this interceptor should intercept (e.g., /api/** for all URLs starting with /api).
excludePathPatterns(): You can use this to exclude specific URL patterns from being intercepted (e.g., /admin/** to exclude URLs starting with /admin).
 * */