package org.kjtc.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.kjtc.entity.OutLineEntity;

import java.util.List;

/**
 * Created by xiaojinlu on 2018/8/10/010.
 */
@Mapper
public interface BaseAutomaticMapper {

    @SelectProvider(type = BaseAutomaticProvider.class,method = "queryGaiYaoList")
    public List<OutLineEntity> getQueryGaiYao();
}
