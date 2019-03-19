package com.wechat.global.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 验证方法类
 * 
 * */
public class TokenUtil {
	private final static String token = "mySingleDogHome";

	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return boolean
	 * */
	public static boolean validateSignature(String signature, String timestamp,
			String nonce) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(token);
		list.add(timestamp);
		list.add(nonce);
		Collections.sort(list);
		String string = "";
		for (int i = 0; i < list.size(); i++) {
			string += list.get(i);
		}
		String tmpStr=sha1(string);
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;

	}

	/**
	 * sha1加密算法
	 * 
	 * @param input
	 * @return output
	 * */
	public static String sha1(String input) {
		String output = "";
		MessageDigest md = null;
		try {
			md=MessageDigest.getInstance("SHA-1");
			//将string 转换成字符
			byte[] digest=md.digest(input.getBytes());
			output=byteToStr(digest);
		} catch (NoSuchAlgorithmException  e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return output;
	}

	/**
	 * 将字节数据转换成十六进制字符串
	 * 
	 * @param byteArray
	 * */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换成十六进制字符串
	 * 
	 * @param mByte
	 * @return 十六进制字符串
	 * */
	public static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;

	}

	/**
	 * 测试方法
	 * 
	 * */
	/*public static void main(String[] args) {

		boolean b = true;
		b = validateSignature("123", "a12", "try");
		System.out.println(b);

	}*/
	

}
