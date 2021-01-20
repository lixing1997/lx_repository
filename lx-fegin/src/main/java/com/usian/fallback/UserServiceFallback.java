package com.usian.fallback;

import com.sun.org.apache.regexp.internal.RE;
import com.usian.fegin.UserFeign;
import com.usian.pojo.Student;
import org.springframework.stereotype.Component;

//@Component
public class UserServiceFallback implements UserFeign {


    @Override
    public Student getUser(Integer id) {
        Student s = new Student();
        s.setName("托底数据");
        s.setId(666);
        return s;
    }
}
