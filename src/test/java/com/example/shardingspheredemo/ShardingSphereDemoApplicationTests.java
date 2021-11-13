package com.example.shardingspheredemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingspheredemo.entity.Course;
import com.example.shardingspheredemo.entity.TDict;
import com.example.shardingspheredemo.entity.User;
import com.example.shardingspheredemo.mapper.CourseMapper;
import com.example.shardingspheredemo.mapper.TDictMapper;
import com.example.shardingspheredemo.mapper.UserMapper;
import com.example.shardingspheredemo.service.CourseService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereDemoApplication.class)
class ShardingSphereDemoApplicationTests {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    TDictMapper tDictMapper;

    @Autowired
    UserMapper userMapper;

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

    @Test
    void queryCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(Course.COL_CID);
        wrapper.eq(Course.COL_CID, Long.valueOf("1459312435541368834"));
        List<Course> courseList = courseMapper.selectList(wrapper);
        courseList.forEach(System.out::println);
    }

    @Test
    void queryOrderRange() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(Course.COL_CID);
        wrapper.between(Course.COL_CID, Long.valueOf("1459312432722796546"), Long.valueOf("1459312435541368834"));
        List<Course> courseList = courseMapper.selectList(wrapper);
        courseList.forEach(System.out::println);
    }

    @Test
    public void queryCourseComplex() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.between(Course.COL_CID, Long.valueOf("1459312432722796546"), Long.valueOf("1459312435541368834"));
//        wrapper.eq(Course.COL_USER_ID, Long.valueOf("1002"));
        wrapper.eq(Course.COL_USER_ID, 1002L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }

    @Test
    public void queryCourseByHint() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("course",2);
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(course -> System.out.println(course));
        hintManager.close();
    }

    @Test
    public void addDict() {
        TDict d1 = new TDict();
        d1.setCstatus("1");
        d1.setUstatus("正常");
        tDictMapper.insert(d1);

        TDict d2 = new TDict();
        d2.setCstatus("2");
        d2.setUstatus("不正常");
        tDictMapper.insert(d2);

        for(int i = 0;i< 10 ;i++) {
            User user = new User();
            user.setUsername("User No " + i);
            user.setUstatus("" + (i%2));
            user.setUage(50);
            userMapper.insert(user);
        }
    }

    @Test
    public void queryUserStatus() {
        List<User> users = userMapper.queryUserStatus();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void addDIctByMS() {
        TDict d1 = new TDict();
        d1.setCstatus("1");
        d1.setUstatus("正常");
        tDictMapper.insert(d1);

        TDict d2 = new TDict();
        d2.setCstatus("2");
        d2.setUstatus("不正常");
        tDictMapper.insert(d2);
    }

}
