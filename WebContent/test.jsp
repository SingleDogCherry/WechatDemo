<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信公众号的测试页面</title>
</head>
<body>
<p>这是微信公众号的测试页面</p>
<s:form action="getTokenInfo" method="post" namespace="/token">
	<input type="submit" value="获取最新token">
</s:form>
</body>
</html>