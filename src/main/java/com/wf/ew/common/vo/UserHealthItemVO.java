package com.wf.ew.common.vo;


import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 疾病明细vo
 */
@Data
public class UserHealthItemVO {

    @TableId
    private Long Id;  // 主键id

    private Date createTime; //創建時間

    private Date updateTime; //修改時間

    private Long userHealthId; //关联id

    private String diseaseName;  // 疾病名称

    private String chiefPhysician;//医师签章

    private String have;  // 有无疾病

    private String remark;  // 备注

    private String inspectionDate  ;  // 检查日期


}
