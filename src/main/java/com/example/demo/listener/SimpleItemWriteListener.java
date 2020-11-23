package com.example.demo.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.example.demo.dto.DataBean;

public class SimpleItemWriteListener implements ItemWriteListener<DataBean>{

	@Override
	public void beforeWrite(List<? extends DataBean> items) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemWriteListener.beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends DataBean> items) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemWriteListener.afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends DataBean> items) {
		// TODO Auto-generated method stub
		System.out.println("SimpleItemWriteListener.onWriteError");
	}
}
