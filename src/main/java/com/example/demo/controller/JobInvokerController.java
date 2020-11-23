package com.example.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class JobInvokerController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    private ApplicationContext applicationContext;


    //每20秒执行一次
	@Scheduled(cron = "*/20 * * * * ?")
	public void handleCsv() throws Exception {
	    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	              .toJobParameters();

	    jobLauncher.run(applicationContext.getBean("processCsvJob", Job.class), jobParameters);
	}

    //每20秒执行一次
    @Scheduled(cron = "*/20 * * * * ?")
    public void handleDB() throws Exception {
    	JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
              .toJobParameters();

        jobLauncher.run(applicationContext.getBean("processDBJob", Job.class), jobParameters);
    }

}
