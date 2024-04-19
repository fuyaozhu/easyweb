package com.wf.ew.system.controller;


import com.alibaba.fastjson.JSON;
import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageResult;
import com.wf.ew.common.constants.DiseaseNameEnum;
import com.wf.ew.common.utils.StringUtil;
import com.wf.ew.common.vo.DiseaseNameVO;
import com.wf.ew.system.model.UserHealthItem;
import com.wf.ew.system.service.UserHealthItemService;
import com.wf.ew.system.service.UserHealthService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/system/user_health_item")
public class UserHealthItemController {

    private Logger logger = LoggerFactory.getLogger("UserHealthController");

    @Autowired
    private UserHealthItemService userHealthItemService;
    @Autowired
    private UserHealthService userHealthService;


    @RequiresPermissions("health_item:view")
    @RequestMapping
    public String userHealthItem(Model model) {
        List<DiseaseNameVO> diseaseNameList=new ArrayList<>();
        for (DiseaseNameEnum value : DiseaseNameEnum.values()) {
            DiseaseNameVO vo=new DiseaseNameVO();
            vo.setCode(value.getCode());
            vo.setName(value.getName());
            diseaseNameList.add(vo);
        }
        model.addAttribute("diseaseNames", diseaseNameList);
        return "system/user_health_item.html";
    }

    @RequestMapping("/editForm")
    public String editForm(Model model) {
        List<DiseaseNameVO> diseaseNameList=new ArrayList<>();
        for (DiseaseNameEnum value : DiseaseNameEnum.values()) {
            DiseaseNameVO vo=new DiseaseNameVO();
            vo.setCode(value.getCode());
            vo.setName(value.getName());
            diseaseNameList.add(vo);
        }
        model.addAttribute("diseaseNames", diseaseNameList);
        return "system/user_health_item_form.html";
    }

    @RequestMapping("/detailForm")
    public String detailForm(Model model) {
        return "system/user_health_item.html";
    }


    /**
     * 查询疾病信息列表
     */
    @RequiresPermissions("health_item:view")
    @ResponseBody
    @RequestMapping("/list")
    public PageResult<UserHealthItem> list(Integer page, Integer limit, String searchKey, String searchValue) {
        if (page == null) {
            page = 0;
            limit = 0;
        }
        if (StringUtil.isBlank(searchValue)) {
            searchKey = null;
        }
        PageResult<UserHealthItem> list = userHealthItemService.list(page, limit, true, searchKey, searchValue);

        logger.info("user_health.list:", JSON.toJSONString(list.getData()));

        return list;
    }


    /**
     * 添加人員疾病信息
     **/
    @RequiresPermissions("health_item:add")
    @ResponseBody
    @RequestMapping("/add")
    public JsonResult add(UserHealthItem user, HttpServletRequest request) {
        Long userHealthId= Long.valueOf(request.getParameter("userHealthId"));
        user.setUserHealthId(userHealthId
        );
        if (userHealthItemService.add(user)) {
            return JsonResult.ok("添加成功");
        } else {
            return JsonResult.error("添加失败");
        }
    }

    /**
     * 修改人員疾病信息
     **/
    @RequiresPermissions("health_item:edit")
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(UserHealthItem user) {
        if (userHealthItemService.update(user)) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.error("修改失败");
        }
    }

}
