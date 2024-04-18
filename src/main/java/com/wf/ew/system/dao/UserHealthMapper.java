package com.wf.ew.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wf.ew.system.model.User;
import com.wf.ew.system.model.UserHealth;
import com.wf.ew.system.model.UserHealthItem;
import io.lettuce.core.dynamic.annotation.Param;

public interface UserHealthMapper extends BaseMapper<UserHealth> {

    UserHealth getByName(@Param("name") String name);
}
