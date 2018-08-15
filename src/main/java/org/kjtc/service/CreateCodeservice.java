package org.kjtc.service;

import org.apache.log4j.Logger;
import org.kjtc.util.createCode.Freemarker;
import org.kjtc.util.createCode.PageData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojinlu  on 2018/8/10/010.
 */
@Service("createCodeservice")
public class CreateCodeservice {

    private static Logger logger = Logger.getLogger(CreateCodeservice.class);


    public  List<String[]>  getGaiyao(PageData pd) {
        //获取全部要生成的值
        String zindext = pd.getString("mysqlIndex");                    //属性总数
        int zindex = 0;
        if (null != zindext && !"".equals(zindext)) {
            zindex = Integer.parseInt(zindext);
        }
        List<String[]> gaiYaoList = new ArrayList<String[]>();    //属性集合
        for (int i = 0; i < zindex; i++) {
            gaiYaoList.add(pd.getString("field" + i).split(",fh,"));    //属性放到集合里面
        }
        return gaiYaoList;
    }

    /**
     * 创建生成代码
     * @param pd
     * @param strings
     * @param root
     * @param objectName
     * @param filePath
     * @param ftlPath
     */
    public void getCreatCode(PageData pd, String[] strings, Map<String, Object> root, String objectName, String filePath, String ftlPath) throws Exception {

        		/*生成  mysql*/
        if(strings[1].equals("mysql_SQL_Template.ftl")){

            logger.info("生成"+strings[1]+"开始");
            List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
            root.put("mysqlList", mysqlList);//获取mysql的所有参数
            root.put("mysqlGrTable", pd.get("mysqlGrTable")==null?"":pd.get("mysqlGrTable"));//获取是否生成创建表
            root.put("mysqlDeleteTable", pd.get("mysqlDeleteTable")==null?"":pd.get("mysqlDeleteTable"));//获取是否删除表
            root.put("mysqlEditTable", pd.get("mysqlEditTable")==null?"":pd.get("mysqlEditTable"));//获取是否修改表
            root.put("mysqlAddTable", pd.get("mysqlAddTable")==null?"":pd.get("mysqlAddTable"));//获取是否新增
            root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人


            Freemarker.printFile(strings[1],root,"mysql/"+ objectName +  "mysql.sql", filePath, ftlPath);
            logger.info("生成"+strings[1]+"结束");
        }

		/*生成 实体*/
        if(strings[1].equals("EntityTemplate.ftl")){
            logger.info("生成"+strings[1]+"开始");
            List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
            root.put("mysqlList", mysqlList);//获取mysql的所有参数
            Freemarker.printFile(strings[1],root,"entity/"+ objectName +  "Entity.java", filePath, ftlPath);
            logger.info("生成"+strings[1]+"结束");
        }

        /*生成controller*/
        if(strings[1].equals("controllerTemplate.ftl")){
            logger.info("生成"+strings[1]+"开始");
            root.put("controllerSelect", pd.get("controllerSelect")==null?"":pd.get("controllerSelect"));//获取生成查询
            root.put("controllerDelete", pd.get("controllerDelete")==null?"":pd.get("controllerDelete"));//获取生成删除
            root.put("controllerUpadte", pd.get("controllerUpadte")==null?"":pd.get("controllerUpadte"));//获取生成修改
            root.put("controllerAdd", pd.get("controllerAdd")==null?"":pd.get("controllerAdd"));//获取生成新增
            root.put("controllerExport", pd.get("controllerExport")==null?"":pd.get("controllerExport"));//获取生成导出
            root.put("controllerImport", pd.get("controllerImport")==null?"":pd.get("controllerImport"));//获取生成导入
            Freemarker.printFile(strings[1],root,"controller/"+ objectName +  "Controller.java", filePath, ftlPath);
            logger.info("生成"+strings[1]+"结束");

        }
        /*生成service*/
         if(strings[1].equals("serviceTemplate.ftl")){

        }
		/*生成mapper*/
         if(strings[1].equals("mapperTemplate.ftl")){

        }
		/*生成Provider*/
        if(strings[1].equals("ProviderTemplate.ftl")){

        }
		 /*生成HTML*/
        if(strings[1].equals("htmlTemplate.ftl")){

        }
		/*生成index.xml  的菜单栏*/
        if(strings[1].equals("IndexTemplate.ftl")){

        }
		/*生成js*/
         if(strings[1].equals("jsTemplate.ftl")){

        }
		/*生成 *Operate.js*/
        if(strings[1].equals("jsOperateTemplate.ftl")){

        }




      /*  *//*生成controller*//*
        Freemarker.printFile("controllerTemplate.ftl", root, "controller/" + objectName + "Controller.java", filePath, ftlPath);

		*//*生成service*//*
        Freemarker.printFile("serviceTemplate.ftl", root, "service/"+ objectName +  "Service.java", filePath, ftlPath);

		*//*生成mapper*//*
        Freemarker.printFile("mapperTemplate.ftl", root, "mapper/"+ objectName +  "Mapper.java", filePath, ftlPath);

		*//*生成Provider*//*
        Freemarker.printFile("ProviderTemplate.ftl", root, "mapper/"+ objectName +  "Provider.java", filePath, ftlPath);

		*//*生成HTML*//*
        Freemarker.printFile("htmlTemplate.ftl", root, "html/"+ objectName +  ".html", filePath, ftlPath);

		*//*生成index.xml  的菜单栏*//*
        Freemarker.printFile("IndexTemplate.ftl", root, "html/"+ objectName +  "index.html", filePath, ftlPath);

		*//*生成js*//*
        Freemarker.printFile("jsTemplate.ftl", root, objectName+"/"+ objectName +  ".js", filePath, ftlPath);

		*//*生成 *Operate.js*//*
        Freemarker.printFile("jsOperateTemplate.ftl", root, objectName+"/"+ objectName +  "Operate.js", filePath, ftlPath);

		*//*生成 实体*//*
        Freemarker.printFile("EntityTemplate.ftl", root, "entity/"+ objectName +  ".java", filePath, ftlPath);

		*//*生成 实体*//*
        Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql/"+ objectName +  "mysql.txt", filePath, ftlPath);
*/






    }

    /**
     *  获取参数
     * @param pd  所有参数
     * @param index 多少行
     * @param nameTap name中的值
     * @return
     */
    public  List<String[]>  getTableList(PageData pd,String index,String nameTap) {
        //获取全部要生成的值
        String zindext = pd.getString(index);                    //属性总数
        int zindex = 0;
        if (null != zindext && !"".equals(zindext)) {
            zindex = Integer.parseInt(zindext);
        }
        List<String[]> gaiYaoList = new ArrayList<String[]>();    //属性集合
        for (int i = 0; i < zindex; i++) {
            gaiYaoList.add(pd.getString(nameTap + i).split(",fh,"));    //属性放到集合里面
        }
        return gaiYaoList;
    }
}
