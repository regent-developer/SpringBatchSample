package com.example.demo.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DataBean;

//public class DBReader extends JdbcCursorItemReader<DataBean> {
//
////	@Value("${spring.datasource.url}")
////	private String url;
//
//	@Bean
//	public DataSource dataSource() {
//		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=GMT%2B8");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
//
//	public  DBReader() {
//		setDataSource(dataSource());
//		setSql("select data1, data2 from dataintbl");
//		setRowMapper(new DataBeanMapper());
//	}
//}
////@Override
////public DataBean read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
////	// TODO Auto-generated method stub
////	return null;
////}
@Service
public class DBReader implements ItemReader<DataBean> {

	@Override
	public DataBean read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		DataBean bean = new DataBean();
		bean.setData1("1");
		bean.setData2("2");

		return bean;
	}

}
