package org.kjtc.mapper;


/**
 * Created by xiaojinlu  on 2018/8/10/010.
 */
public class BaseAutomaticProvider {


    public String queryGaiYaoList(){

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT    ");
        sql.append("or_not  AS orNot,");
        sql.append("model_type AS modelType,");
        sql.append("model_addr AS  modelAddr  ");
        sql.append("FROM out_line  WHERE  1 = 1  ");

        return sql.toString();

    }
}
