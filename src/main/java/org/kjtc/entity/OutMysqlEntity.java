package org.kjtc.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/8/22/022.
 */

public class OutMysqlEntity {
    private String id;
    private String attributeName;
    private String attributeChinese;
    private String mysqlType;
    private String defaultValue;
    private String beEmpty;
    private String primaryKey;
    private String isQuery;
    private String queryType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeChinese() {
        return attributeChinese;
    }

    public void setAttributeChinese(String attributeChinese) {
        this.attributeChinese = attributeChinese;
    }

    public String getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(String mysqlType) {
        this.mysqlType = mysqlType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getBeEmpty() {
        return beEmpty;
    }

    public void setBeEmpty(String beEmpty) {
        this.beEmpty = beEmpty;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
