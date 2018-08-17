<#if packageName != ''>
package ${packageName}.service;
<#else >
package org.kjtc.service;
</#if>

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<#if packageName != ''>
import ${packageName}.entity.${tabletop?cap_first}Entity;
import ${packageName}.mapper.${tabletop?cap_first}Mapper;
<#else >
import org.kjtc.entity.${tabletop?cap_first}Entity;
import org.kjtc.mapper.${tabletop?cap_first}Mapper;
</#if>



/**
* 类名称：${tabletop}Service
* 创建人：${controllerCreator}
* 创建时间：${nowDate?string("yyyy-MM-dd HH:mm:ss")}
* 描   述: ${objectRemark}
*/

@Service("${tabletop?uncap_first}Service")
public class  ${tabletop?cap_first}Service {

	@Autowired
	private ${tabletop?cap_first}Mapper ${tabletop?uncap_first}Mapper;

	/**
	* 查询列表
	* @param ${tabletop?uncap_first}
	* @return
	*/

<#if controllerSelect != '' >

	public List<${tabletop?cap_first}Entity> get${tabletop?cap_first}List(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity) {
		return ${tabletop?uncap_first}Mapper.get${tabletop?cap_first}List(${tabletop?uncap_first}Entity);
		}
</#if>
<#if controllerAdd != '' >
	public int save${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity) {
		return ${tabletop?uncap_first}Mapper.save${tabletop?cap_first}(${tabletop?uncap_first}Entity);
		}
</#if>
<#if controllerUpadte != '' >
	public int update${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity) {
		return ${tabletop?uncap_first}Mapper.update${tabletop?cap_first}(${tabletop?uncap_first}Entity);
		}
</#if>
<#if controllerDelete != '' >
	public int del${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity) {
	return ${tabletop?uncap_first}Mapper.del${tabletop?cap_first}(${tabletop?uncap_first}Entity);
		}
</#if>
<#if controllerImport != '' >
</#if>
<#if controllerExport != '' >
</#if>
}