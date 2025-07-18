package com.shemuel.landlordhelper.utils;

import com.shemuel.landlordhelper.annotation.AccessLimit;
import com.shemuel.landlordhelper.common.LocalRateLimiter;
import com.shemuel.landlordhelper.exception.ServiceException;
import com.shemuel.landlordhelper.service.IRateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 公众号: 加瓦点灯
 * @Date: 2025-03-20-18:00
 * @Description:
 */
@Component
public class RateLimiterFactory {

    @Value("${rateLimiter.type: local}")
    private String rateLimiterType;

    private ConcurrentHashMap<String, IRateLimiter> rateLimiterMap = new ConcurrentHashMap<>();


    public  IRateLimiter createRateLimiter(AccessLimit accessLimit) {
       if ("redis".equals(rateLimiterType)){
           throw new RuntimeException("redis限流暂未实现");
       }else {
           return new LocalRateLimiter( accessLimit.interval(), accessLimit.limit());
       }
    }

    public  IRateLimiter createRateLimiter(Integer interval, Integer limit) {
        if ("redis".equals(rateLimiterType)){
            throw new RuntimeException("redis限流暂未实现");
        }else {
            return new LocalRateLimiter( interval, limit);
        }
    }

    public void addRateLimiter(String group, IRateLimiter rateLimiter) {
        rateLimiterMap.put(group, rateLimiter);
    }

    public IRateLimiter getRateLimiter(String group) {
        return rateLimiterMap.get(group);
    }

    public Set<String> getAllRateLimiterGroups() {
        return rateLimiterMap.keySet();
    }

    public IRateLimiter removeRateLimiter(String group) {
        return rateLimiterMap.remove(group);
    }
}
