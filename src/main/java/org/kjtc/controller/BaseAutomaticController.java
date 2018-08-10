package org.kjtc.controller;



import org.kjtc.entity.OutLineEntity;
import org.kjtc.service.BaseAutomaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by Administrator on 2018/8/10/010.
 */
@RestController
public class BaseAutomaticController {

    @Autowired
    private BaseAutomaticService baseAutomaticService;



    @RequestMapping("/query_gai_yao")
    @ResponseBody
    public Object queryGaiYao() {
        List<OutLineEntity>  outLineEntities= baseAutomaticService.getQueryGaiYao();
        return outLineEntities;
    }


}
