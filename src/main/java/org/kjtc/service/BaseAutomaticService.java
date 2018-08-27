package org.kjtc.service;


import org.kjtc.entity.OutLineEntity;
import org.kjtc.entity.OutMysqlEntity;
import org.kjtc.mapper.BaseAutomaticMapper;
import org.kjtc.util.StringUtils;
import org.kjtc.util.createCode.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;


/**
 * Created by Administrator on 2018/8/10/010.
 */
@Service("baseAutomaticService")
public class BaseAutomaticService {


    @Autowired
    private BaseAutomaticMapper baseAutomaticMapper;


    public List<OutLineEntity> getQueryGaiYao() {
        return baseAutomaticMapper.getQueryGaiYao();
    }

    public List<OutMysqlEntity> getQueryMysql() {
        return baseAutomaticMapper.getQueryMysql();
    }

    public String querySqlShow(HttpServletResponse response, HttpServletRequest request) throws Exception {

        String path=request.getSession().getServletContext().getRealPath("/");
        System.out.println(path);
        PageData pd = new PageData();
        pd = this.getPageData();

        String objectName = pd.getString("objectName");            //项目名			========1
        String packageName = pd.getString("packageName")==null?"":pd.getString("packageName");                //包名称			========2
        String tabletop = pd.getString("tabletop");                //功能名称			========2
        String objectRemark = pd.getString("objectRemark");        //功能备注			========3
        Map<String, Object> root = new HashMap<String, Object>();        //创建数据模型
        //root.put("fieldList", fieldList);
        root.put("objectName", objectName);                        //项目名
        root.put("packageName", packageName);                        //包名
        root.put("tabletop", tabletop);                            //类名
        root.put("objectRemark", objectRemark);                    //备注
        root.put("nowDate", new Date());                            //当前日期

        List<String[]>  mysqlList = getTableList(pd,"mysqlIndexTap","mysql");
        root.put("mysqlList", mysqlList);//获取mysql的所有参数
        root.put("mysqlGrTable", pd.get("mysqlGrTable")==null?"":pd.get("mysqlGrTable"));//获取是否生成创建表
        root.put("mysqlDeleteTable", pd.get("mysqlDeleteTable")==null?"":pd.get("mysqlDeleteTable"));//获取是否删除表
        root.put("mysqlEditTable", pd.get("mysqlEditTable")==null?"":pd.get("mysqlEditTable"));//获取是否修改表
        root.put("mysqlAddTable", pd.get("mysqlAddTable")==null?"":pd.get("mysqlAddTable"));//获取是否新增
        root.put("controllerCreator", pd.get("controllerCreator")==null?"":pd.get("controllerCreator"));//创建人
        root.put("tableName", pd.get("tableName")==null?pd.get("tabletop")==null?"":pd.get("tabletop"):pd.get("tableName"));//表明

        DelAllFile.delFolder(PathUtil.getClasspath() + "admin/ftl"); //生成代码前,先清空之前生成的代码

        String filePath = "admin/ftl/code/";                        //存放路径
        String ftlPath = "createCode";                                //ftl路径

        Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql/mysql.sql", filePath, ftlPath);
        /*生成的全部代码压缩成zip文件*/
        String pathsql = StringUtils.getPath(PathUtil.getClasspath());
        System.out.println(pathsql);
        byte[]   bytes = FileUtil.getContent(pathsql+ "admin/ftl/code/mysql/"+"mysql.sql");
        String stru = new String(bytes);
        return stru;
    }

    /**
     * 得到PageData
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
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
            System.out.println();
        }
        List<String[]> gaiYaoList = new ArrayList<String[]>();    //属性集合
        for (int i = 0; i < zindex; i++) {
            gaiYaoList.add(pd.getString(nameTap + i).split(",fh,"));    //属性放到集合里面
        }
        return gaiYaoList;
    }

    public String insertFile(HttpServletResponse response, HttpServletRequest request, MultipartFile file) {
        String filePath = "D:"+ File.separator+"ftl"+ File.separator;
        System.out.println(file.getOriginalFilename());
        String str = StringUtils.getFileName(file.getOriginalFilename());
        FileUpload.fileUp(file,filePath,str);

        return "";
    }
}
