package com.wf.ew.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wf.ew.system.model.MedicalInstitutionSeal;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicalInstiutionSealMapper extends BaseMapper<MedicalInstitutionSeal> {

    MedicalInstitutionSeal getByName(@Param("name") String name);
}
