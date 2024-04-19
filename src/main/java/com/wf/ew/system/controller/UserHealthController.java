package com.wf.ew.system.controller;


import com.alibaba.fastjson.JSON;
import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.utils.StringUtil;
import com.wf.ew.system.model.UserHealth;
import com.wf.ew.system.service.UserHealthService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/user_health")
public class UserHealthController {

    private Logger logger = LoggerFactory.getLogger("UserHealthController");

    @Autowired
    private UserHealthService userHealthService;


    @RequiresPermissions("health:view")
    @RequestMapping
    public String userHealth(Model model) {
        return "system/user_health.html";
    }

    @RequestMapping("/editForm")
    public String editForm(Model model) {
        return "system/user_health_form.html";
    }

    @RequestMapping("/detailForm")
    public String detailForm(Model model) {
        return "system/user_health_item.html";
    }


    /**
     * 查询健康信息列表
     */
    @RequiresPermissions("health:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<UserHealth> list(Integer page, Integer limit, String searchKey, String searchValue) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        if (StringUtil.isBlank(searchValue)) {
            searchKey = null;
        }
        PageResult<UserHealth> list = userHealthService.list(page, limit, true, searchKey, searchValue);

        logger.info("user_health.list:", JSON.toJSONString(list.getData()));

        return list;
    }


    /**
     * 添加人員健康信息
     **/
    @RequiresPermissions("health:add")
    @ResponseBody
    @RequestMapping("/add")
    public JsonResult add(UserHealth user) {
        if (userHealthService.add(user)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    /**
     * 修改人員健康信息
     **/
    @RequiresPermissions("health:edit")
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(UserHealth user) {
        if (userHealthService.update(user)) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.error("修改失败");
        }
    }

}
