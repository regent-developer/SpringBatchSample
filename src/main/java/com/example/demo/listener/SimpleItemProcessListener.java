package com.example.demo.listener;

import org.springframework.batch.core.ItemProcessListener;

import com.example.demo.dto.DataBean;

public class SimpleItemProcessListener implements ItemProcessListener<DataBean, DataBean> {

	@Override
	public void beforeProcess(DataBean item) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemProcessListener.beforeProcess");
	}

	@Override
	public void afterProcess(DataBean item, DataBean result) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemProcessListener.afterProcess -- ");
	}

	@Override
	public void onProcessError(DataBean item, Exception e) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemProcessListener.onProcessError");
	}

}
