package org.kjtc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kjtc.entity.${tabletop}Entity;
import org.kjtc.service.${tabletop}Service;


/**
* 类名称：${tabletop}Controller
* 创建人：${controllerCreator}
* 创建时间：${nowDate?string("yyyy-MM-dd HH:mm:ss")}
* 描   述: ${objectRemark}
*/
@Controller
public class ${tabletop?cap_first}Controller {


    @Autowired
    private ${tabletop?cap_first}Service ${tabletop?uncap_first}Service;

<#if controllerSelect != '' >
    /**
    *  ${objectRemark}映射到Html
    * @return
    */
    @RequestMapping(value = "/${tabletop?uncap_first}")
            public String ${tabletop?uncap_first}Page(){
                return "${tabletop?uncap_first}";
            }

<#-- 生成查询 -->
    /**
    * ${objectRemark}查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/get${tabletop?cap_first}List")
    @ResponseBody
    public Object get${tabletop?cap_first}List(
    ${tabletop?cap_first} ${tabletop?uncap_first}, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<${tabletop?cap_first}> ${tabletop?uncap_first}List = ${tabletop?uncap_first}Service.get${tabletop?cap_first}List(${tabletop?uncap_first});
        PageInfo pageInfo = new PageInfo(${tabletop?uncap_first}List);

        return pageInfo;
    }
</#if>
<#if controllerAdd != '' >
<#-- 生成添加  -->
    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/save${tabletop?cap_first}")
    @ResponseBody
    public Object save${tabletop?cap_first}(${tabletop?cap_first} ${tabletop?uncap_first}) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = ${tabletop?uncap_first}Service.save${tabletop?cap_first}(${tabletop?uncap_first});
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "Error");
        }
    }  catch (DuplicateKeyException ex) {
        ex.printStackTrace();
        String[] error = ex.getCause().getMessage().split("'");
        if ("PRIMARY".equals(error[3].trim())) {
            map.put("result", "EquipmentIDExist");
        } else if ("EquipmentName".equals(error[3].trim())) {
            map.put("result", "EquipmentNameExist");
        } else {
            map.put("result", "DuplicateError");
        }
    } catch (Throwable e) {
        e.printStackTrace();
        map.put("result", "Error");
    }
    return map;
    }
</#if>
<#if controllerUpadte != '' >
<#-- 生成更新 -->
    /**
    * 更新
    * @param
    * @return
    */
    @PostMapping("/update${tabletop?cap_first}")
    @ResponseBody
    public Object updateOperatorInfo(${tabletop?cap_first} ${tabletop?uncap_first}) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = ${tabletop?uncap_first}Service.update${tabletop?cap_first}(${tabletop?uncap_first});
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "NotFound");
        }
    }  catch (DuplicateKeyException ex) {
        String[] error = ex.getCause().getMessage().split("'");
        if ("EquipmentName".equals(error[3].trim())) {
            map.put("result", "EquipmentNameExist");
        } else {
            map.put("result", "DuplicateError");
        }
    } catch (Exception e) {
        e.printStackTrace();
        map.put("result", "Error");

    }
    return map;
    }
</#if>
<#if controllerDelete != '' >
<#-- 生成删除  -->
    /**
    * 删除
    * @param
    * @return
    */
    @RequestMapping(value = "/del${tabletop?cap_first}")
    @ResponseBody
    public Object delOperatorInfo(${tabletop?cap_first} ${tabletop?uncap_first}) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = ${tabletop?uncap_first}Service.del${tabletop?cap_first}(${tabletop?uncap_first});
        if (count > 0) {
            map.put("result", "Success");
        } else {
            map.put("result", "NotFound");
        }
    } catch (Exception e) {
        e.printStackTrace();
        map.put("result", "Error");
    }
    return map;
    }
</#if>
<#if controllerImport != '' >
<#-- 生成导入  -->
//导入
</#if>
<#if controllerExport != '' >
<#-- 生成导出  -->
//导出
</#if>

    }

