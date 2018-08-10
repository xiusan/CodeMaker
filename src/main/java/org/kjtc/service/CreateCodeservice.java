package org.kjtc.service;

import org.apache.commons.collections.map.HashedMap;
import org.kjtc.util.StringUtils;
import org.kjtc.util.createCode.PageData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojinlu  on 2018/8/10/010.
 */
@Service("createCodeservice")
public class CreateCodeservice {
    public  List<String[]>  getGaiyao(PageData pd) {
        //获取全部要生成的值
        String zindext = pd.getString("mysqlIndex");                    //属性总数
        int zindex = 0;
        if (null != zindext && !"".equals(zindext)) {
            zindex = Integer.parseInt(zindext);
        }
        List<String[]> gaiYaoList = new ArrayList<String[]>();    //属性集合
        for (int i = 0; i < zindex; i++) {
            gaiYaoList.add(pd.getString("field" + i).split(",fh,"));    //属性放到集合里面
        }
        return gaiYaoList;
    }



}
