package com.example.demo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.example.demo.config.DataUtil;

public class StepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("step执行前（step名：" + stepExecution.getStepName() + "）");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		System.out.println("step执行后（step名：" + stepExecution.getStepName() + "）");

		System.out.println("step执行后--------" + DataUtil.flg);
		return null;
	}

}
