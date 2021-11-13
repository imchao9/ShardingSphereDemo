package com.example.shardingspheredemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName(value = "t_dict")
public class TDict {
    @TableId(value = "dict_id")
    private Long dictId;

    @TableField(value = "cstatus")
    private String cstatus;

    @TableField(value = "ustatus")
    private String ustatus;

    @TableField(value = "create_at")
    private Date createAt;

    public static final String COL_DICT_ID = "dict_id";

    public static final String COL_CSTATUS = "cstatus";

    public static final String COL_USTATUS = "ustatus";

    public static final String COL_CREATE_AT = "create_at";
}