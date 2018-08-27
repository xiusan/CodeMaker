package org.kjtc.test.mapper;

import org.kjtc.test.entity.TestEntity;






import org.apache.ibatis.jdbc.SQL;

import org.kjtc.util.StringUtils;


/**
* 类名称：TestProvider
* 创建人：root
* 创建时间：2018-08-27 15:23:39
* 描   述: 功能备注
*/


public class TestProvider {

		public String getTestList(TestEntity testEntity){

			StringBuffer sql = new StringBuffer();

				sql.append("SELECT  ");
                    	sql.append("  id, " );
                    	sql.append("  name, " );
                    	sql.append("  age, " );
                    	sql.append("  endtime, " );
                    	sql.append("  statime " );
				sql.append("  FROM  test ");//表名
				sql.append("   WHERE 1 = 1          ");


                    if (!StringUtils.isEmpty(testEntity.getName())) {
                    };

                    if (!StringUtils.isEmpty(testEntity.getAge())) {
                    };

                    if (!StringUtils.isEmpty(testEntity.getEndtime())) {
                    };

                    if (!StringUtils.isEmpty(testEntity.getStatime())) {
                    };
			return sql.toString();
		}


		public String saveTest(TestEntity testEntity){

					StringBuffer sql = new StringBuffer();
					sql.append("insert into test");
					sql.append(" test ");
					sql.append("(" );
					sql.append("id,");
					sql.append("name,");
					sql.append("age,");
					sql.append("endtime,");
					sql.append("statime");
					sql.append(") values ( " );
					sql.append("#{id},");
					sql.append("#{name},");
					sql.append("#{age},");
					sql.append("#{endtime},");
					sql.append("#{statime}");
					sql.append(")" );
				return sql.toString();
		}

		public String updateTest(TestEntity testEntity){

					StringBuffer sql = new StringBuffer();
					sql.append("update test set ");
							sql.append("id=#{id},");
							sql.append("name=#{name},");
							sql.append("age=#{age},");
							sql.append("endtime=#{endtime},");
							sql.append("statime=#{statime}");
							sql.append(" where  id=#{id}");
				return sql.toString();
		}

		public String delTest(TestEntity testEntity) {
						String newSql = "  test  where   id in (";
					String[] split =  testEntity.getId().split(",");
					for (int i = 0; i < split.length - 1; i++) {
					newSql += "'";
					newSql += split[i];
					newSql += "'";
					newSql += ",";
					}
					newSql += "'";
					newSql += split[split.length - 1];
					newSql += "'";
					newSql += ")";
					SQL sql = new SQL().DELETE_FROM(newSql);

			return sql.toString();
		}
}
