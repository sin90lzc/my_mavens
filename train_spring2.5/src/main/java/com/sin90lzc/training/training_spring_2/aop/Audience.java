package com.sin90lzc.training.training_spring_2.aop;

//观众类
public class Audience {

	public Audience() {
	}

	// 表演前找座位
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	// 找到座位后关掉手机
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	// 表演精彩时鼓掌
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	// 表演槽糕时要求退票
	public void demandRefund() {
		System.out.println("Boo!We want our money back!");
	}
}
