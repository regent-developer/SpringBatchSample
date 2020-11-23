package com.example.demo.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.example.demo.dto.DataBean;

/**
 * Created by Administrator on 2018/12/4.
 */
public class CSVFileReader extends FlatFileItemReader<DataBean> {
	public CSVFileReader() {
		setResource(new FileSystemResource("E:\\Investigate\\Spring batch\\data.csv"));
		super.setLineMapper(new DefaultLineMapper<DataBean>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "data1", "data2" });
					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper<DataBean>() {
					{
						setTargetType(DataBean.class);
					}
				});
			}
		});
	}
}