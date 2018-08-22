package org.kjtc.controller;



import com.github.pagehelper.PageInfo;
import org.kjtc.entity.OutLineEntity;
import org.kjtc.entity.OutMysqlEntity;
import org.kjtc.service.BaseAutomaticService;
import org.kjtc.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by Administrator on 2018/8/10/010.
 */
@RestController
public class BaseAutomaticController {

    @Autowired
    private BaseAutomaticService baseAutomaticService;


    /**
     * 获取概要详情
     * @return
     */
    @RequestMapping("/query_gai_yao")
    @ResponseBody
    public Object queryGaiYao() {
        List<OutLineEntity>  outLineEntities= baseAutomaticService.getQueryGaiYao();
        PageInfo pageInfo = new PageInfo(outLineEntities);
        return pageInfo;
    }

    /**
     * 获取mysql详情
     * @return
     */
    @RequestMapping("/query_mysql")
    @ResponseBody
    public Object queryMsql() {
        List<OutMysqlEntity>  outLineEntities= baseAutomaticService.getQueryMysql();
        PageInfo pageInfo = new PageInfo(outLineEntities);
        return pageInfo;
    }

    /**
     * 获取预览的sql信息
     * @return
     */
    @RequestMapping("/querySqlShow")
    public String querySqlShow(HttpServletResponse response,HttpServletRequest request) throws Exception {
       String  showSql= baseAutomaticService.querySqlShow(response,request);

        return showSql;
    }

}
