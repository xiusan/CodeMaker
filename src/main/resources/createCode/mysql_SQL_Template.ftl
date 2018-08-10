
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `${tabletop}`
-- ----------------------------
DROP TABLE IF EXISTS `${tabletop}`;
CREATE TABLE `${tabletop}` (
	<#list fieldList as var>
		<#if var[1] == 'Integer'>
		`${var[0]}` int(11) NOT NULL COMMENT '${var[2]}',
		<#elseif var[1] == 'String'>
        `${var[0]}` DATETIME NOT NULL COMMENT '${var[2]}',
		<#else>
		`${var[0]}` varchar(255) DEFAULT NULL COMMENT '${var[2]}',
		</#if>
	</#list>
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
