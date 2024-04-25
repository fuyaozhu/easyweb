package com.wf.ew.system.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wf.ew.common.vo.DiseaseNameVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户疾病明细表
 */
@TableName("user_health_item")
@Data
public class UserHealthItem {

    @TableId
    private Long Id;  // 主键id

    private Date createTime; //創建時間

    private Date updateTime; //修改時間

    private Long userHealthId; //关联id

    private String diseaseName;  // 疾病名称

    @TableField(exist = false)
    private List<DiseaseNameVO> diseaseNameVOList;  // 疾病名称

    private String chiefPhysician;//医师签章

    private String have;  // 有无疾病

    private String remark;  // 备注

    private String inspectionDate  ;  // 检查日期

    private String inspectionResults; //检查结果

    private String whetherToCheck; //是否已检查




}
