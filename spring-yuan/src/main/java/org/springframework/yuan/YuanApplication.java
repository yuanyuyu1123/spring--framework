package org.springframework.yuan;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.StandardClassMetadata;
import org.springframework.util.ResourceUtils;
import org.springframework.yuan.beans.Toy;
import org.springframework.yuan.beans.User;
import org.springframework.yuan.bytebuddy.UserByteBuddy;
import org.springframework.yuan.config.AppConfig;
import org.springframework.yuan.event.SunLightEvent;
import org.springframework.yuan.event.SunLightEventPublisher;
import org.springframework.yuan.event.SunLightListener;
import org.springframework.yuan.yaml.YamlRead;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class YuanApplication {
	private static final Logger logger = LoggerFactory.getLogger(YuanApplication.class);
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = context.getBean("user", User.class);
		//Toy toy = context.getBean("toy", Toy.class);
		//logger.debug("user= {}",user);
		//logger.debug("toy= {}",toy.getUser());
		logger.debug("user = {}",user);
		//myEventHandle();
		context.close();

		//StandardClassMetadata standardClassMetadata = new StandardClassMetadata(SunLightEvent.class);

		//yamlHandle();
	}

	public static void myEventHandle(){
		SunLightEventPublisher publisher = new SunLightEventPublisher();
		ApplicationListener<SunLightEvent> listener = new SunLightListener();
		publisher.addListener(listener);
		publisher.publishEvent(new SunLightEvent("sunLight"));
	}

	public static void yamlHandle(){
		YamlRead yamlRead = new YamlRead();
		Map<String, Object> yamlMap = yamlRead.getYamlMap("application.yml");
		logger.debug("yamlMap = {}",yamlMap);
	}
}
