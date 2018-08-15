package org.kjtc.mapper;


import org.kjtc.entity.${tabletop?cap_first}Entity;
import org.apache.ibatis.jdbc.SQL;

/**
* 类名称：${tabletop?cap_first}Provider
* 创建人：${controllerCreator}
* 创建时间：${nowDate?string("yyyy-MM-dd HH:mm:ss")}
* 描   述: ${objectRemark}
*/


public class ${tabletop?cap_first}Provider {

<#if controllerSelect != '' >
		public String get${tabletop?cap_first}List(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity){

			StringBuffer sql = new StringBuffer();

				sql.append("SELECT  ");
				<#list mysqlList as var>
					<#assign foo="${var[0]}">
					<#if  var?size/2 == var_index >
                    	sql.append("  ${foo} " );
					<#else >
                    	sql.append("  ${foo}, " );
					</#if>


				</#list>
				sql.append("  FROM ${tableName}  ");//表名
			return sql.toString();

		}

</#if>
<#if controllerAdd != '' >

		public String save${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity){

					StringBuffer sql = new StringBuffer();
					sql.append("insert into ${tableName}");
					sql.append("(" );
				<#assign stradd=1>
				<#list mysqlList as var>
					<#assign strfrt=mysqlList?size>
					<#if strfrt==stradd >
					sql.append("${var[0]}");
					<#else>
					sql.append("${var[0]},");
					</#if>
					<#assign stradd=stradd+1>
				</#list>
					sql.append(") values ( " );
				<#assign straddas=1>
				<#list mysqlList as var>
					<#assign foo="${var[0]}">
					<#assign strfrt=mysqlList?size>
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

</#if>
<#if controllerUpadte != '' >
		public String update${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity){

					StringBuffer sql = new StringBuffer();
					sql.append("update ${tableName} set ");
					<#assign stradd=1>
					<#list mysqlList as var>
						<#assign strfrt=mysqlList?size>
						<#if strfrt==stradd >
							sql.append("${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>}");
						<#else>
							sql.append("${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>},");
						</#if>
						<#assign stradd=stradd+1>
					</#list>
					<#assign straesd=1>
					<#list mysqlList as var>
							<#if straesd<2 >
							sql.append(" where  ${var[0]}=#${"{"}<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>}");
							</#if>
						<#assign straesd=straesd+1>
					</#list>
				return sql.toString();
		}

</#if>
<#if controllerDelete != '' >
		public String del${tabletop?cap_first}(${tabletop?cap_first}Entity ${tabletop?uncap_first}Entity) {
					<#assign straesd=1>
					<#list mysqlList as var>
						<#if straesd<2 >
						String newSql = "  ${tableName}  where   ${var[0]} in (";
						</#if>
						<#assign straesd=straesd+1>
					</#list>
					String[] split =  ${tabletop?uncap_first}Entity.getId().split(",");
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
</#if>
<#if controllerImport != '' >
</#if>
<#if controllerExport != '' >
</#if>
}
