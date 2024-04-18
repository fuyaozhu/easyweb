package com.wf.ew.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wf.ew.system.model.UserHealth;
import com.wf.ew.system.model.UserHealthItem;
import io.lettuce.core.dynamic.annotation.Param;

public interface UserHealthItemMapper extends BaseMapper<UserHealthItem> {

    UserHealthItem getByDiseaseName(@Param("diseaseName") String diseaseName);
}