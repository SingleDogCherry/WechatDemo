package com.wechat.global.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.wechat.global.entity.Token;
import com.wechat.global.service.Manager.MyX509TrustManager;


public class HttpConnUtil {
	
	static Logger logger = LogManager.getLogger(HttpConnUtil.class.getName());
	private static Token token;
	private String appID;
	private String appSercet;
	public static  Token getToken() {
		
		
		
		
		String requestUrl = ;
		try {

			// 建立连接
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("GET");
			// 取得输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			// 读取响应内容
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			httpUrlConn.disconnect();
			// 输出返回结果
			System.out.println(buffer);
			JSONObject jsonObject = new JSONObject(buffer.toString());
			logger.info("access_token  :{}",jsonObject.getString("access_token") );
			logger.info("expires_in  :{}",jsonObject.getString("expires_in") );
			token.setAccessToken(jsonObject.getString("access_token"));
			token.setExpiresIn(Integer.valueOf(jsonObject.getString("expires_in")));
		} catch (ConnectException ce) {
			logger.error("连接超时：{}", ce);
		} catch (Exception e) {
			logger.error("https请求异常：{}", e);
		}
		return token;

	}
	public static void setToken(Token token) {
		HttpConnUtil.token = token;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getAppSercet() {
		return appSercet;
	}
	public void setAppSercet(String appSercet) {
		this.appSercet = appSercet;
	}
	
	
	

}
