package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.exception.BusinessException;
import com.wf.ew.common.shiro.EndecryptUtil;
import com.wf.ew.common.utils.CamelCaseUtil;
import com.wf.ew.common.utils.StringUtil;
import com.wf.ew.system.dao.UserHealthMapper;
import com.wf.ew.system.model.Role;
import com.wf.ew.system.model.User;
import com.wf.ew.system.model.UserHealth;
import com.wf.ew.system.model.UserRole;
import com.wf.ew.system.service.UserHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserHealthServiceImpl implements UserHealthService {


    @Autowired
    private UserHealthMapper userHealthMapper;

    @Override
    public PageResult<UserHealth> list(int pageNum, int pageSize, boolean showDelete, String column, String value) {
        Wrapper<UserHealth> wrapper = new EntityWrapper<>();
        if (StringUtil.isNotBlank(column)) {
            if("name".equals(column)){
                wrapper.like(column, value);
            }
            if("idNumber".equals(column)){
                wrapper.eq(CamelCaseUtil.toUnderlineCase(column), value);
            }
        }
        Page<UserHealth> userPage = new Page<>(pageNum, pageSize);
        List<UserHealth> userList = userHealthMapper.selectPage(userPage, wrapper.orderBy("create_time", true));
        if (userList != null && userList.size() > 0) {

        }
        return new PageResult<>(userPage.getTotal(), userList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(UserHealth user) {
        if (userHealthMapper.getByName(user.getName()) != null) {
            throw new BusinessException("账号已经存在");
        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        boolean rs = userHealthMapper.insert(user) > 0;
        return rs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(UserHealth user) {
        boolean rs = userHealthMapper.updateById(user) > 0;
        return rs;
    }
}
