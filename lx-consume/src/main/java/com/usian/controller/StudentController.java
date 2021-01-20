package com.usian.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.usian.fegin.UserFeign;
import com.usian.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private UserFeign userFeign;

    //@HystrixCommand(fallbackMethod = "fallBack",
    //    commandProperties = {
    //            //错误百分比条件，达到熔断器最小请求数后错误率达到百分之多少后打开熔断器
    //            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "5"),
    //            //断容器最小请求数，达到这个值过后才开始计算是否打开熔断器
    //            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "3"),
    //            // 默认5秒; 熔断器打开后多少秒后 熔断状态变成半熔断状态(对该微服务进行一次请求尝试，不成功则状态改成熔断，成功则关闭熔断器
    //            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000")
    //    }
    //
    //)
    @RequestMapping(value="/get/{id}")
    @ResponseBody
    public Student getUser(@PathVariable("id") Integer id){
        int i=3/0;
        Student user = userFeign.getUser(id);
        System.out.println(id);
        System.out.println(132423432);
        return user;
    }
    // 返回托底数据的方法
    //public Student fallBack(Integer id){
    //    Student s = new Student();
    //    s.setId(8888);
    //    System.out.println(11111);
    //    s.setName("熔断器降级数据");
    //    return s;
    //}
    //@Autowired
    // private LoadBalancerClient loadBalancerClient;
    //@Autowired
    // private RestTemplate restTemplate;
    //@RequestMapping("getTest/{id}")
    //public Student getTest(@PathVariable Integer id){
    //    ServiceInstance si = loadBalancerClient.choose("lx-provider");
    //    String host = si.getHost();
    //    int port = si.getPort();
    //    String url="http://"+host+":"+port+"getStu/"+id;
    //   return restTemplate.getForObject(url,Student.class);
    //}
}
