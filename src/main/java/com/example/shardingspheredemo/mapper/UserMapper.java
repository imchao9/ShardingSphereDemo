package com.example.shardingspheredemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingspheredemo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select u.user_id,u.username,d.ustatus from user u left join t_dict d on u.ustatus = d.cstatus")
    List<User> queryUserStatus();
}