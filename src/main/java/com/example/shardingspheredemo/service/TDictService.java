package com.example.shardingspheredemo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingspheredemo.entity.TDict;
import com.example.shardingspheredemo.mapper.TDictMapper;
@Service
public class TDictService extends ServiceImpl<TDictMapper, TDict> {

}
