package com.wf.ew.system.model;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@TableName("medical_institution_seal")
@Data
public class MedicalInstitutionSeal {


    @TableId
    private Integer Id;  // 主键id

    private Date createTime; //創建時間

    private Date updateTime; //修改時間

    private String medicalInstitutionName;  // 医院名称

    private String sealImage;  // 印章图片
}
