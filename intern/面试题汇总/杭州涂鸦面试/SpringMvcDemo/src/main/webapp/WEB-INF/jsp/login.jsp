<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>SpringMvcDemo</title>
<%@include file="/WEB-INF/jsp/include/meta.jsp"%>
<%@include file="/WEB-INF/jsp/include/easyui.jsp"%>
</head>
<body>

	<form action="${path}/login" method="post">
		<h1>登 录</h1>
		<p>
			<label for="username" class="uname" data-icon="u"> 用户名 ：</label> 
			<input	id="username" name="username" required="required" type="text"
				placeholder="请输入用户名" />
		</p>
		<p>
			<label for="password" class="youpasswd" data-icon="p"> 密 码 ：</label>
			<input id="password" name="password" required="required"
				type="password" placeholder="请输入密码" />
		</p>

		<c:if test="${message!=null}">
									${message}
								</c:if>
		<p class="login button">
			<input type="submit" value="登 录" />
		</p>
	</form>

</body>
</html>