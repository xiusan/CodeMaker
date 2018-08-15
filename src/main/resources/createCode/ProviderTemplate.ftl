package org.kjtc.mapper;


import org.kjtc.entity.${objectName};
import org.apache.ibatis.jdbc.SQL;

/**
* 类名称：${objectName}Provider
* 创建人：
* 创建时间：${nowDate?string("yyyy-MM-dd")}
* 描   述:
*/


public class ${objectName}Provider {

public String get${objectName}List(${objectName} ${objectNameLower}){

	StringBuffer sql = new StringBuffer();

		sql.append("SELECT  ");
		<#list fieldList as var>
			<#assign stradd=1>
			<#assign foo="${var[0]}">
		sql.append("  ${foo}, " );
		</#list>
		sql.append("  '' as addnullvalue ");
		sql.append("  FROM ${tabletop}  ");//表名
	return sql.toString();

}



public String save${objectName}(${objectName} ${objectNameLower}){

			StringBuffer sql = new StringBuffer();
			sql.append("insert into ${tabletop}");
			sql.append("(" );
		<#assign stradd=1>
		<#list fieldList as var>
			<#assign strfrt=fieldList?size>
			<#if strfrt==stradd >
			sql.append("${var[0]}");
			<#else>
			sql.append("${var[0]},");
			</#if>
			<#assign stradd=stradd+1>
		</#list>
			sql.append(") values ( " );
		<#assign straddas=1>
		<#list fieldList as var>
			<#assign foo="${var[0]}">
			<#assign strfrt=fieldList?size>
			<#assign stradd=1>
			<#if strfrt==straddas >
			sql.append("#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>}");
			<#else>
			sql.append("#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>},");
			</#if>
			<#assign straddas=straddas+1>
		</#list>
			sql.append(")" );
		return sql.toString();
}


public String update${objectName}(${objectName} ${objectNameLower}){

			StringBuffer sql = new StringBuffer();
			sql.append("update ${tabletop} set ");
			<#assign stradd=1>
			<#list fieldList as var>
				<#assign strfrt=fieldList?size>
				<#if strfrt==stradd >
                    sql.append("${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>}");
				<#else>
                    sql.append("${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>},");
				</#if>
				<#assign stradd=stradd+1>
			</#list>
			<#assign straesd=1>
			<#list fieldList as var>
					<#if straesd<2 >
					sql.append(" where  ${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>}");
					</#if>
				<#assign straesd=straesd+1>
			</#list>
		return sql.toString();
}


public String del${objectName}(${objectName} ${objectNameLower}) {
			<#assign straesd=1>
			<#list fieldList as var>
				<#if straesd<2 >
				String newSql = "  ${tabletop}  where   ${var[0]} in (";
				</#if>
				<#assign straesd=straesd+1>
			</#list>
			String[] split =  ${objectNameLower}.getId().split(",");
			for (int i = 0; i < split.length - 1; i++) {
			newSql += "'";
			newSql += split[i];
			newSql += "'";
			newSql += ",";
			}
			newSql += "'";
			newSql += split[split.length - 1];
			newSql += "'";
			newSql += ")";
			SQL sql = new SQL().DELETE_FROM(newSql);

	return sql.toString();
}

}
