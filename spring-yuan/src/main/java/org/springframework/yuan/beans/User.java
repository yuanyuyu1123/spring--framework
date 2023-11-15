package org.springframework.yuan.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	private Long id;
	private String name;
	private Integer age;
	//@Autowired
	private Toy toy;

	public User() {}

	@Autowired
	public User(Toy toy) {
		this.toy = toy;
	}

	//@Autowired
	public User(Long id, String name, Integer age, Toy toy) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.toy = toy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}
}
