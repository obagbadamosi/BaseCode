<%@ include file="/IncludeTags.jsp" %>
<%@ include file="/IncludeCss.jsp" %>
	<title>Login</title>
<div id="login-body">
	<div class="paper border">
			<div class="logo">
				<img src="${appContextPath}/assets/images/clientlogo.jpg">
				<h3>eManager</h3>
			</div>
			<br><br>
			<form id="loginForm" name="form-login" action="${appContextPath}/login" method="post" novalidate="novalidate">
				<div class="form-element ">
					<label for="username" style="font-family: verdana;"><spring:message code="form.label.login.username" /></label>
	                <input type="text" id="username" name="username" value="" required ="required"
	                       title="Please enter your username"
	                       placeholder="<spring:message code="form.label.login.username" />">             
				</div>
				
				<div class="form-element">
					<label for="password" style="font-family: verdana;"><spring:message code="form.label.login.password" /></label>
	                <input type="password" id="password" name="password" value="" required="required"
	                       title="Please enter your password"
	                       placeholder="<spring:message code="form.label.login.password" />">
				</div>
				
				 <!-- Error message to show when there's an issue logging in -->
	             <c:if test="${(not empty param.login_error) and (SPRING_SECURITY_LAST_EXCEPTION != null) }">
	             	<div id="loginErrorMsg" class="alert alert-danger">
	                 	<spring:message code="error.login.unsuccessfulLogin"/>
	                    <br><br>
	                    <spring:message code="error.login.reason"/>:&nbsp;<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
	                </div>
	             </c:if>
				
				<div class="form-element">
					<button type="submit" class="button">
	                	<spring:message code="form.button.login"/>
	                </button>
				</div>
				<sec:csrfInput />
			</form>
		</div>
</div>