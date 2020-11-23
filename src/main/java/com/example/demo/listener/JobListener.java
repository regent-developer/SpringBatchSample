package com.example.demo.listener;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.example.demo.config.DataUtil;

/**
 * Created by Administrator on 2018/12/4.
 */
public class JobListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(JobExecution jobExecution){

        if(jobExecution.getStatus()== BatchStatus.STARTED){
            System.out.println("批处理执行开始...." + jobExecution.getJobInstance().getJobName());
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution){
    	DataUtil.flg = false;
        if(jobExecution.getStatus()== BatchStatus.COMPLETED){
            System.out.println("批处理执行结束....");
        }else if (jobExecution.getStatus()== BatchStatus.FAILED) {
        	System.out.println("批处理执行结束(错误)....");
        }else {
        	System.out.println("批处理执行结束(错误)...." + jobExecution.getStatus());
        }
    }
}
