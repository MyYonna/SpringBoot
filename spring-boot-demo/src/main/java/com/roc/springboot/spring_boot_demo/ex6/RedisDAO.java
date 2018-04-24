package com.roc.springboot.spring_boot_demo.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
@Repository
public class RedisDAO {
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public String getValue(String key) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		return ops.get(key);
	}
	
	public void setValue(String key,String value) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set(key, value);
	}
}
