package com.wf.ew.system.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.exception.BusinessException;
import com.wf.ew.system.dao.MedicalInstiutionSealMapper;
import com.wf.ew.system.model.MedicalInstitutionSeal;
import com.wf.ew.system.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MedServiceImpl implements MedService {

    @Autowired
    private MedicalInstiutionSealMapper medicalInstiutionSealMapper;

    @Override
    public PageResult<MedicalInstitutionSeal> list(int pageNum, int pageSize, boolean showDelete, String column, String value) {
        Wrapper<MedicalInstitutionSeal> wrapper = new EntityWrapper<>();
        /*if (StringUtil.isNotBlank(column)) {
            if("name".equals(column)){
                wrapper.like(column, value);
            }
            if("idNumber".equals(column)){
                wrapper.eq(CamelCaseUtil.toUnderlineCase(column), value);
            }
        }*/
        Page<MedicalInstitutionSeal> userPage = new Page<>(pageNum, pageSize);
        List<MedicalInstitutionSeal> userList = medicalInstiutionSealMapper.selectPage(userPage, wrapper.orderBy("create_time", true));
        if (userList != null && userList.size() > 0) {

        }
        return new PageResult<>(userPage.getTotal(), userList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(MedicalInstitutionSeal medicalInstitutionSeal) {
        if (medicalInstiutionSealMapper.getByName(medicalInstitutionSeal.getMedicalInstitutionName()) != null) {
            throw new BusinessException("银行已经存在");
        }
        medicalInstitutionSeal.setCreateTime(new Date());
        medicalInstitutionSeal.setUpdateTime(new Date());
        boolean rs = medicalInstiutionSealMapper.insert(medicalInstitutionSeal) > 0;
        return rs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(MedicalInstitutionSeal user) {
        boolean rs = medicalInstiutionSealMapper.updateById(user) > 0;
        return rs;
    }
}
