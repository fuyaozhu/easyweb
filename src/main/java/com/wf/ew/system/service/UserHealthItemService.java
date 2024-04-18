package com.wf.ew.system.service;

import com.wf.ew.common.PageResult;
import com.wf.ew.system.model.Role;
import com.wf.ew.system.model.UserHealth;
import com.wf.ew.system.model.UserHealthItem;

import java.util.List;

public interface UserHealthItemService {

    PageResult<UserHealthItem> list(int pageNum, int pageSize, boolean showDelete, String searchKey, String searchValue);

    boolean add(UserHealthItem user);

    boolean update(UserHealthItem user);

    List<UserHealthItem> list(boolean showDelete);

}