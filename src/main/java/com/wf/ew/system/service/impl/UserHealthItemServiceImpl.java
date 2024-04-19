package com.wf.ew.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.exception.BusinessException;
import com.wf.ew.common.utils.StringUtil;
import com.wf.ew.system.dao.UserHealthItemMapper;
import com.wf.ew.system.model.UserHealthItem;
import com.wf.ew.system.service.UserHealthItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class UserHealthItemServiceImpl implements UserHealthItemService {


    @Autowired
    private UserHealthItemMapper userHealthMapper;

    @Override
    public PageResult<UserHealthItem> list(int pageNum, int pageSize, boolean showDelete, String column, String value) {
        Wrapper<UserHealthItem> wrapper = new EntityWrapper<>();
        if (StringUtil.isNotBlank(column)) {
            if("user_health_id".equals(column)){
                wrapper.eq(column, value);
            }
        }
        Page<UserHealthItem> userPage = new Page<>(pageNum, pageSize);
        List<UserHealthItem> userList = userHealthMapper.selectPage(userPage, wrapper.orderBy("create_time", true));
        if (userList != null && userList.size() > 0) {

        }
        return new PageResult<>(userPage.getTotal(), userList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(UserHealthItem user) {
        if (userHealthMapper.getByDiseaseNameAndUserHealthId(user.getDiseaseName(),user.getUserHealthId()) != null) {
            throw new BusinessException("当前疾病名称此人员已经存在,请勿重复操作");
        }
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        boolean rs = userHealthMapper.insert(user) > 0;
        return rs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(UserHealthItem user) {
        boolean rs = userHealthMapper.updateById(user) > 0;
        return rs;
    }

    @Override
    public List<UserHealthItem> list(boolean showDelete) {
        Wrapper wrapper = new EntityWrapper();
        if (!showDelete) {
            wrapper.eq("is_delete", 0);
        }
        return userHealthMapper.selectList(wrapper.orderBy("create_time", true));
    }
}
