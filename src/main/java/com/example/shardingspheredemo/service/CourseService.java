package com.example.shardingspheredemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingspheredemo.entity.Course;
import com.example.shardingspheredemo.mapper.CourseMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends ServiceImpl<CourseMapper, Course> {

}
