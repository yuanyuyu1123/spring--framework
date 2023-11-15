package org.springframework.yuan.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Toy {

	//@Autowired
	private User user;

	public Toy() {}

	@Autowired
	public Toy(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
