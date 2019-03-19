package com.wechat.global.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import com.wechat.global.entity.base.ClassBase;

/**
 *   凭证实体
 * */
public class Token extends ClassBase  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 接口访问凭证
	private String accessToken;
	// 凭证有效期  单位  秒
	private int expiresIn;
	private int id;
	private Date createTime;
	
	public static String ID="id";
	public static  String REF="Token";
	public static String PROP_ACCESS_TOKEN="access_token";
	public static String PRO_EXPIRES_IN="expires_in";
	public static String PROP_DATE="create_Time";
	
	
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Token内容  accessToken："+accessToken+";expiresIn:"+expiresIn;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
