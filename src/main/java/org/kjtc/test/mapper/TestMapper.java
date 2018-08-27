package org.kjtc.test.mapper;

import org.kjtc.test.entity.TestEntity;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：testMapper 
* 创建人：root
* 创建时间：2018-08-27 15:23:39
* 描   述: 功能备注
*/

@Mapper
public interface TestMapper {


    @SelectProvider(type = TestProvider.class, method = "getTestList")
    List<TestEntity> getTestList(TestEntity testEntity);

    @InsertProvider(type = TestProvider.class, method = "saveTest")
    int saveTest(TestEntity testEntity);

    @UpdateProvider(type = TestProvider.class, method = "updateTest")
    int updateTest(TestEntity testEntity);

    @DeleteProvider(type = TestProvider.class, method = "delTest")
    int delTest(TestEntity testEntity);
    }
