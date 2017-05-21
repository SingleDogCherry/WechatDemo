package com.wechat.global.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.wechat.global.entity.User;

public class DataBaseUtil {
	/**
	 * 数据库名
	 * */
	private String uname;
	/**
	 * 数据库密码
	 * */
	private String passwd;
	/**
	 * 数据库链接地址
	 * */
	private String connUrl;
	/**
	 * 数据库驱动名
	 * */
	private String driver;

	public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
		DataBaseUtil dBaseUtil = new DataBaseUtil();
		
			dBaseUtil.runTest();
		

	}
	public  void  runTest() throws SQLException,IOException, ClassNotFoundException{
		String sql = "select * from user";
		Connection connection = null;
		//connection = getConn();
		connection = getConn("src/resource/application.properties");
		if (null==connection) {
			System.out.println("空的数据库连接");
		}
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while (rSet.next()) {
				User user = new User();
				user.setId(rSet.getInt("id"));
				user.setName(rSet.getString("name"));
				user.setAge(rSet.getInt("age"));
				user.selfToString();
			}
			pstmt.close();
			rSet.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public Connection getConn(String path) throws SQLException{
		Connection ct = null;
		Properties properties=new Properties();
		try (InputStream io = Files.newInputStream(Paths.get(path))){
			properties.load(io);
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver=properties.getProperty("jdbc.driver");
		if (driver!=null) {
			System.setProperty("jdbc.driver", driver);
		} 
		passwd=properties.getProperty("jdbc.password");
		uname=properties.getProperty("jdbc.username");
		connUrl=properties.getProperty("jdbc.url");
		System.out.println("passwd:"+passwd+";uname:"+uname+";connUrl:"+connUrl);
		ct=DriverManager.getConnection(connUrl, uname, passwd);
		if (ct==null) {
			return null;
		}
		return ct;
	}
	
	
	
	/**
	 * 默认的数据库连接
	 * */
	public Connection getConn() throws ClassNotFoundException {
		Connection ct = null;
		
			uname = "root";
			passwd = "javaee";
			connUrl = "jdbc:mysql://localhost:3306/testDB";
			driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			try {
				ct = DriverManager.getConnection(connUrl, uname, passwd);
				if (null == ct) {
					System.out.println("创建数据库连接失败");
					return  null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ct;
			
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getConnUrl() {
		return connUrl;
	}

	public void setConnUrl(String connUrl) {
		this.connUrl = connUrl;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String className) {
		this.driver = className;
	}

}
