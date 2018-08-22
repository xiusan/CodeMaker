package org.kjtc.mapper;


/**
 * Created by xiaojinlu  on 2018/8/10/010.
 */
public class BaseAutomaticProvider {


    public String queryGaiYaoList(){

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT    ");
        sql.append("id  AS id,");
        sql.append("or_not  AS orNot,");
        sql.append("model_type AS modelType,");
        sql.append("model_addr AS  modelAddr,  ");
        sql.append("model_suffix AS  modelSuffix  ");
        sql.append("FROM out_line  WHERE  1 = 1  ");

        return sql.toString();

    }

    public String queryMysqlList(){

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT    ");
        sql.append("	id	AS	id	,");
        sql.append("	attribute_name	AS	attributeName	,");
        sql.append("	attribute_chinese	AS	attributeChinese	,");
        sql.append("	mysql_type	AS	mysqlType	,");
        sql.append("	default_value	AS	defaultValue	,");
        sql.append("	be_empty	AS	beEmpty	,");
        sql.append("	primary_key	AS	primaryKey	,");
        sql.append("	Is_query	AS	IsQuery	,");
        sql.append("	query_type	AS	queryType	");
        sql.append(" FROM out_mysql  WHERE  1 = 1  ");
        return sql.toString();

    }
}
