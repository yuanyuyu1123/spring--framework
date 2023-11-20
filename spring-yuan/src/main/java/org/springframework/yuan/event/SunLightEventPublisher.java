package org.springframework.yuan.event;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SunLightEventPublisher implements ApplicationEventPublisher {
	private final Set<ApplicationListener<SunLightEvent>> listenerSet = new CopyOnWriteArraySet<>();

	public void addListener(ApplicationListener<SunLightEvent> listener){
		Assert.notNull(listener,"listener not is null!");
		listenerSet.add(listener);
	}

	public void removeListener(ApplicationListener<ApplicationEvent> listener){
		listenerSet.remove(listener);
	}

	@Override
	public void publishEvent(@NotNull Object event) {
		if(event instanceof SunLightEvent e){
			for (ApplicationListener<SunLightEvent> listener : listenerSet) {
				listener.onApplicationEvent(e);
			}
		}
	}
}
