<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login画面</title>
	</head>
	<body>
		<div id="header"></div>

		<div id="main">
			<div id="top">
				<h2>ログインをして下さい</h2>
			</div>

			<div id="login_form">
				<s:form action="LoginAction">
					<s:textfield name="loginId"/>
					<s:password name="password"/>
					<s:submit value="ログイン"/>
				</s:form>
			</div>
		</div>

		<div id="footer"></div>
	</body>
</html>