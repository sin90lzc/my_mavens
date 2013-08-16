package com.sin90lzc.training.training_spring_2.dao;

public class Dept {
	private int id;
	private String name;
	private String comment;

	public Dept() {
	}

	public Dept(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
