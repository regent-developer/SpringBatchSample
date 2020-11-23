package com.example.demo.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DataBeanMapper implements RowMapper<DataBean>{

	private static final String DATA1 = "data1";
    private static final String DATA2 = "data2";

	@Override
	public DataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DataBean bean = new DataBean();
		bean.setData1(rs.getString(DATA1));
		bean.setData2(rs.getString(DATA2));
		return bean;
	}

}
