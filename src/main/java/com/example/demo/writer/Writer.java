package com.example.demo.writer;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dto.DataBean;

/**
 * Created by Administrator on 2018/12/4.
 */
//public class Writer implements ItemWriter<DataBean> {
//    @Override
//    public void write(List<? extends DataBean> messages) throws Exception{
//        for(DataBean msg:messages){
//            System.out.println("输出信息："+ msg.getData1());
//        }
//
//
//    }
//}

public class Writer implements ItemWriter<DataBean> {

	JdbcTemplate jdbcTemplate;

	public Writer(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void write(List<? extends DataBean> items) throws Exception {
		jdbcTemplate.batchUpdate("insert into dataouttbl (data1, data2) values(?, ?)",
				new BatchPreparedStatementSetter() {

					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, items.get(i)./*getDataBean().get(0)*/getData1());
						ps.setString(2, items.get(i)./*getDataBean().get(0).*/getData2());
					}

					public int getBatchSize() {
						return items.size();
					}

				});
	}

}
