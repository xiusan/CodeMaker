package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.${objectName};
import com.mogateway.mapper.${objectName}Mapper;


/**
* 类名称：${objectName}Service
* 创建人：
* 创建时间：${nowDate?string("yyyy-MM-dd")}
* 描   述:
*/

@Service("${objectNameLower}Service")
public class  ${objectName}Service {

	@Autowired
	private ${objectName}Mapper ${objectNameLower}Mapper;

	/**
	* 查询列表
	* @param ${objectNameLower}
	* @return
	*/
	public List<${objectName}> get${objectName}List(${objectName} ${objectNameLower}) {
		return ${objectNameLower}Mapper.get${objectName}List(${objectNameLower});
		}


	public int save${objectName}(${objectName} ${objectNameLower}) {
		return ${objectNameLower}Mapper.save${objectName}(${objectNameLower});
		}

	public int update${objectName}(${objectName} ${objectNameLower}) {
		return ${objectNameLower}Mapper.update${objectName}(${objectNameLower});
		}

	public int del${objectName}(${objectName} ${objectNameLower}) {
	return ${objectNameLower}Mapper.del${objectName}(${objectNameLower});
		}
}