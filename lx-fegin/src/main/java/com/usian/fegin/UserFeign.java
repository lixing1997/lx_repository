package com.usian.fegin;

import com.usian.factory.UserFallBackFactory;
import com.usian.fallback.UserServiceFallback;
import com.usian.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//获取eureka-provider的调用地址，且具有负载均衡的能力
//@FeignClient(value="lx-provider",fallback = UserServiceFallback.class)
@FeignClient(value="lx-provider",fallbackFactory = UserFallBackFactory.class)
//@FeignClient(value="lx-provider")
public interface UserFeign {
	@RequestMapping("/getUser/{id}")
	 Student getUser(@PathVariable("id") Integer id);
}