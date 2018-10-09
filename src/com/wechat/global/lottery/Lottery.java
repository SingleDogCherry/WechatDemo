package com.wechat.global.lottery;

import java.util.HashSet;

import com.wechat.global.entity.base.ClassBase;

public class Lottery extends ClassBase {
	private HashSet<String> lottery_red;
	private HashSet<String> lottery_blue;
	private String report_id;
	private String red_ball_1;
	private String red_ball_2;
	private String red_ball_3;
	private String red_ball_4;
	private String red_ball_5;
	private String blue_ball_1;

	public Lottery(String report_id, String red_ball_1, String red_ball_2, String red_ball_3, String red_ball_4,
			String red_ball_5, String blue_ball_1, String blue_ball_2) {
		super();
		this.report_id = report_id;
		this.red_ball_1 = red_ball_1;
		this.red_ball_2 = red_ball_2;
		this.red_ball_3 = red_ball_3;
		this.red_ball_4 = red_ball_4;
		this.red_ball_5 = red_ball_5;
		this.blue_ball_1 = blue_ball_1;
		this.blue_ball_2 = blue_ball_2;
		this.lottery_red.add(red_ball_1);
	}

	public Lottery(HashSet<String> lottery_red, HashSet<String> lottery_blue) {
		super();
		this.lottery_red = lottery_red;
		this.lottery_blue = lottery_blue;
	}

	public Lottery() {
		super();
	}

	public String getRed_ball_1() {
		return red_ball_1;
	}

	public void setRed_ball_1(String red_ball_1) {
		this.red_ball_1 = red_ball_1;
	}

	public String getRed_ball_2() {
		return red_ball_2;
	}

	public void setRed_ball_2(String red_ball_2) {
		this.red_ball_2 = red_ball_2;
	}

	public String getRed_ball_3() {
		return red_ball_3;
	}

	public void setRed_ball_3(String red_ball_3) {
		this.red_ball_3 = red_ball_3;
	}

	public String getRed_ball_4() {
		return red_ball_4;
	}

	public void setRed_ball_4(String red_ball_4) {
		this.red_ball_4 = red_ball_4;
	}

	public String getRed_ball_5() {
		return red_ball_5;
	}

	public void setRed_ball_5(String red_ball_5) {
		this.red_ball_5 = red_ball_5;
	}

	public String getBlue_ball_1() {
		return blue_ball_1;
	}

	public void setBlue_ball_1(String blue_ball_1) {
		this.blue_ball_1 = blue_ball_1;
	}

	public String getBlue_ball_2() {
		return blue_ball_2;
	}

	public void setBlue_ball_2(String blue_ball_2) {
		this.blue_ball_2 = blue_ball_2;
	}

	private String blue_ball_2;

	public HashSet<?> getLottery_red() {
		return lottery_red;
	}

	public void setLottery_red(HashSet<String> lottery_red) {
		this.lottery_red = lottery_red;
	}

	public HashSet<?> getLottery_blue() {
		return lottery_blue;
	}

	public void setLottery_blue(HashSet<String> lottery_blue) {
		this.lottery_blue = lottery_blue;
	}

	public String getReport_id() {
		return report_id;
	}

	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	@Override
	public String toString(){
		System.out.println("lottery的方法#########################################################################################################");
		System.out.println("lottery的方法#########################################################################################################");
		System.out.println("lottery的方法#########################################################################################################");
		return "所有类的基类方法";
	}
	
}
