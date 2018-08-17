
<#if mysqlGrTable != ''>
DROP TABLE  ${tabletop};
-- 创建表
CREATE TABLE ${tabletop} (
	<#list mysqlList as var>
		<#if  var?size/2 == var_index >
			<#if var[2] == 'Integer'>
			${var[0]}  int(11)   <#if var[4] != '是'> NOT NULL </#if> COMMENT '${var[1]}',
			<#elseif var[2] == 'String'>
			${var[0]}   varchar(255)   <#if var[4] != '是'> NOT NULL </#if>     COMMENT '${var[1]}',
			<#else>
			${var[0]}   datetime <#if var[4] != '是'>  DEFAULT NULL </#if>   COMMENT '${var[1]}',
			</#if>
		<#else>
			<#if var[2] == 'Integer'>
			${var[0]}  int(11)   <#if var[4] != '是'> NOT NULL </#if> COMMENT '${var[1]}',
			<#elseif var[2] == 'String'>
			${var[0]}   varchar(255)   <#if var[4] != '是'> NOT NULL </#if>     COMMENT '${var[1]}',
			<#else>
			${var[0]}   datetime <#if var[4] != '是'>  DEFAULT NULL </#if>   COMMENT '${var[1]}',
			</#if>
		</#if>
	</#list>
	<#list mysqlList as var>
		<#if var[5] == '是'>
        -- 主键
        PRIMARY KEY (`${var[0]}`)
		</#if>
	</#list>
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

</#if>

<#if mysqlDeleteTable != ''>
-- 删除
DELETE FROM   ${tabletop};
</#if>

<#if mysqlEditTable != ''>
-- 修改
UPDATE SET  ${tabletop}
	<#list mysqlList as var>
		<#if  var?size/2 == var_index >
		${var[0]} = ''
		<#else>
		${var[0]} = '',
		</#if>

	</#list>
	<#list mysqlList as var>
		<#if var[5] == '是'>
        WHERE     ${var[0]}   =  ''
		</#if>
	</#list>
</#if>

<#if mysqlAddTable != ''>
	-- 新增
	insert into ${tabletop}(
		<#list mysqlList as var>
			<#if  var?size/2 == var_index >
			${var[0]} = ''
			<#else>
			${var[0]} = '',
			</#if>
		</#list>
	) values (
		<#list mysqlList as var>
			<#if  var?size/2 == var_index >
			  ''
			<#else>
			 '',
			</#if>
		</#list>
	)
</#if>





