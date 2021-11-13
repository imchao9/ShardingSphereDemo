package com.example.shardingspheredemo;

import com.example.shardingspheredemo.entity.Course;
import com.example.shardingspheredemo.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereDemoApplication.class)
class ShardingSphereDemoApplicationTests {

    @Autowired
    CourseService courseService;

    @Test
    void contextLoads() {

    }

    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("shardingsphere");
            course.setUserId(Long.valueOf("" + (1000 + i)));
            course.setCstatus("1");
            courseService.save(course);
        }

    }

}
