<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Token的展示页面</title>
</head>
<body>
<s:form>
<s:bean name="com.wechat.global.hibernate.entity.Token" var="token" />
	<h1>token.createTime</h1>
<s:property value="token.createTime" />
<h1>token.accessToken</h1>
<s:property value="token.accessToken" />
<h1>accessToken</h1>
<s:property value="accessToken" />
<h1>accessToken</h1>
${accessToken }

</s:form>

</body>
</html>