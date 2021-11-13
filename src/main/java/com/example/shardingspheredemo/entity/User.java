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
@TableName(value = "user")
public class User {
    @TableId(value = "user_id")
    private Long userId;

    @TableField(value = "username")
    private String username;

    @TableField(value = "ustatus")
    private String ustatus;

    @TableField(value = "uage")
    private Integer uage;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USERNAME = "username";

    public static final String COL_USTATUS = "ustatus";

    public static final String COL_UAGE = "uage";
}