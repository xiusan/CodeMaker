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

        //首字母大写
        objectName = objectName.substring(0,1).toUpperCase().concat(objectName.substring(1,objectName.length()));
        //获取包名
        String  packageName= getPackage(root.get("packageName").toString())+"/";

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
            List<String[]>  entityList = getTableList(pd,"entityIndexTap","entity");
            root.put("mysqlList", mysqlList);//获取mysql的所有参数
            root.put("entityList", entityList);//获取entity的所有参数
            Freemarker.printFile(strings[1],root,packageName+"entity/"+ objectName +  "Entity.java", filePath, ftlPath);
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
            root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人

            Freemarker.printFile(strings[1],root,packageName+"controller/"+ objectName +  "Controller.java", filePath, ftlPath);
            logger.info("生成"+strings[1]+"结束");

        }
        /*生成service*/
         if(strings[1].equals("serviceTemplate.ftl")){
             logger.info("生成"+strings[1]+"开始");
             root.put("controllerSelect", pd.get("controllerSelect")==null?"":pd.get("controllerSelect"));//获取生成查询
             root.put("controllerDelete", pd.get("controllerDelete")==null?"":pd.get("controllerDelete"));//获取生成删除
             root.put("controllerUpadte", pd.get("controllerUpadte")==null?"":pd.get("controllerUpadte"));//获取生成修改
             root.put("controllerAdd", pd.get("controllerAdd")==null?"":pd.get("controllerAdd"));//获取生成新增
             root.put("controllerExport", pd.get("controllerExport")==null?"":pd.get("controllerExport"));//获取生成导出
             root.put("controllerImport", pd.get("controllerImport")==null?"":pd.get("controllerImport"));//获取生成导入
             root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人
             Freemarker.printFile("serviceTemplate.ftl", root, packageName+"service/"+ objectName +  "Service.java", filePath, ftlPath);
             logger.info("生成"+strings[1]+"结束");
        }
		/*生成mapper*/
         if(strings[1].equals("mapperTemplate.ftl")){
             logger.info("生成"+strings[1]+"开始");
             root.put("controllerSelect", pd.get("controllerSelect")==null?"":pd.get("controllerSelect"));//获取生成查询
             root.put("controllerDelete", pd.get("controllerDelete")==null?"":pd.get("controllerDelete"));//获取生成删除
             root.put("controllerUpadte", pd.get("controllerUpadte")==null?"":pd.get("controllerUpadte"));//获取生成修改
             root.put("controllerAdd", pd.get("controllerAdd")==null?"":pd.get("controllerAdd"));//获取生成新增
             root.put("controllerExport", pd.get("controllerExport")==null?"":pd.get("controllerExport"));//获取生成导出
             root.put("controllerImport", pd.get("controllerImport")==null?"":pd.get("controllerImport"));//获取生成导入
             root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人
             Freemarker.printFile("mapperTemplate.ftl", root, packageName+"mapper/"+ objectName +  "Mapper.java", filePath, ftlPath);
             logger.info("生成"+strings[1]+"结束");
        }
		/*生成Provider*/
        if(strings[1].equals("ProviderTemplate.ftl")){
            logger.info("生成"+strings[1]+"开始");
            root.put("controllerSelect", pd.get("controllerSelect")==null?"":pd.get("controllerSelect"));//获取生成查询
            root.put("controllerDelete", pd.get("controllerDelete")==null?"":pd.get("controllerDelete"));//获取生成删除
            root.put("controllerUpadte", pd.get("controllerUpadte")==null?"":pd.get("controllerUpadte"));//获取生成修改
            root.put("controllerAdd", pd.get("controllerAdd")==null?"":pd.get("controllerAdd"));//获取生成新增
            root.put("controllerExport", pd.get("controllerExport")==null?"":pd.get("controllerExport"));//获取生成导出
            root.put("controllerImport", pd.get("controllerImport")==null?"":pd.get("controllerImport"));//获取生成导入
            root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人
            root.put("tableName", pd.get("tableName")==null?pd.get("tabletop")==null?"":pd.get("tabletop"):pd.get("tableName"));//表明

            List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");

            root.put("mysqlList", mysqlList);//获取mysql的所有参数

            Freemarker.printFile("ProviderTemplate.ftl", root, packageName+"mapper/"+ objectName +  "Provider.java", filePath, ftlPath);
            logger.info("生成"+strings[1]+"结束");
        }
		 /*生成HTML*/
        if(strings[1].equals("htmlTemplate.ftl")){
            List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
            List<String[]>  entityList = getTableList(pd,"entityIndexTap","entity");
            for (int i = 0; i < entityList.size(); i++) {
                mysqlList.add(entityList.get(i));

            }
            root.put("mysqlList", mysqlList);//获取mysql的所有参数
            Freemarker.printFile("htmlTemplate.ftl", root, "html/"+ objectName.toLowerCase() +  ".html", filePath, ftlPath);

        }
		/*生成index.xml  的菜单栏*/
        if(strings[1].equals("IndexTemplate.ftl")){
            Freemarker.printFile("IndexTemplate.ftl", root, "html/"+ objectName.toLowerCase() +  "index.html", filePath, ftlPath);

        }
		/*生成js*/
         if(strings[1].equals("jsTemplate.ftl")){
             List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
             root.put("mysqlList", mysqlList);//获取mysql的所有参数
             Freemarker.printFile("jsTemplate.ftl", root, objectName.toLowerCase()+"/"+ objectName.toLowerCase() +  ".js", filePath, ftlPath);

        }
		/*生成 *Operate.js*/
        if(strings[1].equals("jsOperateTemplate.ftl")){
            List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
            root.put("mysqlList", mysqlList);//获取mysql的所有参数
            Freemarker.printFile("jsOperateTemplate.ftl", root, objectName.toLowerCase()+"/"+ objectName.toLowerCase() +  "Operate.js", filePath, ftlPath);

        }

    }

    private String getPackage(String packageName) {

        String[] ba = packageName.split("\\.");
        String pack = "";
        for (int i = 0; i < ba.length; i++) {
            pack = ba[i];
        }
        return pack;
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
