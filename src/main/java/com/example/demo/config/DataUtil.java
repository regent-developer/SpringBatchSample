package com.example.demo.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class DataUtil {

	public static boolean flg;

	@PostConstruct
	public void init() {
		flg = false;
	}

	@PreDestroy
    public void destroy() {
        //系统运行结束
    }

}
