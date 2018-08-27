package org.kjtc.test.controller;


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

import org.kjtc.test.entity.TestEntity;
import org.kjtc.test.service.TestService;



/**
* 类名称：TestController
* 创建人：root
* 创建时间：2018-08-27 15:23:39
* 描   述: 功能备注
*/
@Controller
public class TestController {


    @Autowired
    private TestService testService;

    /**
    *  功能备注映射到Html
    * @return
    */
    @RequestMapping(value = "/test")
            public String testPage(){
                return "test";
            }

    /**
    * 功能备注查询List
    * @param pageNum
    * @param pageSize
    * @return
    */
    @RequestMapping("/getTestList")
    @ResponseBody
    public Object getTestList(
    TestEntity testEntity, @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<TestEntity> testList = testService.getTestList(testEntity);
        PageInfo pageInfo = new PageInfo(testList);

        return pageInfo;
    }
    /**
    * 添加
    * @param
    * @return
    */
    @PostMapping("/saveTest")
    @ResponseBody
    public Object saveTest(TestEntity testEntity) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
        int count = testService.saveTest(testEntity);
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
    @PostMapping("/updateTest")
    @ResponseBody
    public Object updateOperatorInfo(TestEntity testEntity) {

    Map<String, Object> map = new HashMap<String, Object>();

    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = testService.updateTest(testEntity);
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
    @RequestMapping(value = "/delTest")
    @ResponseBody
    public Object delOperatorInfo(TestEntity testEntity) {

    Map<String, Object> map = new HashMap<String, Object>();
    /* 需要单独实现ID判定
    if (StringUtils.isEmpty(operatorInfo.getOperatorId())) {
        map.put("result", "OperatorIdEmpty");
        return map;
    }
    */
    try {
        int count = testService.delTest(testEntity);
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
//导入
//导出

    }

