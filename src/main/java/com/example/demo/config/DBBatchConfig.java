package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dto.DataBean;
import com.example.demo.listener.JobListener;
import com.example.demo.listener.SimpleItemProcessListener;
import com.example.demo.listener.SimpleItemReadListener;
import com.example.demo.listener.SimpleItemWriteListener;
import com.example.demo.listener.StepListener;
import com.example.demo.reader.DBReader;
import com.example.demo.writer.Writer;

/**
 *
 */
@Configuration
@EnableBatchProcessing
public class DBBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
	public JdbcTemplate jdbcTemplate;

    @Bean
    public Job processDBJob(){
        return jobBuilderFactory.get("processDBJob")
                //.incrementer(new RunIdIncrementer())
                .listener(new JobListener()) // job监听器
                //.start(orderDBStep1("orderDBStep"))
                //.on("*").to(orderDBStep2("orderStep2")) // 成功场合你，执行 orderStep2
                //.from(orderStep("orderStep1")).on("FAILED").to(orderStep("orderStep3")) // 失败场合你，执行 orderStep3
			    //.end()
                .flow(orderDBStep1("orderDBStep")).end()
                .build();
    }

    @Bean
    public Step orderDBStep1(String stepName) {
    	Step step = null;
        try {
			return stepBuilderFactory.get(stepName)
					.listener(new StepListener()) // step监听器
					.<DataBean, DataBean> chunk(0)
			        //.reader(new DBReader()) // 读处理(DB)
			        .reader(dbDemoReader()) // 读处理(DB)
			        .listener(new SimpleItemReadListener())// ItemRead监听器
			       // .processor(new Processor()) // 数据处理
			        .listener(new SimpleItemProcessListener())// ItemProcess监听器
			        .writer(new Writer(jdbcTemplate)) // 写处理
			        .listener(new SimpleItemWriteListener())// ItemWrite监听器
			        .build();
		} catch (UnexpectedInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return step;
    }

    @Bean
    @StepScope
    public ItemReader<DataBean> dbDemoReader() {
//    	DataBean bean = new DataBean();
//		bean.setData1("1");
//		bean.setData2("2");
//
//		return bean;

    	DBReader reader = new DBReader();
    	return reader;

    }
//    @Bean
//    public Step orderDBStep2(String stepName) {
//    	Step step = null;
//        try {
//			return stepBuilderFactory.get(stepName)
//					.listener(new StepListener()) // step监听器
//					.<DataBean, DataBean> chunk(100)
//			        .reader(new DBReader()) // 读处理(DB)
//			        .listener(new SimpleItemReadListener())// ItemRead监听器
//			        .processor(new Processor()) // 数据处理
//			        .listener(new SimpleItemProcessListener())// ItemProcess监听器
//			        .writer(new Writer(jdbcTemplate)) // 写处理
//			        .listener(new SimpleItemWriteListener())// ItemWrite监听器
//			        .build();
//		} catch (UnexpectedInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return step;
//    }


}
