<#if packageName != ''>
package org.kjtc.${packageName}.entity;
<#else >
package org.kjtc.entity;
</#if>
/**
* ${objectRemark}实体
* 类名 ${tabletop?cap_first}
*
*/

public class ${tabletop?cap_first}Entity {

<#list entityList as var>
	<#assign foo="${var[0]}">
	<#if var[2]=='Integer' >
		<#assign stradd=1>
    private Integer <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>; // ${var[1]}
	<#elseif var[2]=='DATE' >
		<#assign stradd=1>
    private String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>; // ${var[1]}
		<#if var[6] == "是">
				<#assign straddStr=1>
			private String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddStr=straddStr+1><#if straddStr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str; // 开始${var[1]}
				<#assign straddEnd=1>
			private String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddEnd=straddEnd+1><#if straddEnd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end; // 结束${var[1]}
		</#if>
	<#else>
		<#assign stradd=1>
    private String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>; // ${var[1]}
	</#if>
</#list>

<#list entityList as var>
	<#assign foo="${var[0]}">
	<#if var[2]=='Integer' >
		<#assign stradd=1>
		<#assign foo="${var[0]}">

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
	<#elseif var[2]=='DATE' >
		<#assign foo="${var[0]}">

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
		<#if var[6] == "是">

					<#assign stradstr=1>
					<#assign straddbstr=1>
					<#assign straddcstr=1>
					<#assign stradddstr=1>

				public String get<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>str() {
				return <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradstr=stradstr+1><#if stradstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str;
				}
				public void  set<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>str(String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddbstr=straddbstr+1><#if straddbstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str) {
				this.<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddcstr=straddcstr+1><#if straddcstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str = <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradddstr=stradddstr+1><#if stradddstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str;
				}



					<#assign straddaend=1>
					<#assign straddbend=1>
					<#assign straddcend=1>
					<#assign stradddend=1>

				public String get<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>end() {
				return <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddaend=straddaend+1><#if straddaend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end;
				}
				public void  set<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign uijh=s?lower_case>${ uijh?cap_first}</#list><#else><#assign strlp=foo?lower_case>${strlp?cap_first}</#if>end(String <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddbend=straddbend+1><#if straddbend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end) {
				this.<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddcend=straddcend+1><#if straddcend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end = <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradddend=stradddend+1><#if stradddend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end;
				}
		</#if>
	<#else>
		<#assign foo="${var[0]}">

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
</#list>

}
