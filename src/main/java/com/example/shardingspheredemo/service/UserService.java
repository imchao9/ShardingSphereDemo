package com.example.shardingspheredemo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingspheredemo.entity.User;
import com.example.shardingspheredemo.mapper.UserMapper;
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
