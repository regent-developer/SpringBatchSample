package com.example.demo.listener;

import org.springframework.batch.core.ItemReadListener;

import com.example.demo.dto.DataBean;

public class SimpleItemReadListener implements ItemReadListener<DataBean> {

	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemReadListener.beforeRead");
	}

	@Override
	public void afterRead(DataBean item) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemReadListener.afterRead -- ");
	}

	@Override
	public void onReadError(Exception ex) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemReadListener.onReadError");
	}

}
