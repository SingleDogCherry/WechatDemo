package com.wechat.global.entity;

import java.util.Date;

import com.wechat.global.entity.base.ClassBase;

public class User extends ClassBase{
	/**
	 * 用户id
	 * */
	private int id;
	/**
	 * 用户名
	 * */
	private String name;
	/**
	 * 用户密码
	 * */
	private String pasword ;
	/**
	 * 邮箱
	 * */
	private String email;
	/**
	 *  生日
	 * */
	private Date birthday;
	/**
	 * 年龄
	 * */
	private int age;
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
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 @Override
	public void selfToString() {
		// TODO Auto-generated method stub
		super.selfToString();
		System.out.println("用户表:用户id"+this.id+"用户名"+this.name+"用户密码"+this.pasword);
	}

}
