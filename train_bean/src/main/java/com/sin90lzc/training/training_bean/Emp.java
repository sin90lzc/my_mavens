package com.sin90lzc.training.training_bean;

import java.sql.Date;


public class Emp {
	private int id;
	private String name;
	private Job job;
	private double sal;
	private Date hireDate;
	private Date leaveDate;
	private Emp manager;

	public Emp() {

	}

	public Emp(int id) {
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public Emp getManager() {
		return manager;
	}

	public void setManager(Emp manager) {
		this.manager = manager;
	}
}
