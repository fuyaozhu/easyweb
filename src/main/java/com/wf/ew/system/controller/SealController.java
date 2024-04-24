package com.wf.ew.system.controller;


import com.alibaba.fastjson.JSON;
import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.utils.StringUtil;
import com.wf.ew.system.model.MedicalInstitutionSeal;
import com.wf.ew.system.service.MedService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/seal")
public class SealController {

    private Logger logger = LoggerFactory.getLogger("UserHealthController");

    @Autowired
    private MedService medService;


    @RequestMapping
    public String seal(Model model) {
        return "system/seal.html";
    }

    @RequestMapping("/editForm")
    public String editForm(Model model) {
        return "system/seal_form.html";
    }



    /**
     * 查询健康信息列表
     */
    @RequiresPermissions("seal:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<MedicalInstitutionSeal> list(Integer page, Integer limit, String searchKey, String searchValue) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        if (StringUtil.isBlank(searchValue)) {
            searchKey = null;
        }
        PageResult<MedicalInstitutionSeal> list = medService.list(page, limit, true, searchKey, searchValue);

        logger.info("user_health.list:", JSON.toJSONString(list.getData()));

        return list;
    }


    /**
     * 添加人員健康信息
     **/
    @RequiresPermissions("seal:add")
    @ResponseBody
    @RequestMapping("/add")
    public JsonResult add(MedicalInstitutionSeal user) {
        if (medService.add(user)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    /**
     * 修改人員健康信息
     **/
    @RequiresPermissions("seal:edit")
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(MedicalInstitutionSeal user) {
        if (medService.update(user)) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.error("修改失败");
        }
    }

}
