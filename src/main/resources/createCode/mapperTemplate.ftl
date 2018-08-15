package org.kjtc.mapper;

import org.kjtc.entity.${objectName};
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：${objectName}Mapper
* 创建人：
* 创建时间：${nowDate?string("yyyy-MM-dd")}
* 描   述: {objectRemark}
*/

@Mapper
public interface ${objectName}Mapper {


@SelectProvider(type = ${objectName}Provider.class, method = "get${objectName}List")
List<${objectName}> get${objectName}List(${objectName} ${objectNameLower});


    @InsertProvider(type = ${objectName}Provider.class, method = "save${objectName}")
    int save${objectName}(${objectName} ${objectNameLower});


    @UpdateProvider(type = ${objectName}Provider.class, method = "update${objectName}")
    int update${objectName}(${objectName} ${objectNameLower});


    @DeleteProvider(type = ${objectName}Provider.class, method = "del${objectName}")
    int del${objectName}(${objectName} ${objectNameLower});
    }
