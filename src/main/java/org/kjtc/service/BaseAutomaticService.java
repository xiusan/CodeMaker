package org.kjtc.service;


import org.kjtc.entity.OutLineEntity;
import org.kjtc.mapper.BaseAutomaticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2018/8/10/010.
 */
@Service("baseAutomaticService")
public class BaseAutomaticService {


    @Autowired
    private BaseAutomaticMapper baseAutomaticMapper;


    public List<OutLineEntity> getQueryGaiYao() {
        return baseAutomaticMapper.getQueryGaiYao();
    }
}
