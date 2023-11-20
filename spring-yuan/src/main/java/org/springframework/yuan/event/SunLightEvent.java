package org.springframework.yuan.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;

public class SunLightEvent extends ApplicationEvent {

	@Serial
	private final static long serialVersionUID = -1L;

	private static final Logger logger = LoggerFactory.getLogger(SunLightEvent.class);
	public SunLightEvent(Object source) {
		super(source);
	}

	public void printTime(){
		long currentTimeMillis = System.currentTimeMillis();
		logger.debug("currentTimeMillis = {}",currentTimeMillis);
	}
}
