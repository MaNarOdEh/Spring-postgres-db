package com.example.demo.config;

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
     * configure ehCache
     * 
     * @return
     */

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(getCacheConfiguration("cache-movie", "LRU", 1000, 10));
        config.addCache(getCacheConfiguration("cache-person", "LRU", 1000, 10));
        config.addCache(getCacheConfiguration("cache-movie-page", "LRU", 1000, 10));
        config.addCache(getCacheConfiguration("userInfo", "LRU", 1000, 10));
        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    private CacheConfiguration getCacheConfiguration(String name, String algName, int maxEntire, int time) {
        CacheConfiguration cachConfig = new CacheConfiguration();
        cachConfig.setName(name);
        cachConfig.setMemoryStoreEvictionPolicy(algName);// when the cache is full which algorithms should work
        cachConfig.setMaxEntriesLocalHeap(maxEntire); // max number of cache entry you can store..
        cachConfig.setTimeToLiveSeconds(time);
        return cachConfig;
    }
}