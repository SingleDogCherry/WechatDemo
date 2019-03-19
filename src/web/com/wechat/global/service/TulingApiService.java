package com.wechat.global.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 图灵API服务
 * */
public class TulingApiService {
	/**
	 * 文本类
	 * */
	public static final int TUCode_TEXT = 100000;

	/**
	 * 链接类
	 * */
	public static final int TUCode_URL = 200000;

	/**
	 * 新闻类
	 * */
	public static final int TUCode_NEWS = 302000;

	/**
	 * 菜谱类
	 * */
	public static final int TUCode_COOKBOOK = 308000;

	/**
	 * 儿歌类
	 * */
	public static final int TUCode_SONG = 313000;

	/**
	 * 诗歌类
	 * */
	public static final int TUCode_POEM = 314000;
	static Logger logger = LogManager.getLogger(TulingApiService.class.getName());
	public static String getTulingResult(String content, String userId) {
		//TODO  需要将url地址抽出来到配置文件当中
		String result = "";
		String apiUrl = "http://www.tuling123.com/openapi/api?key=ccd7218bc415492b9cd5283c9a9be117&info=";
		String param = "";
		try {
			param = apiUrl + URLEncoder.encode(content, "utf-8") + "&userid="
					+ URLEncoder.encode(userId, "utf-8");
			logger.info("--------------userid--------------------"
					+ userId);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 将参数转为url编码

		/** 发送httpget请求 */
		HttpGet request = new HttpGet(param);
		try {
			HttpResponse response = HttpClients.createDefault()
					.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 请求失败处理 */
		if (null == result) {
			logger.info("对不起，你说的话真是太高深了……");
			return "对不起，你说的话真是太高深了……";
		}

		try {
			JSONObject json = new JSONObject(result);
			System.out.println("--------------" + json.get("code"));
			// 以code=100000为例，参考图灵机器人api文档
			if (TUCode_TEXT == json.getInt("code")) {
				result = json.getString("text");
			} else if (TUCode_URL == json.getInt("code")) {
				result = json.getString("text") + "\n" + json.getString("url");
			} else if (TUCode_NEWS == json.getInt("code")) {
				result = "";
				JSONArray jArray = json.getJSONArray("list");
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject tJsonObject = jArray.getJSONObject(i);
					if (i>2) {
						break;
					}
					result = result  +"\n" + ";标题: " + tJsonObject.getString("article")
							+ ";地址: " + tJsonObject.getString("detailurl");
				}
				// TODO 这段对新闻列表的处理逻辑需要改进
				result = json.getString("text") + result;

			} else if (TUCode_COOKBOOK == json.getInt("code")) {
				result = json.getString("text") + "//\n"
						+ json.getString("url");
			} else if (TUCode_SONG == json.getInt("code")) {
				result = json.getString("text") + json.getString("url");
			} else if (TUCode_POEM == json.getInt("code")) {
				result = json.getString("text") + json.getString("url");
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		return result;
	}

}
