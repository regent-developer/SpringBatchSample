package com.example.demo.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.dto.DataBean;

/**
 *
 */
public class Processor implements ItemProcessor<DataBean,DataBean> {
    @Override
    public DataBean process(DataBean data) throws Exception{

    	DataBean item = new DataBean();
    	item .setData1(data.getData1() + "test");
    	item .setData2(data.getData2() + "test");
        return  data;
    }
}
