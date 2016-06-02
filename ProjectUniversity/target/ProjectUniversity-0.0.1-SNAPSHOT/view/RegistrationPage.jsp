<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! String accessLevel = null;%>
<%accessLevel=request.getParameter("accessLevel");
if(accessLevel == null){%>
	<form action="view/RegistrationPage.jsp">
		<select name = "accessLevel">
			<option value="student">студент</option>
			<option value="teacher">викладач</option>
			<option value="admin">адмін</option>
		</select>
	<input type="submit" value="Вибрати"> 
	</form>
<%}else{
	if(accessLevel.equals("student")){
		request.setAttribute("accessLevel", "student");%>
		<form method="POST" action="/ProjectUniversity/registration">
			name:</br><input type="text" name="name" ><br /><br />
			surname:</br><input type="text" name="surname"><br /><br />
			age:</br><input type="text" name="age"><br /><br />
			sex:</br>
			<select name="sex">
				<option value="man">Чоловік</option>
				<option value="woman">Жінка</option>
			</select><br /><br />
			grup:</br><input type="text" name="grup"><br /><br />
			login:</br><input type="text" name="login" value=<% out.print(request.getAttribute("login"));%>><br /><br />
			password:</br><input type="text" name="password" value=<% out.print(request.getAttribute("password"));%>><br /><br />
			confirm password:</br><input type="text" name="confirmPassword" ><br /><br />
			<input type="submit" name="submitRegistration" value="Registration">
			<input type="reset" value="Reset"><br />
		</form>
	<%}else{
	  		if(accessLevel.equals("teacher")){
	  			request.setAttribute("accessLevel", "teacher");%>
	  			<form method="POST" action="/ProjectUniversity/registration">
					name:</br><input type="text" name="name" ><br /><br />
					surname:</br><input type="text" name="surname"><br /><br />
					age:</br><input type="text" name="age"><br /><br />
					sex:</br>
					<select name="sex">
						<option value="man">Чоловік</option>
						<option value="woman">Жінка</option>
					</select><br /><br />
					position:</br><input type="text" name="position"><br /><br />
					login:</br><input type="text" name="login" value=<% out.print(request.getAttribute("login"));%>><br /><br />
					password:</br><input type="text" name="password" value=<% out.print(request.getAttribute("password"));%>><br /><br />
					confirm password:</br><input type="text" name="confirmPassword" ><br /><br />
					<input type="submit" name="submitRegistration" value="Registration">
					<input type="reset" value="Reset"><br />
				</form>
	  		<%}else{
	  				if(accessLevel.equals("admin")){
	  		  			request.setAttribute("accessLevel", "admin");%>
			  			<form method="POST" action="/ProjectUniversity/registration">
							name:</br><input type="text" name="name" ><br /><br />
							surname:</br><input type="text" name="surname"><br /><br />
							login:</br><input type="text" name="login" value=<% out.print(request.getAttribute("login"));%>><br /><br />
							password:</br><input type="text" name="password" value=<% out.print(request.getAttribute("password"));%>><br /><br />
							confirm password:</br><input type="text" name="confirmPassword" ><br /><br />
							<input type="submit" name="submitRegistration" value="Registration">
							<input type="reset" value="Reset"><br />
						</form>			
	  				<%}
	  		  }
	  }
}%>

</body>
</html>