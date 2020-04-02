package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;
	// (200323) Mybatis 관련 설정
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void testMyBatis() {
		
		try(SqlSession session=sqlSessionFactory.openSession();
				Connection con=dataSource.getConnection();) {
			log.info(session);
			log.info(con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

//Bean에 등록된 Datasource를 이용해 Connection을 정상 처리하는지 확인