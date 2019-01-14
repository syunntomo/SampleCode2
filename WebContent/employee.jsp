<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>従業員登録画面</title>
	</head>
	<body>
		<div id="header"></div>

		<div id="main">
			<div id="top">
				<s:form action="LogoutAction">
					<s:submit value="ログアウト"/>
				</s:form>
			</div>

			<div id="main-form">
				<s:form>
					<s:select name="branchId" list="#session.branchCategoryList" listKey="branchId" listValue="branchName"/>
					<s:select name="departmentId" list="#session.departmentCategoryList" listKey="departmentId" listValue="departmentName"/>;
				</s:form>
			</div>

			<div id="error">
				<!-- 次のActionで使用する変数であることを忘れないこと -->
				<s:if test="errorMessage">
					<s:property value="errorMessage"/>
				</s:if>
			</div>
		</div>

		<div id="footer"></div>
	</body>
</html>