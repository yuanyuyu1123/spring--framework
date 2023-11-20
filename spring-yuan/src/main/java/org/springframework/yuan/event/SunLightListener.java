package org.springframework.yuan.event;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class SunLightListener implements ApplicationListener<SunLightEvent> {

	private final static Logger logger = LoggerFactory.getLogger(SunLightEvent.class);
	@Override
	public void onApplicationEvent(@NotNull SunLightEvent event) {
		event.printTime();
		logger.debug("source = {}",event.getSource());
	}
}
