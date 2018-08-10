package com.mogateway.controller;

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

import com.mogateway.entity.${objectName};
import com.mogateway.service.${objectName}Service;


/**
* 类名称：${objectName}Controller
* 创建人：
* 创建时间：${nowDate?string("yyyy-MM-dd")}
* 描   述: ${objectRemark}
*/
@Controller
public class ${objectName}Controller {


    @Autowired
    private ${objectName}Service ${objectNameLower}Service;

    /**
    *  ${objectRemark}映射到Html
    * @return
    */
    @RequestMapping(value = "/${objectNameLower}")
            public String ${objectNameLower}Page(){
                return "${objectName}";
            }

    /**
    * ${objectRemark}查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/get${objectName}List")
    @ResponseBody
    public Object get${objectName}List(
    ${objectName} ${objectNameLower}, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.get${objectName}List(${objectNameLower});
        PageInfo pageInfo = new PageInfo(${objectNameLower}List);

        return pageInfo;
    }

    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/save${objectName}")
    @ResponseBody
    public Object save${objectName}(${objectName} ${objectNameLower}) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = ${objectNameLower}Service.save${objectName}(${objectNameLower});
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

    /**
    * 更新
    * @param
    * @return
    */
    @PostMapping("/update${objectName}")
    @ResponseBody
    public Object updateOperatorInfo(${objectName} ${objectNameLower}) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = ${objectNameLower}Service.update${objectName}(${objectNameLower});
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

    /**
    * 删除
    * @param
    * @return
    */
    @RequestMapping(value = "/del${objectName}")
    @ResponseBody
    public Object delOperatorInfo(${objectName} ${objectNameLower}) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = ${objectNameLower}Service.del${objectName}(${objectNameLower});
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

    }