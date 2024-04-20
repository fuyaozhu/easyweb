package com.wf.ew.system.model;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@TableName("user_health")
@Data
public class UserHealth {

    @TableId
    private Integer Id;  // 主键id

    private Date createTime; //創建時間

    private Date updateTime; //修改時間

    private String name;  // 姓名

    private String sex;  // 性別

    private String birthDate;  // 出生年月

    private String physicalExaminationDate;  // 体检日期

    private String trainDate;  // 培训日期

    private String reportDate;  // 报告日期

    private String medicalInstitution;  // 医疗机构

    private String idNumber;  // 身份证号码

    private String cardNumber;  // 证卡号码

    private String image;  // 健康证图片

    private String type;  // 类型


}
