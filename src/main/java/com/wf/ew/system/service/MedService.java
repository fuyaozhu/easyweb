package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.MedicalInstitutionSeal;

public interface MedService {

    PageResult<MedicalInstitutionSeal> list(int pageNum, int pageSize, boolean showDelete, String searchKey, String searchValue);

    boolean add(MedicalInstitutionSeal user);

    boolean update(MedicalInstitutionSeal user);
}
