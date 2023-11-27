package org.springframework.yuan.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.yuan.beans.User;

import java.lang.reflect.InvocationTargetException;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;

@Component
public class UserByteBuddy {
	public User getUser() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return new ByteBuddy()
				.with(new NamingStrategy.AbstractBase() {
					@Override
					protected @NotNull String name(@NotNull TypeDescription superClass) {
						return "i.love.ByteBuddy." + superClass.getSimpleName();
					}
				})
				.subclass(User.class)
				.defineField("sex", String.class)
				.method(named("setSex")).intercept(FixedValue.value("男"))
				.make()
				.load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
				.getLoaded()
				.getConstructor().newInstance();
	}
}
