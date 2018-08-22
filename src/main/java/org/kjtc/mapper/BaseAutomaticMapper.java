package org.kjtc.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.kjtc.entity.OutLineEntity;
import org.kjtc.entity.OutMysqlEntity;

import java.util.List;

/**
 * Created by xiaojinlu on 2018/8/10/010.
 */
@Mapper
public interface BaseAutomaticMapper {

    @SelectProvider(type = BaseAutomaticProvider.class,method = "queryGaiYaoList")
    List<OutLineEntity> getQueryGaiYao();

    @SelectProvider(type = BaseAutomaticProvider.class,method = "queryMysqlList")
    List<OutMysqlEntity> getQueryMysql();
}
