package config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement//spring을 통해 트랜잭션을 관리하겠
@MapperScan(basePackages= {"com.spring"})//매퍼의 위치 지정->찾아서 빈 등록 됨
public class MyBatisConfig {
	// 선택한 데이터 접근 방식에 대한 객체 빈 등록
	@Bean
	public DataSource dataSource() {
		String driverClassName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/simple-community?useUnicode=true";
		String username="root";
		String password="1234";
		//DriverManagerDataSource dataSource=new DriverManagerDataSource();//매번 새로 연결객체구함
		BasicDataSource dataSource=new BasicDataSource();//connection pooling지원
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	// 선택한 Session 공장	객체 빈 등록
	@Bean
	public SqlSessionFactory sqlSessionFactory()throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	// 선택한 Session 세션	객체 빈 등록
	@Bean
	public SqlSessionTemplate sqlSessionTemplate()throws Exception{
		return new  SqlSessionTemplate(sqlSessionFactory());		
	}
	//@EnableTransactionManagement하려면 transactionManager 빈 등록 해야함
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
