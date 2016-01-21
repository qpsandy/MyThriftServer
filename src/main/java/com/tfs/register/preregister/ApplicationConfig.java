package com.tfs.register.preregister;

import java.io.File;

//import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//import com.tfs.register.preregister.mapper.CompanyMapper;
import com.tfs.register.preregister.mapper.UserMainMapper;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@Configuration
@MapperScan("com.tfs.register.preregister.mapper")
public class ApplicationConfig {

	@Autowired
	DataSourceProperties dataSourceProperties;
	DataSource dataSource;

	@Bean
	DataSource realDataSource() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.dataSourceProperties.getClassLoader())
				.url(this.dataSourceProperties.getUrl())
				.username(this.dataSourceProperties.getUsername())
				.password(this.dataSourceProperties.getPassword());
		this.dataSource = factory.build();
		return new Log4jdbcProxyDataSource(this.dataSource);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(realDataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources("classpath:/mapper/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}


//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	@Bean
//	Filter characterEncodingFilter() {
//		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//		filter.setEncoding("UTF-8");
//		filter.setForceEncoding(true);
//		return filter;
//	}
}
