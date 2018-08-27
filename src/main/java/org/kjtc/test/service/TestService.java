package org.kjtc.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kjtc.test.entity.TestEntity;
import org.kjtc.test.mapper.TestMapper;



/**
* 类名称：testService
* 创建人：root
* 创建时间：2018-08-27 15:23:39
* 描   述: 功能备注
*/

@Service("testService")
public class  TestService {

	@Autowired
	private TestMapper testMapper;

	/**
	* 查询列表
	* @param test
	* @return
	*/


	public List<TestEntity> getTestList(TestEntity testEntity) {

        return testMapper.getTestList(testEntity);

		}
	public int saveTest(TestEntity testEntity) {
		return testMapper.saveTest(testEntity);
		}
	public int updateTest(TestEntity testEntity) {
		return testMapper.updateTest(testEntity);
		}
	public int delTest(TestEntity testEntity) {
	return testMapper.delTest(testEntity);
		}
}