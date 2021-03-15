package com.sda.spring.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

// annotation triggers a post-processor that inspects every Spring bean for the presence of caching annotations
// on public methods. If such an annotation is found, a proxy is automatically created to intercept the
// method call and handle the caching behavior accordingly
// Spring Boot automatically configures a suitable CacheManager to serve as a provider for the relevant cache
// if not using a cache provider, a simple implementation using a ConcurrentHashMap as the cache store is configured
@EnableCaching
@Configuration
public class CachingConfig {

}
