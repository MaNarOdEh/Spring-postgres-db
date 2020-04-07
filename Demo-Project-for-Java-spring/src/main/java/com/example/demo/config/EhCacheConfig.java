package com.example.demo.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class EhCacheConfig extends CachingConfigurerSupport {

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    /**
     * 
     * @return
     */

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration cacheMovieConfig = new CacheConfiguration();
        cacheMovieConfig.setName("cache-movie");
        cacheMovieConfig.setMemoryStoreEvictionPolicy("LRU");// when the cache is full which algorithms should work
        cacheMovieConfig.setMaxEntriesLocalHeap(1000); // max number of cache entry you can store..
        cacheMovieConfig.setTimeToLiveSeconds(10);

        CacheConfiguration cachePersonConfig = new CacheConfiguration();
        cachePersonConfig.setName("cache-person");
        cachePersonConfig.setMemoryStoreEvictionPolicy("LRU");// when the cache is full which algorithms should work
        cachePersonConfig.setMaxEntriesLocalHeap(1000); // max number of cache entry you can store..
        cachePersonConfig.setTimeToLiveSeconds(10);
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheMovieConfig);
        config.addCache(cachePersonConfig);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }
}