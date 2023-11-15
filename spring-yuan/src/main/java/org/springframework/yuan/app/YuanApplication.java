package org.springframework.yuan.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.yuan.AppConfig;
import org.springframework.yuan.beans.User;

public class YuanApplication {
	//private static final Logger logger = LoggerFactory.getLogger(YuanApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(context.getParent());
		User user = context.getBean("user", User.class);
		//logger.debug("user= {}",user);
		//System.out.println("user = "+user);
	}
}
