package com.example.shardingspheredemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName(value = "course")
public class Course {
    @TableId(value = "cid")
    private Long cid;

    @TableField(value = "cname")
    private String cname;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "cstatus")
    private String cstatus;

    public static final String COL_CID = "cid";

    public static final String COL_CNAME = "cname";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CSTATUS = "cstatus";
}