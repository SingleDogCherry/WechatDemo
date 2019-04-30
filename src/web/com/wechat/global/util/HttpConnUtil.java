
package com.wechat.global.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

import com.wechat.global.hibernate.dao.standard.StandardTokenDao;
import com.wechat.global.hibernate.entity.Token;
import com.wechat.global.service.Manager.MyX509TrustManager;



public class HttpConnUtil {

	static Logger logger = LogManager.getLogger(HttpConnUtil.class.getName());
	private static Token token;
	private String appID;
	private String appSercet;
	private  static JSONObject json;
    private StandardTokenDao standardTokenDao;
	
	public static void main(String[] args) {
		token = new Token();
		 json = new JSONObject();
		 token = HttpConnUtil.getToken2();
		if (null!=token ) {
			HttpConnUtil.saveToken(token);
		} 
		
	}
	public static void saveToken2() {
		
	}
	
	
	
	public static void saveToken(Token  token) {

		
		Configuration configuation = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuation.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		@SuppressWarnings("unchecked")
		List<Token> result = session.createQuery("from Token ").list();

		for (Token token2 : (List<Token>) result) {
			logger.info("从数据库服务器取出的token 内容是"+token2.toString());
			//System.out.println("Token (" + Token.toString() + ") : " + Token.toString());
		}
		session.save(token);
		transaction.commit();
		session.close();
		System.out.println("结束了                                ------------------------------------------------");

	}

	public static Token getToken2()  {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7dacb74fd3ec7373&secret=c6a5fc7984a68ab251fc0eb24e07977e";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try {
			HttpGet httpGet = new HttpGet(requestUrl);
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			logger.info("返回状态:"+response1.getStatusLine().getStatusCode());
			if (HttpStatus.SC_OK==response1.getStatusLine().getStatusCode()) {
				HttpEntity entity1 = response1.getEntity();
				 json = new JSONObject(EntityUtils.toString(entity1));
				logger.info("返回内容:"+json.toString());
				try {
					token.setAccessToken((String)json.get("access_token"));
					token.setExpiresIn(Integer.parseInt((String)json.getString("expires_in")));
					token.setCreateTime(new Date());
					logger.info("当前时间为"+new Date());
					logger.info(token.toString());
					EntityUtils.consume(entity1);
				
				} catch (JSONException e) {
					// TODO: handle exception
					logger.error("获取token失败："+(String)json.getString("errmsg"));
					e.printStackTrace();
				}
				
				}
			else {
				logger.error("获取token失败：");
			}
			response1.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			logger.error("获取token失败：");
			e.printStackTrace();
		}
		logger.info("token 的内容"+token.toString());
		return token;
	}

	public static Token getToken() {
		String requestUrl = "";
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
			logger.info("access_token  :{}", jsonObject.getString("access_token"));
			logger.info("expires_in  :{}", jsonObject.getString("expires_in"));
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
	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
	public StandardTokenDao getStandardTokenDao() {
		return standardTokenDao;
	}
	public void setStandardTokenDao(StandardTokenDao standardTokenDao) {
		this.standardTokenDao = standardTokenDao;
	}

}
