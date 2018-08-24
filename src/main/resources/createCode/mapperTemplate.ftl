<#if packageName != ''>
package org.kjtc.${packageName}.mapper;
<#else >
package org.kjtc.mapper;
</#if>

<#if packageName != ''>
import org.kjtc.${packageName}.entity.${tabletop?cap_first}Entity;
<#else >
import org.kjtc.entity.${tabletop?cap_first}Entity;
</#if>

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* 类名称：${tabletop}Mapper 
* 创建人：${controllerCreator}
* 创建时间：${nowDate?string("yyyy-MM-dd HH:mm:ss")}
* 描   述: ${objectRemark}
*/

@Mapper
public interface ${tabletop?cap_first}Mapper {


<#if controllerSelect != '' >
    @SelectProvider(type = ${tabletop?cap_first}Provider.class, method = "get${tabletop?cap_first}List")
    List<${tabletop?cap_first}Entity> get${tabletop?cap_first}List(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity);
</#if>
<#if controllerAdd != '' >

    @InsertProvider(type = ${tabletop?cap_first}Provider.class, method = "save${tabletop?cap_first}")
    int save${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity);
</#if>
<#if controllerUpadte != '' >

    @UpdateProvider(type = ${tabletop?cap_first}Provider.class, method = "update${tabletop?cap_first}")
    int update${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity);

</#if>
<#if controllerDelete != '' >
    @DeleteProvider(type = ${tabletop?cap_first}Provider.class, method = "del${tabletop?cap_first}")
    int del${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity);
</#if>
<#if controllerImport != '' >
</#if>
<#if controllerExport != '' >
</#if>
    }
