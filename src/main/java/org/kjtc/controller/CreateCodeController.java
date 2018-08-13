package org.kjtc.controller;

import org.kjtc.service.CreateCodeservice;
import org.kjtc.util.StringUtils;
import org.kjtc.util.createCode.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CreateCodeController {

	private static Logger logger = Logger.getLogger(CreateCodeController.class);

	@Autowired
	private CreateCodeservice createCodeservice;


	/**
	 * 代码生成映射到Html
	 * @return
	 */
	@RequestMapping(value = "/createcode")
	public String operatorInfoPage(){
		return "create_code";
	}

	/**
	 * 生成代码
	 */
	@RequestMapping(value = "/proCode")
	public void proCode(HttpServletResponse response) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();

		String objectName = pd.getString("objectName");            //项目名			========1
		String tabletop = pd.getString("tabletop");                //功能名称			========2
		String objectRemark = pd.getString("objectRemark");        //功能备注			========3


		Map<String, Object> root = new HashMap<String, Object>();        //创建数据模型
		//root.put("fieldList", fieldList);
		root.put("objectName", objectName);                        //包名
		root.put("tabletop", tabletop);                            //类名
		root.put("objectRemark", objectRemark);                    //备注
		root.put("nowDate", new Date());                            //当前日期

		DelAllFile.delFolder(PathUtil.getClasspath() + "admin/ftl"); //生成代码前,先清空之前生成的代码

		//获取概要参数  //判断是否生成对应的代码
		List<String[]> gaiYaoList  = createCodeservice.getGaiyao(pd);

		logger.info("========开始生产代码========");
		String filePath = "admin/ftl/code/";                        //存放路径
		String ftlPath = "createCode";
		//判断是否生成对应的代码
		for (String[] strings : gaiYaoList) {
			if (strings[0].equals("是")){
				System.out.println(strings[1]);
				createCodeservice.getCreatCode(pd,strings,root,objectName ,filePath, ftlPath);
			}else {
				logger.info(strings[1]+"用户不需要生成");
			}
		}

    //ftl路径
	/*
		*//*生成controller*//*
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


		
		/*生成的全部代码压缩成zip文件*/
		FileZip.zip(PathUtil.getClasspath() + "admin/ftl/code", PathUtil.getClasspath() + "admin/ftl/code.zip");
		
		/*下载代码*/
		FileDownload.fileDownload(response, PathUtil.getClasspath() + "admin/ftl/code.zip", "code.zip");
		logger.info("========结束生产代码========");
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


}