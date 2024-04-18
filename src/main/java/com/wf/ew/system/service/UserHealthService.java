package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.UserHealth;

public interface UserHealthService {

    PageResult<UserHealth> list(int pageNum, int pageSize, boolean showDelete, String searchKey, String searchValue);

    boolean add(UserHealth user);

    boolean update(UserHealth user);
}
