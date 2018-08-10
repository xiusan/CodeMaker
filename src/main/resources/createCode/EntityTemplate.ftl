package com.mogateway.entity;




/**
* ${objectRemark}实体
* 类名 ${objectName}
*
*/

public class ${objectName} {
	private String id;

<#list fieldList as var>
	<#assign foo="${var[0]}">
	<#if var[1]=='Integer' >
		<#assign stradd=1>
    private Integer <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>; // ${var[2]}
	<#else>
		<#assign stradd=1>
    private String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>; // ${var[2]}
	</#if>
</#list>
		public String getId() {
		return id;
		}

		public void setId(String id) {
		this.id = id;
		}
<#list fieldList as var>
	<#assign foo="${var[0]}">
	<#if var[1]=='Integer' >
		<#assign stradd=1>
		<#assign foo="${var[0]}">
		<#if var[0]=='id' >
        public String getId() {
        return id;
        }
        public void setId(String id) {
        this.id = id;
        }
		<#else>
			<#assign stradd=1>
			<#assign stradda=1>
			<#assign straddb=1>
			<#assign straddc=1>
			<#assign straddd=1>
        public Integer get<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>() {
        return <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradda=stradda+1><#if stradda==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>;
        }
        public void  set<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>(Integer <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddb=straddb+1><#if straddb==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>) {
        this.<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddc=straddc+1><#if straddc==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if> = <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddd=straddd+1><#if straddd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>;
        }
		</#if>
	<#else>
		<#assign foo="${var[0]}">
		<#if var[0]=='id' >

		<#else>
			<#assign stradd=1>
			<#assign stradda=1>
			<#assign straddb=1>
			<#assign straddc=1>
			<#assign straddd=1>

        public String get<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>() {
        return <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradda=stradda+1><#if stradda==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>;
        }
        public void  set<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>(String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddb=straddb+1><#if straddb==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>) {
        this.<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddc=straddc+1><#if straddc==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if> = <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddd=straddd+1><#if straddd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>;
        }
		</#if>
	</#if>





</#list>

}
