package com.usian.factory;

import com.usian.fallback.UserServiceFallback;
import com.usian.fegin.UserFeign;
import com.usian.pojo.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFallBackFactory implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {
            @Override
            public Student getUser(Integer id) {
                Student s = new Student();
                s.setId(999);
                s.setName("我是托底数据"+throwable.getMessage());
                return s;
            }
        };
    }
}
